package com.armand.cms.core.design.model;

import com.armand.cms.core.conf.cms.Icon;

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
