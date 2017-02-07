package com.vcms.content.stub;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vcms.content.model.ContentModel;
import com.vcms.content.model.MediaItem;
import com.vcms.content.model.MediaItemRepository;
import com.vcms.design.model.DesignComponent;

@Repository
public class MediaItemStubRepository implements MediaItemRepository {

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		return Collections.emptyList();
	}

	@Override
	public List<MediaItem> getModels(long designComponentId) {
		return null;
	}
	
}
