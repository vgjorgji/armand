package com.armand.cms.core.content.model;

import java.util.List;

public interface FeedItemRepository extends ContentModelRepository {
	
	List<FeedItem> getModels(long designComponentId);

}
