package com.vcms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/website/{websiteId}/design")
public class WebsiteDesignController {
	
	private static final String BASE_FILE = "/website/design";
	private static final String THEME = BASE_FILE + "/theme";
	private static final String NAVIGATION = BASE_FILE + "/navigation";
	private static final String PAGES = BASE_FILE + "/pages";
	private static final String PREVIEW = BASE_FILE + "/preview";
	
	@RequestMapping(method = RequestMethod.GET)
	public String getDesignerPage(@PathVariable("websiteId") long websiteId) {
		return BASE_FILE;
	}
	
	@RequestMapping(value = "/theme", method = RequestMethod.GET)
	public String getDesignerThemePage(@PathVariable("websiteId") long websiteId) {
		return THEME;
	}
	
	@RequestMapping(value = "/navigation", method = RequestMethod.GET)
	public String getDesignerNavigationPage(@PathVariable("websiteId") long websiteId) {
		return NAVIGATION;
	}
	
	@RequestMapping(value = "/pages", method = RequestMethod.GET)
	public String getDesignerPagesPage(@PathVariable("websiteId") long websiteId) {
		return PAGES;
	}
	
	@RequestMapping(value = "/preview", method = RequestMethod.GET)
	public String getDesignerPreviewPage(@PathVariable("websiteId") long websiteId) {
		return PREVIEW;
	}

}
