package com.vcms.user.service;

import com.vcms.user.model.UserSettings;
import com.vcms.website.model.Website;

public interface UserSettingsService {
	
	/**
	 * Returns the userSettings for the given username.
	 * 
	 * @param username to search for
	 * @return userSettings
	 */
	UserSettings getUserSettings(String username);
	
	/**
	 * Changes the properties in userSettings according to the given website.
	 * 
	 * @param userSettings to change
	 * @param website to use
	 */
	void changeSettingsForWebsite(UserSettings userSettings, Website website);	
}
