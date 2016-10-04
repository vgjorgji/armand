package com.vcms.content.model;

import java.util.List;

public interface ContactInfoItemRepository extends ContentModelRepository {
	
	List<ContactInfoItem> getModels(long designComponentId);

}
