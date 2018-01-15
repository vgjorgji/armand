package com.armand.cms.core.user.model;

import com.armand.cms.core.persist.model.Fetch;
import com.armand.cms.core.persist.model.HistoryModelRepository;

public interface WebsiteUserRepository extends HistoryModelRepository<WebsiteUser> {

  Fetch<WebsiteUser> getWebsitesForUser(long userId);

  Fetch<WebsiteUser> getUsersForWebsite(long websiteId);

  WebsiteUser getModel(long userId, long websiteId);

}
