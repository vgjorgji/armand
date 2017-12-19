package com.armand.cms.core.website.model;

import com.armand.cms.core.conf.cms.Style;
import com.armand.cms.core.persist.model.HistoryModel;
import com.armand.cms.core.conf.cms.Font;
import com.armand.cms.core.conf.cms.ModernColor;

public class WebsiteView extends HistoryModel {
	
	private long websiteId;
	private WebsiteViewType viewType;
	private Style style;
	private ModernColor color;
	private ModernColor selectColor;
	private Font font;
	
	public WebsiteViewType getViewType() {
		return viewType;
	}
	
	public void setViewType(WebsiteViewType viewType) {
		this.viewType = viewType;
	}

	public long getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(long websiteId) {
		this.websiteId = websiteId;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}
	
	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public ModernColor getColor() {
		return color;
	}

	public void setColor(ModernColor color) {
		this.color = color;
	}

	public ModernColor getSelectColor() {
		return selectColor;
	}

	public void setSelectColor(ModernColor selectColor) {
		this.selectColor = selectColor;
	}
	
}
