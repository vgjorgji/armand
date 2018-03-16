package com.armand.cms.core.content.service;

import java.util.List;

import com.armand.cms.core.content.model.MainNavItem;
import com.armand.cms.core.website.model.WebsiteViewType;

public interface NavigationService {

  List<MainNavItem> getCompleteNavigationForWebsite(long websiteId, WebsiteViewType websiteViewType);

}
