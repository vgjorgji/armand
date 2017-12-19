package com.armand.cms.core.content.model;

import java.util.List;

import com.armand.cms.core.design.model.DesignComponent;

public interface ContentModelRepository {
	
	List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent);

}
