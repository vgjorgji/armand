package com.armand.cms.core.design.model;

import com.armand.cms.core.conf.cms.Icon;

public class ExternalPage extends Page {
	
	private Icon icon;
	
	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	@Override
	public Link createLink() {
		Link link = new Link();
		link.setUrl(getUrl());
		link.setText(getTitle());
		link.setIcon(icon);
		link.setExternal(true);
		return link;
	}
	
}
