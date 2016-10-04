package com.vcms.content.model;

import java.util.List;

import com.vcms.design.model.DesignComponent;
import com.vcms.persist.model.ContentModel;

public interface ContentRepository {
	
	List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent);

}
