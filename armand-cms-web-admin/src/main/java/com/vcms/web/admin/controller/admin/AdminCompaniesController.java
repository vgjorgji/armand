package com.vcms.web.admin.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;

@RestController
@RequestMapping(value = PageConst.AdminCompanies)
public class AdminCompaniesController {
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		Response response = new Response();
		return response;
	}

}