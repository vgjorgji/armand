package com.vcms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/overview")
public class OverviewController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHomePage() {
		return "redirect:/overview/dashboard";
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getDashboardPage() {
		return "/overview/dashboard";
	}

}
