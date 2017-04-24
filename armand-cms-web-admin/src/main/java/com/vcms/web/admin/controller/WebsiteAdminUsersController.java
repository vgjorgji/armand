package com.vcms.web.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;

@RestController
@RequestMapping(value = PageConst.WebsiteAdminUsers)
public class WebsiteAdminUsersController {
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		Response response = new Response();
		return response;
	}

}
