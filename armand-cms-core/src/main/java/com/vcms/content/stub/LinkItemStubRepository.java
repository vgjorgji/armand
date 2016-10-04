package com.vcms.content.stub;

import java.util.List;

import com.vcms.content.model.ContactInfoItemRepository;
import com.vcms.design.model.DesignComponent;
import com.vcms.persist.model.ContentModel;

public class LinkItemStubRepository implements ContactInfoItemRepository {

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		return null;
	}

}
