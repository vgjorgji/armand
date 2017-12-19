package com.armand.cms.core.user.service;

import com.armand.cms.core.user.model.UserSettings;
import com.armand.cms.core.website.model.Website;

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
