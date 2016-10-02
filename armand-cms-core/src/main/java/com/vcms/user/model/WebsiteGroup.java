package com.vcms.user.model;

import com.vcms.persist.model.HistoryModel;

public class WebsiteGroup extends HistoryModel {
	
	private long websiteId;
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(long websiteId) {
		this.websiteId = websiteId;
	}

}
