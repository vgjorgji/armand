package com.vcms.content.model;

import java.util.ArrayList;
import java.util.List;

import com.vcms.design.model.Link;
import com.vcms.design.model.Page;
import com.vcms.persist.model.ContentModel;

public class NavItem extends ContentModel {
	
	private long mainNavItemId;
	private Page page;
	private Link link;
	private List<SubNavItem> subNavItems;
	
	public long getMainNavItemId() {
		return mainNavItemId;
	}

	public void setMainNavItemId(long mainNavItemId) {
		this.mainNavItemId = mainNavItemId;
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
	
	public List<SubNavItem> getSubNavItems() {
		if (subNavItems == null) {
			subNavItems = new ArrayList<>();
		}
		return subNavItems;
	}
	
	public void setSubNavItems(List<SubNavItem> subNavItems) {
		this.subNavItems = subNavItems;
	}

}
