package com.vcms.content.model;

import java.util.List;

public interface MainNavItemRepository {
	
	List<MainNavItem> getModels(long designComponentId);

}
