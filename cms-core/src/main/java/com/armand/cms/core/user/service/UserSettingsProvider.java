package com.armand.cms.core.user.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.armand.cms.core.user.model.UserSettings;

public class UserSettingsProvider {

  public static UserSettings getCurrentUser() {
    Authentication authentication = UserSettingsProvider.getAuthentication(false);
    return (UserSettings) authentication.getPrincipal();
  }

  public static UserSettings getCurrentUserRelax() {
    Authentication authentication = UserSettingsProvider.getAuthentication(true);
    return authentication != null ? (UserSettings) authentication.getPrincipal() : null;
  }

  private static Authentication getAuthentication(boolean relax) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null && !relax) {
      throw new IllegalStateException("No authentication found");
    }
    return authentication;
  }

}
