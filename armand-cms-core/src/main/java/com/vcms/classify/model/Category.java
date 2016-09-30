package com.vcms.classify.model;

import com.vcms.conf.cms.ModernColor;
import com.vcms.localization.model.LocalText;
import com.vcms.persist.model.HistoryModel;

public class Category extends HistoryModel {
	
	private long categoryGroupId;
	private LocalText name;
	private ModernColor color;
	
	public long getCategoryGroupId() {
		return categoryGroupId;
	}
	
	public void setCategoryGroupId(long categoryGroupId) {
		this.categoryGroupId = categoryGroupId;
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
