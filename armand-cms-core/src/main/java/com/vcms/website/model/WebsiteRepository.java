package com.vcms.website.model;

import com.vcms.persist.model.HistoryModelRepository;

public interface WebsiteRepository extends HistoryModelRepository<Website> {
	
	Website getModel(String name);
	
}
