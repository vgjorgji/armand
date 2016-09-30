package com.vcms.design.model;

import java.util.List;

public interface DesignComponentRepository {

	List<DesignComponent> getDesignComponents(long pageId);
	
}
