package com.vcms.content.model;

import java.util.List;

public interface SubNavItemRepository {
	
	List<SubNavItem> getModels(long designComponentId);

}
