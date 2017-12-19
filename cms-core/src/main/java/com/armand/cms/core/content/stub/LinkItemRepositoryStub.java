package com.armand.cms.core.content.stub;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.content.model.ContentModel;
import com.armand.cms.core.content.model.LinkItemRepository;
import com.armand.cms.core.design.model.DesignComponent;
import com.armand.cms.core.content.model.LinkItem;

@Repository
public class LinkItemRepositoryStub implements LinkItemRepository {

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		return Collections.emptyList();
	}

	@Override
	public List<LinkItem> getModels(long designComponentId) {
		return null;
	}
	
}
