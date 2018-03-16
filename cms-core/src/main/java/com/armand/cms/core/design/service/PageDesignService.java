package com.armand.cms.core.design.service;

import com.armand.cms.core.design.model.PageDesign;
import com.armand.cms.core.website.model.Website;
import com.armand.cms.core.website.model.WebsiteViewType;

public interface PageDesignService {

  PageDesign getPageDesign(Website website, WebsiteViewType websiteViewType, long pageId);

}
