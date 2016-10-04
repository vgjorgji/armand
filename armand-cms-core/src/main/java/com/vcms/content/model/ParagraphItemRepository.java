package com.vcms.content.model;

import java.util.List;

public interface ParagraphItemRepository extends ContentModelRepository {
	
	List<ParagraphItem> getModels(long designComponentId);

}
