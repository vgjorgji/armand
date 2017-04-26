package com.vcms.user.model;

import java.util.List;

import com.vcms.persist.model.HistoryModelRepository;

public interface WebsiteUserRepository extends HistoryModelRepository<WebsiteUser> {

	List<WebsiteUser> getWebsitesForUser(long userId);
	
	List<WebsiteUser> getUsersForWebsite(long websiteId);
	
	WebsiteUser getModel(long userId, long websiteId);
	
}
