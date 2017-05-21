package com.vcms.web.admin.model.tree;

import com.vcms.conf.cms.Icon;

public class SubNode {

	private long id;
	private String title;
	private Icon icon;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

}
