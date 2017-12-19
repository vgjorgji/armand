package com.armand.cms.core.content.model;

import java.util.List;

public interface FooterItemRepository extends ContentModelRepository {
	
	List<FooterItem> getModels(long designComponentId);

}
