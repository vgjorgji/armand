package com.vcms.user.service;

import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcms.localization.model.Language;
import com.vcms.user.model.Role;
import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;
import com.vcms.user.model.UserSettings;
import com.vcms.user.model.WebsiteUser;
import com.vcms.user.model.WebsiteUserRepository;
import com.vcms.website.model.Website;

@Service
public class UserSettingsServiceImpl implements UserSettingsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WebsiteUserRepository websiteUserRepository;
	
	
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
		if (userSettings.hasUser() && website != null) {
			websiteUser = websiteUserRepository.getModel(userSettings.getId(), website.getId());
		}
		// set
		userSettings.setSelectedWebsite(website);
		userSettings.setSelectedWebsiteUser(websiteUser);
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
