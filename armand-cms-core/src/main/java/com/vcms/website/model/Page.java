package com.vcms.website.model;

import com.vcms.localization.model.LocalText;
import com.vcms.persist.model.HistoryModel;

public abstract class Page extends HistoryModel {
	
	private long websiteViewId;
	private LocalText title;
	private String url;
	
	public long getWebsiteViewId() {
		return websiteViewId;
	}

	public void setWebsiteViewId(long websiteViewId) {
		this.websiteViewId = websiteViewId;
	}

	public LocalText getTitle() {
		return title;
	}

	public void setTitle(LocalText title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public abstract Link createLink();

}
