package com.vcms.content.model;

import java.util.List;

import com.vcms.design.model.DesignComponent;

public interface FeedItemRepository extends ContentModelRepository {
	
	List<FeedItem> getModels(DesignComponent designComponent);

}
