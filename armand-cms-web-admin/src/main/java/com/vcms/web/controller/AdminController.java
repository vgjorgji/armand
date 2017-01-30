package com.vcms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	public String getOverviewPage() {
		return "/admin/overview";
	}

}
