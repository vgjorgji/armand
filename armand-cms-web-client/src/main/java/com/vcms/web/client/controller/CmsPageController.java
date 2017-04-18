package com.vcms.web.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vcms.design.model.Page;
import com.vcms.design.model.PageDesign;
import com.vcms.design.model.PageRepository;
import com.vcms.design.service.PageDesignService;
import com.vcms.web.client.service.ClientConfigurationService;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteView;

@Controller
public class CmsPageController {
	
	@Autowired
	private ClientConfigurationService clientConfigurationService;
	
	@Autowired
	private PageRepository pageRepository;
	
	@Autowired
	private PageDesignService pageDesignService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "redirect:/page/home";
	}

	@RequestMapping(value = "/page/{pageUrl}", method = RequestMethod.GET)
	public String showPage(@PathVariable String pageUrl, Model model) {
		// website
		Website website = clientConfigurationService.getWebsite();
		WebsiteView websiteView = clientConfigurationService.getWebsiteView();
		
		// design
		Page page = getPage(websiteView, pageUrl);
		PageDesign pageDesign = pageDesignService.getPageDesign(page.getId(), website);
		
		// view
		model.addAttribute("website", website);
		model.addAttribute("websiteView", websiteView);
		model.addAttribute("page", page);
		model.addAttribute("pageDesign", pageDesign);
		return "/cmsPage";
	}
	
	private Page getPage(WebsiteView websiteView, String pageUrl) {
		Page page = pageRepository.getCmsPage(websiteView.getId(), pageUrl);
		if (page == null) {
			throw new IllegalStateException(
					"No page found with name: " + pageUrl + " for website: " + clientConfigurationService.getWebsiteName());
		}
		return page;
	}

}
