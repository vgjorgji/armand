package com.vcms.classify.model;

import com.vcms.conf.cms.ModernColor;
import com.vcms.localization.model.LocalText;
import com.vcms.persist.model.HistoryModel;

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
