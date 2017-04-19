package com.vcms.content.service;

import java.util.List;

import com.vcms.content.model.ContentModel;
import com.vcms.design.model.DesignComponent;

public interface ContentService {
	
	List<ContentModel> getContentModels(DesignComponent designComponent);

}
