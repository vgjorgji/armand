package com.vcms.design.model;

public interface PageRepository {

	CmsPage getCmsPage(long websiteViewId, String name);
	
}
