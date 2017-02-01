package com.vcms.design.model;

import com.vcms.conf.cms.Icon;

public class CmsPage extends Page {
	
	@Override
	public Link createLink() {
		Link link = new Link();
		link.setUrl("/page/" + getUrl());
		link.setText(getTitle());
		link.setIcon(Icon.Link);
		link.setExternal(false);
		return link;
	}

}
