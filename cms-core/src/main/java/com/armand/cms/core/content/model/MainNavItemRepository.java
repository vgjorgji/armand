package com.armand.cms.core.content.model;

import java.util.List;

public interface MainNavItemRepository {
	
	List<MainNavItem> getModels(long designComponentId);

}
