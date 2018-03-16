package com.armand.cms.core.content.stub;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.content.model.MainNavItem;
import com.armand.cms.core.content.model.MainNavItemRepository;
import com.armand.cms.core.design.model.CmsPage;
import com.armand.cms.core.localization.model.LocalTextType;
import com.armand.cms.core.persist.model.Paging;
import com.armand.cms.core.persist.model.PagingSearch;
import com.armand.cms.core.persist.stub.HistoryModelRepositoryStub;
import com.armand.cms.core.utils.TextUtils;
import com.armand.cms.core.website.model.WebsiteViewType;

@Repository
public class MainNavItemRepositoryStub
    extends HistoryModelRepositoryStub<MainNavItem>
    implements MainNavItemRepository {

  @PostConstruct
  public void init() {
    // home
    MainNavItem navItem = new MainNavItem();
    CmsPage page = new CmsPage();
    page.setUrl("home");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Home", "Почетна"));
    navItem.setPage(page);
    saveModel(navItem);

    // school
    navItem = new MainNavItem();
    page = new CmsPage();
    page.setUrl("school");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "School", "Училиште"));
    navItem.setPage(page);
    saveModel(navItem);

    // curriculum
    navItem = new MainNavItem();
    page = new CmsPage();
    page.setUrl("curriculum");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Teaching", "Настава"));
    navItem.setPage(page);
    saveModel(navItem);

    // activities
    navItem = new MainNavItem();
    page = new CmsPage();
    page.setUrl("activities");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Activities", "Активности"));
    navItem.setPage(page);
    saveModel(navItem);

    // children's corner
    navItem = new MainNavItem();
    page = new CmsPage();
    page.setUrl("childrens_corner");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Children's corner", "Детско катче"));
    navItem.setPage(page);
    saveModel(navItem);

    // research
    navItem = new MainNavItem();
    page = new CmsPage();
    page.setUrl("research");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Research", "Истражувања"));
    navItem.setPage(page);
    saveModel(navItem);

    // contact
    navItem = new MainNavItem();
    page = new CmsPage();
    page.setUrl("contact");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Contact", "Контакт"));
    navItem.setPage(page);
    saveModel(navItem);
  }

  @Override
  public MainNavItem getModel(long id) {
    return null;
  }

  @Override
  public Paging<MainNavItem> getPagingModels(PagingSearch pagingSearch, long websiteId, WebsiteViewType websiteViewType) {
    return getPagingModels(pagingSearch);
  }
}
