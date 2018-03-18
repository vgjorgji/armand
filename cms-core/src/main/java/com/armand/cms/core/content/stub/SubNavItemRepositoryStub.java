package com.armand.cms.core.content.stub;

import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.content.model.SubNavItem;
import com.armand.cms.core.content.model.SubNavItemRepository;
import com.armand.cms.core.design.model.PageRepository;
import com.armand.cms.core.persist.model.Paging;
import com.armand.cms.core.persist.model.PagingSearch;
import com.armand.cms.core.persist.stub.HistoryModelRepositoryStub;
import com.armand.cms.core.website.model.WebsiteViewType;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SubNavItemRepositoryStub
    extends HistoryModelRepositoryStub<SubNavItem>
    implements SubNavItemRepository {

  private final PageRepository pageRepository;
  private boolean pagesLoaded = false;

  @PostConstruct
  public void init() {
    createSubNavItemsInformation(1000);
    createSubNavItemsStaff(1001);
    pagesLoaded = false;
  }

  private void createSubNavItemsInformation(long navItemId) {
    // about us
    SubNavItem subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1030);
    saveModel(subNavItem);

    // ethics and values
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1031);
    saveModel(subNavItem);

    // our mission
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1032);
    saveModel(subNavItem);

    // patronage
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1033);
    saveModel(subNavItem);

    // achievements
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1034);
    saveModel(subNavItem);

    // testimonials
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1035);
    saveModel(subNavItem);

    // partners
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1036);
    saveModel(subNavItem);
  }

  private void createSubNavItemsStaff(long navItemId) {
    // principal
    SubNavItem subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1037);
    saveModel(subNavItem);

    // administration
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1038);
    saveModel(subNavItem);

    // support staff
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1039);
    saveModel(subNavItem);

    // subject teachers
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1040);
    saveModel(subNavItem);

    // class teachers
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1041);
    saveModel(subNavItem);

    // technical personnel
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    subNavItem.setPageId(1042);
    saveModel(subNavItem);
  }

  @Override
  public Paging<SubNavItem> getPagingModels(PagingSearch pagingSearch, long websiteId, WebsiteViewType websiteViewType) {
    return getPagingModels(pagingSearch);
  }

  @Override
  protected long getParentId(SubNavItem model, String parentField) {
    return model.getNavItemId();
  }

  @Override
  protected List<SubNavItem> getList() {
    if (!pagesLoaded) {
      for (SubNavItem item : super.getList()) {
        item.setPage(pageRepository.getModel(item.getPageId()));
      }
      pagesLoaded = true;
    }
    return super.getList();
  }
}
