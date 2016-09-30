package com.vcms.user.model;

import java.util.List;

import com.vcms.persist.model.HistoryModel;

public class UserGroup extends HistoryModel {
	
	private String name;
	private long websiteId;
	private List<User> users;
	
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

	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
