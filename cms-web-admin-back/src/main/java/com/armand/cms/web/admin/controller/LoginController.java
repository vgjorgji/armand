package com.armand.cms.web.admin.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.armand.cms.core.user.model.UserSettings;
import com.armand.cms.core.user.service.UserSettingsProvider;
import com.armand.cms.web.admin.spring.AdminSecurityConfiguration;

@Controller
public class LoginController {

  private static final String START_PAGE = "/index.html";

  @RequestMapping(value = AdminSecurityConfiguration.LOGIN_PAGE_URL, method = RequestMethod.GET)
  public String getLoginPage() {
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();
    if (!userSettings.isVisitor()) {
      return "redirect:" + START_PAGE;
    }
    return "login";
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getHomePage() {
    return "redirect:" + START_PAGE;
  }

  @RequestMapping(value = AdminSecurityConfiguration.LOGOUT_PAGE_URL)
  public String logout(HttpServletRequest request) throws ServletException {
    request.logout();
    return "login";
  }

}
