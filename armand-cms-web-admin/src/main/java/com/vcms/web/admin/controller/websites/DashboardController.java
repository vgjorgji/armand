package com.vcms.web.admin.controller.websites;

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
import com.vcms.web.admin.model.Controller;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;

@RestController(value = Controller.WebsitesDashboard)
@RequestMapping(value = PageConst.WebsitesDashboard)
public class DashboardController {
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@Autowired
	private WebsiteUserRepository websiteUserRepository;
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		Response response = new Response();
		UserSettings userSettings = UserSettingsProvider.getCurrentUser();
		
		List<WebsiteUser> websiteUsers = websiteUserRepository.getWebsitesForUser(userSettings.getId());
		List<Website> websites = new ArrayList<>(websiteUsers.size());
		for (WebsiteUser websiteUser : websiteUsers) {
			websites.add(websiteRepository.getModel(websiteUser.getWebsiteId()));
		}
		
		response.fragmentMain().data()
				.add("websites", websites)
				.add("languages", Language.values());
		return response;
	}

}
