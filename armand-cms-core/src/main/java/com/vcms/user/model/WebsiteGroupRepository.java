package com.vcms.user.model;

import java.util.Collection;

import com.vcms.persist.model.Fetch;
import com.vcms.persist.model.HistoryModelRepository;

public interface WebsiteGroupRepository extends HistoryModelRepository<WebsiteGroup> {

	Fetch<WebsiteGroup> getGroupsForWebsites(Collection<Long> websiteIds);
	
}
