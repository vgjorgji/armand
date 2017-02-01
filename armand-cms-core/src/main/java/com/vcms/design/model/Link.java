package com.vcms.design.model;

import com.vcms.conf.cms.Icon;
import com.vcms.localization.model.LocalText;

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
