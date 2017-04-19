package com.vcms.website.service;

import com.vcms.website.model.WebsiteView;
import com.vcms.website.model.WebsiteViewType;

public interface WebsiteViewService {
	
	WebsiteView getWebsiteView(long websiteViewId);
	
	WebsiteView getWebsiteView(long websiteId, WebsiteViewType viewType);
	
	void save(WebsiteView websiteView);

}
