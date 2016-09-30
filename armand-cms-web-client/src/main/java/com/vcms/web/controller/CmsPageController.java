package com.vcms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vcms.design.model.Page;
import com.vcms.design.service.PageService;
import com.vcms.web.service.ClientConfigurationService;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteView;

@Controller
public class CmsPageController {
	
	@Autowired
	private ClientConfigurationService clientConfigurationService;
	
	@Autowired
	private PageService pageService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "redirect:/page/home";
	}

	@RequestMapping(value = "/page/{pageName}", method = RequestMethod.GET)
	public String showPage(@PathVariable String pageName, Model model) {
		// models
		Website website = clientConfigurationService.getWebsite();
		WebsiteView websiteView = clientConfigurationService.getWebsiteView();
		Page page = getPage(website, websiteView, pageName);
		
		// view
		model.addAttribute("website", website);
		model.addAttribute("websiteView", websiteView);
		model.addAttribute("page", page);
		return "/cmsPage";
	}
	
	private Page getPage(Website website, WebsiteView websiteView, String pageName) {
		Page page = pageService.getCmsPage(website, websiteView, pageName);
		if (page == null) {
			throw new IllegalStateException(
					"No page found with name: " + pageName + " for website: " + clientConfigurationService.getWebsiteName());
		}
		return page;
	}

}
