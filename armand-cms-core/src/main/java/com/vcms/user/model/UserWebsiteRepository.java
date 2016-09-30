package com.vcms.user.model;

import java.util.List;

public interface UserWebsiteRepository {

	List<UserWebsite> getWebsitesForUser(long userId);
	
	List<UserWebsite> getUsersForWebsite(long websiteId);
	
}
