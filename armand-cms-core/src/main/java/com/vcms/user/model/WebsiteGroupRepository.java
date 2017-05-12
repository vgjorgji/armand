package com.vcms.user.model;

import java.util.Collection;
import java.util.List;

import com.vcms.persist.model.HistoryModelRepository;

public interface WebsiteGroupRepository extends HistoryModelRepository<WebsiteGroup> {

	List<WebsiteGroup> getGroupsForWebsites(Collection<Long> websiteIds);
	
}
