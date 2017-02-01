package com.vcms.content.model;

import com.vcms.design.model.Link;
import com.vcms.design.model.Page;
import com.vcms.persist.model.ContentModel;

public class LinkItem extends ContentModel {
	
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
