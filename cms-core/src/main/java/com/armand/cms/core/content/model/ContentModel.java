package com.armand.cms.core.content.model;

import com.armand.cms.core.persist.model.HistoryModel;

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
