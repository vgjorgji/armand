package com.vcms.web.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.web.admin.model.Response;
import com.vcms.web.admin.model.TemplateData;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;

@RestController
@RequestMapping(value = "/website/{websiteId}")
public class WebsiteController {
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@RequestMapping(value = "/dashboard/load", method = RequestMethod.GET)
	public Response loadDashboardPage(@PathVariable("websiteId") long websiteId) {
		Website website = websiteRepository.getWebsite(websiteId);
		
		TemplateData templateData = new TemplateData();
		templateData.addObject("website", website);
		
		Response response = new Response();
		response.setMainTemplateData(templateData.getData());
		return response;
	}
	
}
