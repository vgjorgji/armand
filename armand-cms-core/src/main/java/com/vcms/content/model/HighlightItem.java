package com.vcms.content.model;

import com.vcms.conf.cms.Icon;
import com.vcms.localization.model.LocalText;

public class HighlightItem extends ContentModel {
	
	private Icon icon;
	private LocalText title;
	private LocalText text;
	
	public Icon getIcon() {
		return icon;
	}
	
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	
	public LocalText getTitle() {
		return title;
	}
	
	public void setTitle(LocalText title) {
		this.title = title;
	}
	
	public LocalText getText() {
		return text;
	}
	
	public void setText(LocalText text) {
		this.text = text;
	}
	
}
