package com.vcms.content.stub;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vcms.content.model.ContentModel;
import com.vcms.content.model.HeaderItem;
import com.vcms.content.model.HeaderItemRepository;
import com.vcms.design.model.DesignComponent;

@Repository
public class HeaderItemRepositoryStub implements HeaderItemRepository {

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		return Collections.emptyList();
	}

	@Override
	public List<HeaderItem> getModels(long designComponentId) {
		return null;
	}
	
}
