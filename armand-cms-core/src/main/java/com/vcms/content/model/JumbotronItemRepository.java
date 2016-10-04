package com.vcms.content.model;

import java.util.List;

public interface JumbotronItemRepository extends ContentModelRepository {
	
	List<JumbotronItem> getModels(long designComponentId);

}
