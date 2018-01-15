package com.armand.cms.web.admin.controller.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.armand.cms.core.conf.Font;
import com.armand.cms.core.conf.ModernColor;
import com.armand.cms.core.conf.Style;
import com.armand.cms.core.user.model.UserSettings;
import com.armand.cms.core.user.service.UserSettingsProvider;
import com.armand.cms.core.website.model.WebsiteView;
import com.armand.cms.core.website.model.WebsiteViewRepository;
import com.armand.cms.core.website.model.WebsiteViewType;
import com.armand.cms.web.admin.model.Controller;
import com.armand.cms.web.admin.model.PageConst;
import com.armand.cms.web.admin.model.response.Response;

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
