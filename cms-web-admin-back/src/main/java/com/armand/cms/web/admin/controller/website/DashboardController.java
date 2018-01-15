package com.armand.cms.web.admin.controller.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.armand.cms.core.date.Countdown;
import com.armand.cms.core.date.DateUtils;
import com.armand.cms.core.user.model.UserSettings;
import com.armand.cms.core.user.service.UserSettingsProvider;
import com.armand.cms.core.website.model.Website;
import com.armand.cms.core.website.model.WebsiteRepository;
import com.armand.cms.web.admin.model.Controller;
import com.armand.cms.web.admin.model.PageConst;
import com.armand.cms.web.admin.model.response.Response;

@RestController(value = Controller.WebsiteDashboard)
@RequestMapping(value = PageConst.WebsiteDashboard)
public class DashboardController {

  @Autowired
  private WebsiteRepository websiteRepository;


  @RequestMapping(value = "/load", method = RequestMethod.GET)
  public Response load(@PathVariable("websiteId") long websiteId) {
    Response response = new Response();
    Website website = websiteRepository.getModel(websiteId);

    UserSettings userSettings = UserSettingsProvider.getCurrentUser();
    Countdown countdown = getWebsiteCountdown(website, userSettings);

    response.fragmentMain().data()
        .add("website", website)
        .add("countdown", countdown);
    return response;
  }

  private Countdown getWebsiteCountdown(Website website, UserSettings userSettings) {
    Countdown countdown = null;
    if (website != null && website.getExpiryDate() != null) {
      countdown = DateUtils.toCountdown(website.getExpiryDate(), userSettings.getLanguage());
    }
    return countdown;
  }

}
