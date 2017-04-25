package com.vcms.web.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.date.Countdown;
import com.vcms.date.DateUtils;
import com.vcms.user.model.UserSettings;
import com.vcms.user.service.UserSettingsProvider;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;

@RestController
@RequestMapping(value = PageConst.WebsiteDashboard)
public class WebsiteDashboardController {
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load(@PathVariable("websiteId") long websiteId) {
		Response response = new Response();
		Website website = websiteRepository.getModel(websiteId);
		
		UserSettings userSettings = UserSettingsProvider.getCurrentUser();
		Countdown countdown = getWebsiteCountdown(website, userSettings);
		
		response.mainTemplate().data()
				.add("website", website)
				.add("countdown", countdown);
		return response;
	}

	private Countdown getWebsiteCountdown(Website website, UserSettings userSettings) {
		Countdown countdown = null;
		if (website.getExpiryDate() != null) {
			countdown = DateUtils.toCountdown(website.getExpiryDate(), userSettings.getLanguage());
		}
		return countdown;
	}
	
}
