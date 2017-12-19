package com.armand.cms.core.design.model;

import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.persist.model.HistoryModel;

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
