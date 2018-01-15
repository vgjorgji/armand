package com.armand.cms.web.client.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.armand.cms.core.user.model.UserSettings;
import com.armand.cms.core.user.service.UserSettingsProvider;
import com.armand.cms.core.user.service.UserSettingsService;
import com.armand.cms.web.client.service.ClientConfigurationService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientVisitorInterceptor implements HandlerInterceptor {

  private final ClientConfigurationService clientConfigurationService;
  private final UserSettingsService userSettingsService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();
    if (userSettings.getSelectedWebsiteId() == -1) {
      userSettingsService.changeSettingsForWebsite(userSettings, clientConfigurationService.getWebsite());
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                         ModelAndView modelAndView) {
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
  }
}
