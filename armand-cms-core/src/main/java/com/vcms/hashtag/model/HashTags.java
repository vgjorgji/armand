package com.vcms.hashtag.model;

import java.util.ArrayList;
import java.util.List;

import com.vcms.persist.model.HistoryModel;

public class HashTags extends HistoryModel {
	
	private List<HashTag> models = new ArrayList<>();
	
	public List<HashTag> getModels() {
		return models;
	}

	public void addModel(HashTag model) {
		models.add(model);
	}

}
