package com.armand.cms.core.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.armand.cms.core.user.model.UserSettings;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserSettingsService userSettingsService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserSettings userSettings = userSettingsService.getUserSettings(username);
    if (userSettings == null) {
      throw new UsernameNotFoundException("No User with username: " + username);
    }
    return userSettings;
  }

}
