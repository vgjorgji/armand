package com.vcms.web.admin.controller.overview;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.web.admin.model.Controller;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.response.Response;

@RestController(value = Controller.OverviewDashboard)
@RequestMapping(value = PageConst.OverviewDashboard)
public class DashboardController {
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		Response response = new Response();
		return response;
	}

}
