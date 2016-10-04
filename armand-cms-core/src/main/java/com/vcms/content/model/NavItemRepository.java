package com.vcms.content.model;

import java.util.List;

public interface NavItemRepository {
	
	List<NavItem> getModels(long designComponentId);

}
