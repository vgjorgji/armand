package com.vcms.user.model;

import java.util.List;

public interface WebsiteUserRepository {

	List<WebsiteUser> getWebsitesForUser(long userId);
	
	List<WebsiteUser> getUsersForWebsite(long websiteId);
	
	WebsiteUser getWebsiteUser(long userId, long websiteId);
	
}
