package com.vcms.web.admin.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;
import com.vcms.website.model.WebsiteView;

@RestController
@RequestMapping(value = PageConst.AdminDashboard)
public class AdminDashboardController {
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		Response response = new Response();
		response.mainTemplate().data().add("websiteView", new WebsiteView());
		return response;
	}

}