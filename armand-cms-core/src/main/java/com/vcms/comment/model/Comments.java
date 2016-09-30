package com.vcms.comment.model;

import java.util.ArrayList;
import java.util.List;

import com.vcms.persist.model.DbModel;

public class Comments extends DbModel {
	
	private List<Comment> models = new ArrayList<>();
	
	public List<Comment> getModels() {
		return models;
	}

	public void addModel(Comment model) {
		models.add(model);
	}
	
	public int getSize() {
		return models.size();
	}

}
