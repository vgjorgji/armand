package com.vcms.web.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.conf.cms.Font;
import com.vcms.conf.cms.ModernColor;
import com.vcms.conf.cms.Style;
import com.vcms.user.model.UserSettings;
import com.vcms.user.service.UserSettingsProvider;
import com.vcms.web.admin.model.Response;
import com.vcms.web.admin.model.Snippet;
import com.vcms.web.admin.model.TemplateData;
import com.vcms.website.model.WebsiteVeiwRepository;
import com.vcms.website.model.WebsiteView;
import com.vcms.website.model.WebsiteViewType;

@RestController
@RequestMapping(value = "/website/{websiteId}/design")
public class WebsiteDesignController {
	
	private static final String BASE_FILE = "/website/design";
	private static final String THEME = BASE_FILE + "/theme";
	private static final String NAVIGATION = BASE_FILE + "/navigation";
	private static final String PAGES = BASE_FILE + "/pages";
	private static final String PREVIEW = BASE_FILE + "/preview";
	
	@Autowired
	private WebsiteVeiwRepository websiteVeiwRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getDesignerPage(@PathVariable("websiteId") long websiteId) {
		return BASE_FILE;
	}
	
	@RequestMapping(value = "/theme/load", method = RequestMethod.GET)
	public Response loadDesignerTheme() {
		UserSettings userSettings = UserSettingsProvider.getCurrentUser();
		
		long websiteId = userSettings.getSelectedWebsiteId();
		WebsiteView websiteView = websiteVeiwRepository.getWebsiteView(websiteId, WebsiteViewType.Design);
		
		TemplateData templateData = new TemplateData();
		templateData.addObject("websiteView", websiteView);
		templateData.addObject("styles", Style.values());
		templateData.addObject("modernColors", ModernColor.values());
		templateData.addObject("fonts", Font.values());
		
		Response response = new Response();
		response.setMainTemplateData(templateData.getData());
		return response;
	}
	
	@RequestMapping(value = "/theme/save", method = RequestMethod.POST)
	public Response saveDesignerTheme(@RequestBody WebsiteView websiteView) {
		websiteVeiwRepository.save(websiteView);
		
		Response response = new Response();
		response.addSnippet("formResult", new Snippet("Success", false));
		return response;
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
