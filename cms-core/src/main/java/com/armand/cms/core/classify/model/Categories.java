package com.armand.cms.core.classify.model;

import java.util.ArrayList;
import java.util.List;

import com.armand.cms.core.persist.model.HistoryModel;

public class Categories extends HistoryModel {

	private List<Category> models = new ArrayList<>();

	public List<Category> getModels() {
		return models;
	}

	public void addModel(Category model) {
		models.add(model);
	}
	
}
