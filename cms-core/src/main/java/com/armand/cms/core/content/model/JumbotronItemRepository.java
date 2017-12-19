package com.armand.cms.core.content.model;

import java.util.List;

public interface JumbotronItemRepository extends ContentModelRepository {
	
	List<JumbotronItem> getModels(long designComponentId);

}
