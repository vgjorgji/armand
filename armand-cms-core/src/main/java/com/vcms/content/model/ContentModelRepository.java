package com.vcms.content.model;

import java.util.List;

import com.vcms.design.model.DesignComponent;

public interface ContentModelRepository {
	
	List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent);

}
