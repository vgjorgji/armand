package com.vcms.content.model;

import java.util.List;

import com.vcms.design.model.Link;
import com.vcms.design.model.Page;
import com.vcms.persist.model.ContentModel;

public class MainNavItem extends ContentModel {

	private Page page;
	private Link link;
	private List<NavItem> navItems;
	
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
	
	public List<NavItem> getNavItems() {
		return navItems;
	}
	
	public void setNavItems(List<NavItem> navItems) {
		this.navItems = navItems;
	}
	
}
