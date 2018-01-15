package com.armand.cms.core.content.model;

import java.util.List;

public interface ContactInfoItemRepository extends ContentModelRepository {

  List<ContactInfoItem> getModels(long designComponentId);

}
