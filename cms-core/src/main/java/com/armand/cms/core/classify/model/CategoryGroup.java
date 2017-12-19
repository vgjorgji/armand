package com.armand.cms.core.classify.model;

import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.persist.model.HistoryModel;
import com.armand.cms.core.conf.cms.ModernColor;

public class CategoryGroup extends HistoryModel {
	
	private long parentId;
	private LocalText name;
	private ModernColor color;
	
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
	
	public ModernColor getColor() {
		return color;
	}
	
	public void setColor(ModernColor color) {
		this.color = color;
	}

}