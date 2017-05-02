package com.vcms.web.admin.controller.website;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.web.admin.model.Controller;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;

@RestController(value = Controller.WebsiteAdminUsers)
@RequestMapping(value = PageConst.WebsiteAdminUsers)
public class AdminUsersController {
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		Response response = new Response();
		return response;
	}

}
