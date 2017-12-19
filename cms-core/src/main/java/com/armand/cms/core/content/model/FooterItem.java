package com.armand.cms.core.content.model;

import com.armand.cms.core.design.model.Link;
import com.armand.cms.core.design.model.Page;

public class FooterItem extends ContentModel {

	private Page page;
	private Link link;
	
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
