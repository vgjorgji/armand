package com.vcms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vcms.user.model.UserSettings;
import com.vcms.user.service.UserSettingsProvider;
import com.vcms.web.conf.AdminSecurityConfiguration;

@Controller
public class LoginController {
	
	@RequestMapping(value = AdminSecurityConfiguration.LOGIN_PAGE_URL, method = RequestMethod.GET)
	public String getLoginPage() {
		UserSettings userSettings = UserSettingsProvider.getCurrentUser();
		if (!userSettings.isVisitor()) {
			return "redirect:/dashboard";
		}
		return "/login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage() {
		return "redirect:/dashboard";
	}

}
