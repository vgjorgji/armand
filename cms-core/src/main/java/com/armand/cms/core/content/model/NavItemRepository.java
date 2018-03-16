package com.armand.cms.core.content.model;

import com.armand.cms.core.persist.model.HistoryModelRepository;
import com.armand.cms.core.persist.model.Paging;
import com.armand.cms.core.persist.model.PagingSearch;
import com.armand.cms.core.website.model.WebsiteViewType;

public interface NavItemRepository extends HistoryModelRepository<NavItem> {

  Paging<NavItem> getPagingModels(PagingSearch pagingSearch, long websiteId, WebsiteViewType websiteViewType);

}
