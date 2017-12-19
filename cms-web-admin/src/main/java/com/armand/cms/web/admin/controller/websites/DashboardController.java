package com.armand.cms.web.admin.controller.websites;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.armand.cms.web.admin.model.PageConst;
import com.armand.cms.web.admin.model.response.Response;
import com.vcms.localization.model.Language;
import com.vcms.persist.model.Fetch;
import com.vcms.user.model.UserSettings;
import com.vcms.user.model.WebsiteUser;
import com.vcms.user.model.WebsiteUserRepository;
import com.vcms.user.service.UserSettingsProvider;
import com.armand.cms.web.admin.model.Controller;
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
		
		Fetch<WebsiteUser> websiteUsersFetch = websiteUserRepository.getWebsitesForUser(userSettings.getId());
		List<Long> websiteIds = new ArrayList<>(websiteUsersFetch.size());
		for (WebsiteUser websiteUser : websiteUsersFetch.getModels()) {
			websiteIds.add(websiteUser.getWebsiteId());
		}
		Fetch<Website> websitesFetch = websiteRepository.getModels(websiteIds);
		
		response.fragmentMain().data()
				.add("websites", websitesFetch.getModels())
				.add("languages", Language.values());
		return response;
	}

}
