package com.vcms.hashtag.model;

import com.vcms.localization.model.LocalText;
import com.vcms.persist.model.HistoryModel;

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
