package com.vcms.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vcms.user.model.UserSettings;
import com.vcms.user.service.UserSettingsProvider;
import com.vcms.web.service.ClientConfigurationService;

public class ClientVisitorInterceptor implements HandlerInterceptor {
	
	@Autowired
	private ClientConfigurationService clientConfigurationService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		UserSettings userSettings = UserSettingsProvider.getCurrentUser();
		if (userSettings.getSelectedWebsite() == null) {
			userSettings.setSelectedWebsite(clientConfigurationService.getWebsite());
			userSettings.resolveSettings();
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
