package com.vcms.user.model;

import com.vcms.persist.model.Fetch;
import com.vcms.persist.model.HistoryModelRepository;

public interface WebsiteUserRepository extends HistoryModelRepository<WebsiteUser> {

	Fetch<WebsiteUser> getWebsitesForUser(long userId);
	
	Fetch<WebsiteUser> getUsersForWebsite(long websiteId);
	
	WebsiteUser getModel(long userId, long websiteId);
	
}
