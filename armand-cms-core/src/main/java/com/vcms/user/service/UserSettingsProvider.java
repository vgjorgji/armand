package com.vcms.user.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vcms.user.model.UserSettings;

public class UserSettingsProvider {
	
	public static UserSettings getCurrentUser() {
		Authentication authentication = UserSettingsProvider.getAuthentication();
		return (UserSettings) authentication.getPrincipal();
	}
	
	private static Authentication getAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			throw new IllegalStateException("No authentication found");
		}
		return authentication;
	}

}
