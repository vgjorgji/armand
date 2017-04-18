package com.vcms.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/website/{websiteId}/design-review")
public class WebsiteDesignReviewController {
	
	private static final String BASE_FILE = "/website/design-review";
	private static final String CHANGES = BASE_FILE + "/changes";
	private static final String PREVIEW = BASE_FILE + "/preview";
	
	@RequestMapping(method = RequestMethod.GET)
	public String getDesignerPage(@PathVariable("websiteId") long websiteId) {
		return BASE_FILE;
	}
	
	@RequestMapping(value = "/changes", method = RequestMethod.GET)
	public String getDesignerThemePage(@PathVariable("websiteId") long websiteId) {
		return CHANGES;
	}
	
	@RequestMapping(value = "/preview", method = RequestMethod.GET)
	public String getDesignerPreviewPage(@PathVariable("websiteId") long websiteId) {
		return PREVIEW;
	}

}
