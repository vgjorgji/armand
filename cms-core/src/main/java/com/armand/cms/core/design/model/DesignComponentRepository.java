package com.armand.cms.core.design.model;

import java.util.List;

import com.armand.cms.core.website.model.WebsiteViewType;

public interface DesignComponentRepository {

  List<DesignComponent> getDesignComponents(long pageId);

  DesignComponent getNavigationComponentForWebsite(long websiteId, WebsiteViewType websiteViewType);

}
