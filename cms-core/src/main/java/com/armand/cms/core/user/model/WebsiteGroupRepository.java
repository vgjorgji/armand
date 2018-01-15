package com.armand.cms.core.user.model;

import java.util.Collection;

import com.armand.cms.core.persist.model.Fetch;
import com.armand.cms.core.persist.model.HistoryModelRepository;

public interface WebsiteGroupRepository extends HistoryModelRepository<WebsiteGroup> {

  Fetch<WebsiteGroup> getGroupsForWebsites(Collection<Long> websiteIds);

}
