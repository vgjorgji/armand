package com.vcms.content.stub;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vcms.content.model.ContentModel;
import com.vcms.content.model.LinkItem;
import com.vcms.content.model.LinkItemRepository;
import com.vcms.design.model.DesignComponent;

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
