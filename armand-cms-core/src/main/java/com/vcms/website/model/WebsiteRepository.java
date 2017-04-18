package com.vcms.website.model;

public interface WebsiteRepository {
	
	Website getWebsite(long websiteId);
	
	Website getWebsite(String name);
	
}
