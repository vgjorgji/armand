package com.armand.cms.web.client.service;

import com.armand.cms.core.website.model.Website;
import com.armand.cms.core.website.model.WebsiteView;

public interface ClientConfigurationService {

	String getWebsiteName();

	Website getWebsite();

	WebsiteView getWebsiteView();

}
