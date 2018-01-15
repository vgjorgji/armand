package com.armand.cms.web.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.armand.cms.core.design.model.Page;
import com.armand.cms.core.design.model.PageDesign;
import com.armand.cms.core.design.model.PageRepository;
import com.armand.cms.core.design.service.PageDesignService;
import com.armand.cms.core.website.model.Website;
import com.armand.cms.core.website.model.WebsiteView;
import com.armand.cms.web.client.service.ClientConfigurationService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CmsPageController {

  private final ClientConfigurationService clientConfigurationService;
  private final PageRepository pageRepository;
  private final PageDesignService pageDesignService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String homePage() {
    return "redirect:/page/home";
  }

  @RequestMapping(value = "/page/{pageUrl}", method = RequestMethod.GET)
  public String showPage(@PathVariable String pageUrl, Model model) {
    // website
    Website website = clientConfigurationService.getWebsite();
    WebsiteView websiteView = clientConfigurationService.getWebsiteView();

    // design
    Page page = getPage(websiteView, pageUrl);
    PageDesign pageDesign = pageDesignService.getPageDesign(page.getId(), website);

    // view
    model.addAttribute("website", website);
    model.addAttribute("websiteView", websiteView);
    model.addAttribute("page", page);
    model.addAttribute("pageDesign", pageDesign);
    return "cmsPage";
  }

  private Page getPage(WebsiteView websiteView, String pageUrl) {
    Page page = pageRepository.getCmsPage(websiteView.getId(), pageUrl);
    if (page == null) {
      throw new IllegalStateException(
          "No page found with name: " + pageUrl + " for website: " + clientConfigurationService.getWebsiteName());
    }
    return page;
  }

}
