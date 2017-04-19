package com.vcms.web.client.service;

import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteView;

public interface ClientConfigurationService {

	String getWebsiteName();

	Website getWebsite();

	WebsiteView getWebsiteView();

}
