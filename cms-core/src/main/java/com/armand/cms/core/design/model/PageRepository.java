package com.armand.cms.core.design.model;

import com.armand.cms.core.conf.FeedType;
import com.armand.cms.core.persist.model.Fetch;
import com.armand.cms.core.persist.model.HistoryModelRepository;

public interface PageRepository extends HistoryModelRepository<Page> {

  ExternalPage getExternalPage(long websiteViewId, String url);

  CmsPage getCmsPage(long websiteViewId, String url);

  Fetch<CmsPage> getCmsPages(long websiteViewId);

  FeedPage getFeedPage(long websiteViewId, String url, FeedType feedType);

}
