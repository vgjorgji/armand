package com.armand.cms.core.website.model;

import com.armand.cms.core.persist.model.HistoryModelRepository;

public interface WebsiteViewRepository extends HistoryModelRepository<WebsiteView> {
	
	WebsiteView getModel(long websiteId, WebsiteViewType viewType);

}
