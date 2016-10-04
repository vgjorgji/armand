package com.vcms.content.model;

import java.util.List;

public interface LinkItemRepository extends ContentModelRepository {
	
	List<LinkItem> getModels(long designComponentId);

}
