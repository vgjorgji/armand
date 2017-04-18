package com.vcms.web.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.localization.model.Language;
import com.vcms.user.model.UserSettings;
import com.vcms.user.model.WebsiteUser;
import com.vcms.user.model.WebsiteUserRepository;
import com.vcms.user.service.UserSettingsProvider;
import com.vcms.web.admin.model.Response;
import com.vcms.web.admin.model.TemplateData;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;

@RestController
@RequestMapping(value = "/websites")
public class WebsitesController {
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@Autowired
	private WebsiteUserRepository websiteUserRepository;
	
	@RequestMapping(value = "/dashboard/load", method = RequestMethod.GET)
	public Response loadDashboardPage() {
		UserSettings userSettings = UserSettingsProvider.getCurrentUser();
		
		List<WebsiteUser> websiteUsers = websiteUserRepository.getWebsitesForUser(userSettings.getId());
		List<Website> websites = new ArrayList<>(websiteUsers.size());
		for (WebsiteUser websiteUser : websiteUsers) {
			websites.add(websiteRepository.getWebsite(websiteUser.getWebsiteId()));
		}
		
		TemplateData templateData = new TemplateData();
		templateData.addObject("websites", websites);
		templateData.addObject("languages", Language.values());
		
		Response response = new Response();
		response.setMainTemplateData(templateData.getData());
		return response;
	}

}
