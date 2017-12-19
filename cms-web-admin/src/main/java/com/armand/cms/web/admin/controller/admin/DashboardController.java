package com.armand.cms.web.admin.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.armand.cms.web.admin.model.PageConst;
import com.armand.cms.web.admin.model.Controller;
import com.armand.cms.web.admin.model.response.Response;
import com.vcms.website.model.WebsiteView;

@RestController(value = Controller.AdminDashboard)
@RequestMapping(value = PageConst.AdminDashboard)
public class DashboardController {
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		Response response = new Response();
		response.fragmentMain().data().add("websiteView", new WebsiteView());
		return response;
	}

}
