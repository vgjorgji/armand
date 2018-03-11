package com.armand.cms.web.admin.controller.website;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.armand.cms.core.conf.CmsPackage;
import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.persist.model.Fetch;
import com.armand.cms.core.user.model.UserSettings;
import com.armand.cms.core.user.service.UserSettingsProvider;
import com.armand.cms.core.website.model.Company;
import com.armand.cms.core.website.model.CompanyRepository;
import com.armand.cms.core.website.model.Website;
import com.armand.cms.core.website.model.WebsiteRepository;
import com.armand.cms.core.website.model.WebsiteStatus;
import com.armand.cms.web.admin.model.Controller;
import com.armand.cms.web.admin.model.PageConst;
import com.armand.cms.web.admin.model.response.Response;
import lombok.RequiredArgsConstructor;

@RestController(value = Controller.WebsiteAdminSite)
@RequestMapping(value = PageConst.WebsiteAdminSite)
@RequiredArgsConstructor
public class AdminSiteController {

  private final WebsiteRepository websiteRepository;
  private final CompanyRepository companyRepository;

  @RequestMapping(value = "/load", method = RequestMethod.GET)
  public Response load() {
    Response response = new Response();
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();

    long websiteId = userSettings.getSelectedWebsiteId();
    Website website = websiteRepository.getModel(websiteId);

    Fetch<Company> allCompaniesFetch = companyRepository.getAllModels();

    response.fragmentMain().data()
        .add("website", website)
        .add("allCompanies", allCompaniesFetch.getModels())
        .add("cmsPackages", CmsPackage.values())
        .add("languages", Language.values())
        .add("statuses", WebsiteStatus.values());
    return response;
  }


  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public Response save(@RequestBody Website website) {
    websiteRepository.saveModel(website);

    UserSettings userSettings = UserSettingsProvider.getCurrentUser();
    userSettings.setSelectedWebsite(website);

    Response response = load();
    response.snippet("global-website-name").text(website.getName());
    return response;
  }
}
