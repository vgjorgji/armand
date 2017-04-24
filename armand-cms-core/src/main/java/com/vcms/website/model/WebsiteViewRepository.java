package com.vcms.website.model;

import com.vcms.persist.model.HistoryModelRepository;

public interface WebsiteViewRepository extends HistoryModelRepository<WebsiteView> {
	
	WebsiteView getModel(long websiteId, WebsiteViewType viewType);

}
