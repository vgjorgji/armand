package com.vcms.user.model;

import com.vcms.persist.model.DbModel;

public class WebsiteGroupUser extends DbModel {
	
	private long websiteGroupId;
	private long userId;
	
	public long getWebsiteGroupId() {
		return websiteGroupId;
	}
	
	public void setWebsiteGroupId(long websiteGroupId) {
		this.websiteGroupId = websiteGroupId;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
