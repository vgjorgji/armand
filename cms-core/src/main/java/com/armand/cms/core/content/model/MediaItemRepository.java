package com.armand.cms.core.content.model;

import java.util.List;

public interface MediaItemRepository extends ContentModelRepository {
	
	List<MediaItem> getModels(long designComponentId);

}
