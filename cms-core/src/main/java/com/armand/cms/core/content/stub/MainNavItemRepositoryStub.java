package com.armand.cms.core.content.stub;

import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.content.model.MainNavItem;
import com.armand.cms.core.content.model.MainNavItemRepository;
import com.armand.cms.core.design.model.PageRepository;
import com.armand.cms.core.persist.model.Paging;
import com.armand.cms.core.persist.model.PagingSearch;
import com.armand.cms.core.persist.stub.HistoryModelRepositoryStub;
import com.armand.cms.core.website.model.WebsiteViewType;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MainNavItemRepositoryStub
    extends HistoryModelRepositoryStub<MainNavItem>
    implements MainNavItemRepository {

  private final PageRepository pageRepository;
  private boolean pagesLoaded = false;

  @PostConstruct
  public void init() {
    // home
    MainNavItem navItem = new MainNavItem();
    navItem.setWebsiteViewId(1000);
    navItem.setPageId(1000);
    saveModel(navItem);

    // school
    navItem = new MainNavItem();
    navItem.setWebsiteViewId(1000);
    navItem.setPageId(1001);
    saveModel(navItem);

    // curriculum
    navItem = new MainNavItem();
    navItem.setWebsiteViewId(1000);
    navItem.setPageId(1002);
    saveModel(navItem);

    // activities
    navItem = new MainNavItem();
    navItem.setWebsiteViewId(1000);
    navItem.setPageId(1003);
    saveModel(navItem);

    // children's corner
    navItem = new MainNavItem();
    navItem.setWebsiteViewId(1000);
    navItem.setPageId(1004);
    saveModel(navItem);

    // research
    navItem = new MainNavItem();
    navItem.setWebsiteViewId(1000);
    navItem.setPageId(1005);
    saveModel(navItem);

    // contact
    navItem = new MainNavItem();
    navItem.setWebsiteViewId(1000);
    navItem.setPageId(1006);
    saveModel(navItem);

    pagesLoaded = false;
  }

  @Override
  public Paging<MainNavItem> getPagingModels(PagingSearch pagingSearch, long websiteId, WebsiteViewType websiteViewType) {
    return getPagingModels(pagingSearch);
  }

  @Override
  protected boolean searchModel(MainNavItem model, String query) {
    String text = model.getId()
        + "%" + model.getPage().getTitle().getUserText();
    return text.contains(query);
  }

  @Override
  protected long getParentId(MainNavItem model, String parentField) {
    return model.getWebsiteViewId();
  }

  @Override
  protected List<MainNavItem> getList() {
    if (!pagesLoaded) {
      for (MainNavItem item : super.getList()) {
        item.setPage(pageRepository.getModel(item.getPageId()));
      }
      pagesLoaded = true;
    }
    return super.getList();
  }
}
