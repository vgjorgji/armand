package com.armand.cms.core.user.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.user.model.Role;
import com.armand.cms.core.user.model.User;
import com.armand.cms.core.user.model.UserRepository;
import com.armand.cms.core.user.model.UserSettings;
import com.armand.cms.core.user.model.WebsiteUser;
import com.armand.cms.core.user.model.WebsiteUserRepository;
import com.armand.cms.core.website.model.Website;
import com.armand.cms.core.website.model.WebsiteView;
import com.armand.cms.core.website.model.WebsiteViewRepository;
import com.armand.cms.core.website.model.WebsiteViewType;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSettingsServiceImpl implements UserSettingsService {

  private final UserRepository userRepository;
  private final WebsiteUserRepository websiteUserRepository;
  private final WebsiteViewRepository websiteViewRepository;

  @Override
  public UserSettings getUserSettings(String username) {
    User user = userRepository.getUser(username);
    if (user == null) {
      return null;
    }

    // user settings
    UserSettings userSettings = new UserSettings();
    userSettings.setUser(user);
    return userSettings;
  }

  @Override
  public void changeSettingsForWebsite(UserSettings userSettings, Website website) {
    // find
    WebsiteUser websiteUser = null;
    WebsiteView websiteViewDesign = null;
    WebsiteView websiteViewContent = null;
    WebsiteView websiteViewLive = null;
    if (userSettings.hasUser() && website != null) {
      websiteUser = websiteUserRepository.getModel(userSettings.getId(), website.getId());
      websiteViewDesign = websiteViewRepository.getModel(website.getId(), WebsiteViewType.Design);
      websiteViewContent = websiteViewRepository.getModel(website.getId(), WebsiteViewType.Content);
      websiteViewLive = websiteViewRepository.getModel(website.getId(), WebsiteViewType.Live);
    }
    // set
    userSettings.setSelectedWebsiteId(website != null ? website.getId() : -1);
    userSettings.setSelectedWebsiteUserId(websiteUser != null ? websiteUser.getId() : -1);
    // shortcuts
    userSettings.setSelectedWebsiteName(website != null ? website.getName() : "");
    userSettings.setSelectedWebsiteViewIdDesign(websiteViewDesign != null ? websiteViewDesign.getId() : -1);
    userSettings.setSelectedWebsiteViewIdContent(websiteViewContent != null ? websiteViewContent.getId() : -1);
    userSettings.setSelectedWebsiteViewIdLive(websiteViewLive != null ? websiteViewLive.getId() : -1);
    // resolve
    resolveRoles(userSettings, website, websiteUser);
    resolveLanguage(userSettings, website, websiteUser);
  }

  private void resolveRoles(UserSettings userSettings, Website website, WebsiteUser websiteUser) {
    Set<Role> roles = null;
    // use websiteUser
    if (websiteUser != null) {
      roles = websiteUser.getPowerGroup().getRolesForCmsPackage(website.getCmsPackage());
    }
    // fall-back
    if (CollectionUtils.isEmpty(roles)) {
      roles = UserSettings.DEFAULT_ROLES;
    }
    // set roles
    userSettings.setRoles(roles);
  }

  private void resolveLanguage(UserSettings userSettings, Website website, WebsiteUser websiteUser) {
    Language language = null;

    // 1. has webiste
    if (website != null) {
      if (CollectionUtils.isEmpty(website.getLanguages())) {
        throw new IllegalStateException("No Languages defined for website: " + website);
      }

      // get language from websiteUser or just from user
      Language languageCandidate = null;
      if (userSettings.hasUser()) {
        languageCandidate = userSettings.getUser().getLanguage();
      }
      if (websiteUser != null) {
        languageCandidate = websiteUser.getLanguage();
      }

      // has set language: validate against the website languages
      if (languageCandidate != null) {
        if (website.getLanguages().contains(languageCandidate)) {
          language = languageCandidate;
        } else {
          language = website.getPrimaryLanguage();
        }
      } else {
        language = website.getPrimaryLanguage();
      }

    } else if (userSettings.hasUser()) {
      // 2. no website, use user
      language = userSettings.getUser().getLanguage();
    }

    // fall-back
    if (language == null) {
      language = UserSettings.DEFAULT_LANGUAGE;
    }

    // set language
    userSettings.setLanguage(language);
  }

}
