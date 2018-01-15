package com.armand.cms.core.content.model;

import java.util.List;

public interface HeaderItemRepository extends ContentModelRepository {

  List<HeaderItem> getModels(long designComponentId);

}
