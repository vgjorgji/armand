package com.vcms.content.service;

import java.util.List;

import com.vcms.content.model.ContentModelRepository;
import com.vcms.design.model.DesignComponent;
import com.vcms.persist.model.ContentModel;

public class NavigationService implements ContentModelRepository {

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		return null;
	}
	
}
