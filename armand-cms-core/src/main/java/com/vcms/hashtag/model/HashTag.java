package com.vcms.hashtag.model;

import com.vcms.localization.model.LocalText;
import com.vcms.persist.model.HistoryModel;

public class HashTag extends HistoryModel {
	
	private long websiteViewId;
	private LocalText name;
	
	public long getWebsiteViewId() {
		return websiteViewId;
	}
	
	public void setWebsiteViewId(long websiteViewId) {
		this.websiteViewId = websiteViewId;
	}
	
	public LocalText getName() {
		return name;
	}
	
	public void setName(LocalText name) {
		this.name = name;
	}

}
