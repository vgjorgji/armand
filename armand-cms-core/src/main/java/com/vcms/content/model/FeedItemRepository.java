package com.vcms.content.model;

import java.util.List;

public interface FeedItemRepository extends ContentModelRepository {
	
	List<FeedItem> getModels(long designComponentId);

}
