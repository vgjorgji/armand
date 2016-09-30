package com.vcms.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;
import com.vcms.user.model.UserSettings;
import com.vcms.user.model.UserWebsiteRepository;

@Service
public class UserSettingsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserWebsiteRepository userWebsiteRepository;

	public UserSettings getUserSettings(String username) {
		User user = userRepository.getUser(username);
		if (user == null) {
			return null;
		}
		user.setUserWebsites(userWebsiteRepository.getWebsitesForUser(user.getId()));
		
		// user settings
		UserSettings userSettings = new UserSettings();
		userSettings.setUser(user);
		userSettings.resolveSettings();
		return userSettings;
	}
	
}
