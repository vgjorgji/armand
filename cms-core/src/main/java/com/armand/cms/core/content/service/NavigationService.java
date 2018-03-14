package com.armand.cms.core.content.service;

import java.util.List;

import com.armand.cms.core.content.model.ContentModel;
import com.armand.cms.core.website.model.WebsiteViewType;

public interface NavigationService {

  List<ContentModel> getCompleteNavigationForWebsite(long websiteId, WebsiteViewType websiteViewType);

}
