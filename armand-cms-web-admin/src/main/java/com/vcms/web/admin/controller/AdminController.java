package com.vcms.web.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.user.service.UserSettingsProvider;
import com.vcms.web.admin.model.Response;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@RequestMapping(value = "/dashboard/load", method = RequestMethod.GET)
	public Response loadDashboardPage() {
		Response response = new Response();
		response.setMainTemplateData(UserSettingsProvider.getCurrentUser());
		return response;
	}

}