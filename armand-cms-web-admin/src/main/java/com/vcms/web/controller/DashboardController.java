package com.vcms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getDashboardPage() {
		return "/dashboard";
	}

}