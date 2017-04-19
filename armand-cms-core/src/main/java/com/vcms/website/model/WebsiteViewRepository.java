package com.vcms.website.model;

public interface WebsiteViewRepository {
	
	WebsiteView getWebsiteView(long websiteViewId);
	
	WebsiteView getWebsiteView(long websiteId, WebsiteViewType viewType);
	
	void save(WebsiteView websiteView);

}
