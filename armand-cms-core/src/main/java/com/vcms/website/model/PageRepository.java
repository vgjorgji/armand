package com.vcms.website.model;

public interface PageRepository {

	CmsPage getCmsPage(long websiteViewId, String url);
	
}
