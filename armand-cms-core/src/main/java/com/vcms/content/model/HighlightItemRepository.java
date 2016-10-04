package com.vcms.content.model;

import java.util.List;

public interface HighlightItemRepository extends ContentModelRepository {
	
	List<HighlightItem> getModels(long designComponentId);

}
