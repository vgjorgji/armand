package com.armand.cms.core.content.model;

import java.util.List;

public interface LinkItemRepository extends ContentModelRepository {

  List<LinkItem> getModels(long designComponentId);

}
