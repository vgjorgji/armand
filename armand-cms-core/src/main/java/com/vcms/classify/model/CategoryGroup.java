package com.vcms.classify.model;

import java.util.List;

import com.vcms.conf.cms.ModernColor;
import com.vcms.localization.model.LocalText;
import com.vcms.persist.model.HistoryModel;

public class CategoryGroup extends HistoryModel {
	
	private long websiteViewId;
	private LocalText name;
	private ModernColor color;
	private List<Category> categories;
	
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
	
	public ModernColor getColor() {
		return color;
	}
	
	public void setColor(ModernColor color) {
		this.color = color;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
}
