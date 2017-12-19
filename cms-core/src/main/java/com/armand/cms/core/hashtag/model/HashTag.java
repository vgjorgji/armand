package com.armand.cms.core.hashtag.model;

import com.armand.cms.core.persist.model.HistoryModel;
import com.armand.cms.core.localization.model.LocalText;

public class HashTag extends HistoryModel {
	
	private long parentId;
	private LocalText name;
	
	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public LocalText getName() {
		return name;
	}
	
	public void setName(LocalText name) {
		this.name = name;
	}

}
