package com.vcms.content.model;

import java.util.List;

public interface TitleItemRepository extends ContentModelRepository {
	
	List<TitleItem> getModels(long designComponentId);

}
