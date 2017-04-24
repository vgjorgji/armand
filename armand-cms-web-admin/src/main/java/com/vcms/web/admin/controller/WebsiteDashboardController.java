package com.vcms.web.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		
		response.mainTemplate().data().add("website", website);
		return response;
	}
	
}
