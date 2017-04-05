package com.vcms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/website/{websiteId}")
public class WebsiteController {
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getDashboardPage(@PathVariable("websiteId") long websiteId) {
		return "/website/dashboard";
	}
	
}
