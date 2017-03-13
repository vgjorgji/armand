package com.vcms.content.model;

import com.vcms.persist.model.HistoryModel;

public abstract class ContentModel extends HistoryModel {
	
	private long designComponentId;
	private int sortOrder;
	
	public long getDesignComponentId() {
		return designComponentId;
	}

	public void setDesignComponentId(long designComponentId) {
		this.designComponentId = designComponentId;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	
}