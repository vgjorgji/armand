package com.armand.cms.core.user.model;

import com.armand.cms.core.persist.model.HistoryModelRepository;
import com.armand.cms.core.persist.model.Fetch;

public interface WebsiteUserRepository extends HistoryModelRepository<WebsiteUser> {

	Fetch<WebsiteUser> getWebsitesForUser(long userId);
	
	Fetch<WebsiteUser> getUsersForWebsite(long websiteId);
	
	WebsiteUser getModel(long userId, long websiteId);
	
}
