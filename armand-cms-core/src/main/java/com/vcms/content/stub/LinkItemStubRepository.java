package com.vcms.content.stub;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vcms.content.model.LinkItem;
import com.vcms.content.model.LinkItemRepository;
import com.vcms.design.model.DesignComponent;
import com.vcms.persist.model.ContentModel;

@Repository
public class LinkItemStubRepository implements LinkItemRepository {

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		return Collections.emptyList();
	}

	@Override
	public List<LinkItem> getModels(long designComponentId) {
		return null;
	}
	
}