package com.armand.cms.core.content.model;

import java.util.List;

public interface ParagraphItemRepository extends ContentModelRepository {

  List<ParagraphItem> getModels(long designComponentId);

}
