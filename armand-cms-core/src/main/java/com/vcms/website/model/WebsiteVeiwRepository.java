package com.vcms.website.model;

public interface WebsiteVeiwRepository {
	
	WebsiteView getWebsiteView(long websiteId, WebsiteViewType viewType);

}
