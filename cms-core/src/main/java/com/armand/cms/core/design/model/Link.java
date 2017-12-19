package com.armand.cms.core.design.model;

import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.conf.cms.Icon;

public class Link {
	
	private String url;
	private LocalText text;
	private Icon icon;
	private boolean external;
	
	Link() {
		// only Page can create Link
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public LocalText getText() {
		return text;
	}

	public void setText(LocalText text) {
		this.text = text;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public boolean isExternal() {
		return external;
	}

	public void setExternal(boolean external) {
		this.external = external;
	}

}
