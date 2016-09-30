package com.vcms.website.model;

import java.util.List;

public interface WebsiteRepository {
	
	Website getWebsite(String name);
	
	List<Website> getUserWebsites(long userId);

}
