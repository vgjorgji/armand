package com.vcms.content.model;

import java.util.List;

public interface HeaderItemRepository extends ContentModelRepository {
	
	List<HeaderItem> getModels(long designComponentId);

}
