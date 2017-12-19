package com.armand.cms.core.hashtag.model;

import java.util.ArrayList;
import java.util.List;

import com.armand.cms.core.persist.model.HistoryModel;

public class HashTags extends HistoryModel {
	
	private List<HashTag> models = new ArrayList<>();
	
	public List<HashTag> getModels() {
		return models;
	}

	public void addModel(HashTag model) {
		models.add(model);
	}

}
