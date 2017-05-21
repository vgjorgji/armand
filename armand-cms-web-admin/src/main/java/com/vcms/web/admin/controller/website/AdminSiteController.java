package com.vcms.web.admin.controller.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.conf.cms.CmsPackage;
import com.vcms.localization.model.Language;
import com.vcms.persist.model.Fetch;
import com.vcms.user.model.UserSettings;
import com.vcms.user.service.UserSettingsProvider;
import com.vcms.web.admin.model.Controller;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.response.Response;
import com.vcms.website.model.Company;
import com.vcms.website.model.CompanyRepository;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;
import com.vcms.website.model.WebsiteStatus;

@RestController(value = Controller.WebsiteAdminSite)
@RequestMapping(value = PageConst.WebsiteAdminSite)
public class AdminSiteController {
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		Response response = new Response();
		UserSettings userSettings = UserSettingsProvider.getCurrentUser();
		
		long websiteId = userSettings.getSelectedWebsiteId();
		Website website = websiteRepository.getModel(websiteId);
		
		Fetch<Company> allCompaniesFetch = companyRepository.getAllModels();
		
		response.fragmentMain().data()
				.add("website", website)
				.add("allCompanies", allCompaniesFetch.getModels())
				.add("cmsPackages", CmsPackage.values())
				.add("allLanguages", Language.values())
				.add("statuses", WebsiteStatus.values());
		return response;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response save(@RequestBody Website website) {
		websiteRepository.saveModel(website);
		
		UserSettings userSettings = UserSettingsProvider.getCurrentUser();
		userSettings.setSelectedWebsite(website);
		
		Response response = load();
		response.snippet("global-website-name").text(website.getName());
		return response;
	}
}
