package com.armand.cms.web.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.armand.cms.core.user.model.UserSettings;
import com.armand.cms.core.user.service.UserSettingsProvider;
import com.armand.cms.core.user.service.UserSettingsService;
import com.armand.cms.core.website.model.Website;
import com.armand.cms.core.website.model.WebsiteRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SelectedWebsiteInterceptor implements HandlerInterceptor {

  private static final String WEBSITE_START_URI = "/website/";

  private final UserSettingsService userSettingsService;
  private final WebsiteRepository websiteRepository;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    String uri = request.getRequestURI();
    String fullStartUri = request.getContextPath() + WEBSITE_START_URI;
    if (uri.startsWith(fullStartUri)) {

      // find the websiteId
      String uriStrip = uri.substring(fullStartUri.length());
      long websiteId = Long.parseLong(uriStrip.substring(0, uriStrip.indexOf('/')));

      // check if change is needed
      UserSettings userSettings = UserSettingsProvider.getCurrentUser();
      if (userSettings.getSelectedWebsiteId() != websiteId) {

        // change the website
        Website website = websiteRepository.getModel(websiteId);
        userSettingsService.changeSettingsForWebsite(userSettings, website);
      }
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
