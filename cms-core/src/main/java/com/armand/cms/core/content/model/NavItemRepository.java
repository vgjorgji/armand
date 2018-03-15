package com.armand.cms.core.content.model;

import java.util.List;

import com.armand.cms.core.website.model.WebsiteViewType;

public interface NavItemRepository {

  List<NavItem> getModels(long websiteId, WebsiteViewType websiteViewType);

}
