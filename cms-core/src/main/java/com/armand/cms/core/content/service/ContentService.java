package com.armand.cms.core.content.service;

import java.util.List;

import com.armand.cms.core.content.model.ContentModel;
import com.armand.cms.core.design.model.DesignComponent;
import com.armand.cms.core.website.model.WebsiteViewType;

public interface ContentService {

  List<ContentModel> getContentModels(long websiteId, WebsiteViewType websiteViewType, DesignComponent designComponent);

}
