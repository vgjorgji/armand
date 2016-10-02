package com.vcms.content.model;

import com.vcms.persist.model.ContentModel;
import com.vcms.website.model.Link;
import com.vcms.website.model.Page;

public class SubNavItem extends ContentModel {
	
	private long navItemId;
	private Page page;
	private Link link;
	
	public long getNavItemId() {
		return navItemId;
	}

	public void setNavItemId(long navItemId) {
		this.navItemId = navItemId;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
		this.link = page.createLink();
	}

	public Link getLink() {
		return link;
	}
	
}
