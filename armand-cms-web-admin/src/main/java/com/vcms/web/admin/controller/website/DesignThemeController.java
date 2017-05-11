package com.vcms.web.admin.controller.website;

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
import com.vcms.web.admin.model.Controller;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;
import com.vcms.website.model.WebsiteView;
import com.vcms.website.model.WebsiteViewRepository;
import com.vcms.website.model.WebsiteViewType;

@RestController(value = Controller.WebsiteDesignTheme)
@RequestMapping(value = PageConst.WebsiteDesignTheme)
public class DesignThemeController {
	
	@Autowired
	private WebsiteViewRepository websiteViewRepository;
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		Response response = new Response();
		UserSettings userSettings = UserSettingsProvider.getCurrentUser();
		
		long websiteId = userSettings.getSelectedWebsiteId();
		WebsiteView websiteView = websiteViewRepository.getModel(websiteId, WebsiteViewType.Design);
		
		response.fragmentMain().data()
				.add("websiteView", websiteView)
				.add("styles", Style.values())
				.add("modernColors", ModernColor.values())
				.add("fonts", Font.values());
		return response;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response save(@RequestBody WebsiteView websiteView) {
		websiteViewRepository.saveModel(websiteView);
		return load();
	}
}
