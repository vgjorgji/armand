package com.armand.cms.core.content.stub;

import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.content.model.NavItem;
import com.armand.cms.core.content.model.NavItemRepository;
import com.armand.cms.core.design.model.PageRepository;
import com.armand.cms.core.persist.model.Paging;
import com.armand.cms.core.persist.model.PagingSearch;
import com.armand.cms.core.persist.stub.HistoryModelRepositoryStub;
import com.armand.cms.core.website.model.WebsiteViewType;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class NavItemRepositoryStub
    extends HistoryModelRepositoryStub<NavItem>
    implements NavItemRepository {

  private final PageRepository pageRepository;
  private boolean pagesLoaded = false;

  @PostConstruct
  public void init() {
    createNavItemsSchool(1001);
    createNavItemsCurriculum(1002);
    createNavItemsActivities(1003);
    createNavItemsChildren(1004);
    pagesLoaded = false;
  }

  private void createNavItemsSchool(long mainNavItemId) {
    // information
    NavItem navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1007);
    saveModel(navItem);

    // staff
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1008);
    saveModel(navItem);

    // school board
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1009);
    saveModel(navItem);

    // parents council
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1010);
    saveModel(navItem);

    // documents
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1011);
    saveModel(navItem);
  }

  private void createNavItemsCurriculum(long mainNavItemId) {
    String[] classNumbers = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    // classes
    for (int i = 0; i < classNumbers.length; i++) {
      NavItem navItem = new NavItem();
      navItem.setMainNavItemId(mainNavItemId);
      navItem.setPageId(1012 + i);
      saveModel(navItem);
    }
  }

  private void createNavItemsActivities(long mainNavItemId) {
    // news
    NavItem navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1021);
    saveModel(navItem);

    // gallery
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1022);
    saveModel(navItem);

    // events
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1023);
    saveModel(navItem);

    // projects
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1024);
    saveModel(navItem);

    // surveys
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1025);
    saveModel(navItem);
  }

  private void createNavItemsChildren(long mainNavItemId) {
    // songs and stories
    NavItem navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1026);
    saveModel(navItem);

    // quiz
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1027);
    saveModel(navItem);

    // interesting things
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1028);
    saveModel(navItem);

    // games
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    navItem.setPageId(1029);
    saveModel(navItem);
  }

  @Override
  public Paging<NavItem> getPagingModels(PagingSearch pagingSearch, long websiteId, WebsiteViewType websiteViewType) {
    return getPagingModels(pagingSearch);
  }

  @Override
  protected long getParentId(NavItem model, String parentField) {
    return model.getMainNavItemId();
  }

  @Override
  protected List<NavItem> getList() {
    if (!pagesLoaded) {
      for (NavItem item : super.getList()) {
        item.setPage(pageRepository.getModel(item.getPageId()));
      }
      pagesLoaded = true;
    }
    return super.getList();
  }
}
