package com.vcms.content.model;

import java.util.List;

public interface FooterItemRepository extends ContentModelRepository {
	
	List<FooterItem> getModels(long designComponentId);

}
