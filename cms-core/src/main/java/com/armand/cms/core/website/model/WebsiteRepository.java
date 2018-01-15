package com.armand.cms.core.website.model;

import com.armand.cms.core.persist.model.HistoryModelRepository;

public interface WebsiteRepository extends HistoryModelRepository<Website> {

  Website getModel(String name);

}
