package com.vcms.web.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.conf.cms.Font;
import com.vcms.conf.cms.ModernColor;
import com.vcms.conf.cms.Style;
import com.vcms.user.model.UserSettings;
import com.vcms.user.service.UserSettingsProvider;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;
import com.vcms.web.admin.model.Snippet;
import com.vcms.web.admin.model.TemplateData;
import com.vcms.website.model.WebsiteVeiwRepository;
import com.vcms.website.model.WebsiteView;
import com.vcms.website.model.WebsiteViewType;

@RestController
@RequestMapping(value = PageConst.WebsiteDesignTheme)
public class WebsiteDesignThemeController {
	
	@Autowired
	private WebsiteVeiwRepository websiteVeiwRepository;
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
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
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response save(@RequestBody WebsiteView websiteView) {
		websiteVeiwRepository.save(websiteView);
		
		// reload
		Response response = load();
		
		// response
		response.addSnippet("formResult", new Snippet("Success", false));
		return response;
	}
}
