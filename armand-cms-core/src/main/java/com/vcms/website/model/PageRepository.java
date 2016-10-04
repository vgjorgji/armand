package com.vcms.website.model;

import com.vcms.conf.cms.FeedType;

public interface PageRepository {

	ExternalPage getExternalPage(long websiteViewId, String url);
	
	CmsPage getCmsPage(long websiteViewId, String url);
	
	FeedPage getFeedPage(long websiteViewId, String url, FeedType feedType);
	
}
