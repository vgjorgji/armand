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
public class UserSettingsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WebsiteUserRepository websiteUserRepository;
	
	
	/**
	 * Returns the userSettings for the given username.
	 * 
	 * @param username to search for
	 * @return userSettings
	 */
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
	
	/**
	 * Changes the properties in userSettings according to the given website.
	 * 
	 * @param userSettings to change
	 * @param website to use
	 */
	public void changeSettingsForWebsite(UserSettings userSettings, Website website) {
		// find
		WebsiteUser websiteUser = null;
		if (userSettings.getId() != -1) {
			websiteUser = websiteUserRepository.getWebsiteUser(userSettings.getId(), website.getId());
		}
		// set
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
		if (websiteUser != null) {
			language = getUserLanguageForWebsite(userSettings, website, websiteUser);
		}
		// fall-back
		if (language == null) {
			language = UserSettings.DEFAULT_LANGUAGE;
		}
		// set language
		userSettings.setLanguage(language);
	}
	
	private Language getUserLanguageForWebsite(UserSettings userSettings, Website website, WebsiteUser websiteUser) {
		Language websiteLanguage = null;

		// 1. has webiste
		if (website != null) {
			if (CollectionUtils.isEmpty(website.getLanguages())) {
				throw new IllegalStateException("No Languages defined for website: " + website);
			}

			// has set language: validate against the website languages
			if (websiteUser.getLanguage() != null) {
				if (website.getLanguages().contains(websiteUser.getLanguage())) {
					websiteLanguage = websiteUser.getLanguage();
				} else {
					websiteLanguage = website.getPrimaryLanguage();
				}

			} else {
				websiteLanguage = website.getPrimaryLanguage();
			}

		} else {
			// 2. no website, use only language
			if (websiteUser.getLanguage() != null) {
				websiteLanguage = websiteUser.getLanguage();
			}
		}

		// user language for the website, can be null
		return websiteLanguage;
	}
	
}
