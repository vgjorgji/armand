package com.armand.cms.core.content.model;

import java.util.List;

public interface NavItemRepository {
	
	List<NavItem> getModels(long designComponentId);

}
