package com.armand.cms.web.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vcms.user.model.UserSettings;
import com.vcms.user.service.UserSettingsProvider;
import com.vcms.user.service.UserSettingsService;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;

public class SelectedWebsiteInterceptor implements HandlerInterceptor {
	
	private static final String WEBSITE_START_URI = "/website/";
	
	@Autowired
	private UserSettingsService userSettingsService;
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
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
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
