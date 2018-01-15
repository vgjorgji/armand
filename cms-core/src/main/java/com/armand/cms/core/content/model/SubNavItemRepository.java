package com.armand.cms.core.content.model;

import java.util.List;

public interface SubNavItemRepository {

  List<SubNavItem> getModels(long designComponentId);

}
