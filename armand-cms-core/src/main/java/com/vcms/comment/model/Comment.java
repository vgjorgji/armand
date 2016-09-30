package com.vcms.comment.model;

import com.vcms.persist.model.DbModel;

public class Comment extends DbModel {
	
	private long websiteViewId;
	private String name;
	private String email;
	private String text;
	
	public long getWebsiteViewId() {
		return websiteViewId;
	}

	public void setWebsiteViewId(long websiteViewId) {
		this.websiteViewId = websiteViewId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}
