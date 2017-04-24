package com.vcms.web.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.conf.cms.CmsPackage;
import com.vcms.localization.model.Language;
import com.vcms.user.model.UserSettings;
import com.vcms.user.service.UserSettingsProvider;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;

@RestController
@RequestMapping(value = PageConst.WebsiteAdminSite)
public class WebsiteAdminSiteController {
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		Response response = new Response();
		UserSettings userSettings = UserSettingsProvider.getCurrentUser();
		
		long websiteId = userSettings.getSelectedWebsiteId();
		Website website = websiteRepository.getModel(websiteId);
		
		response.mainTemplate().data()
				.add("website", website)
				.add("cmsPackages", CmsPackage.values())
				.add("allLanguages", Language.values());
		return response;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response save(@RequestBody Website website) {
		websiteRepository.saveModel(website);
		
		Response response = load();
		response.snippet("formResult").text("Success").html(false);
		return response;
	}
}
