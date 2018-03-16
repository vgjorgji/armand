package com.armand.cms.core.content.stub;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.content.model.SubNavItem;
import com.armand.cms.core.content.model.SubNavItemRepository;
import com.armand.cms.core.design.model.CmsPage;
import com.armand.cms.core.localization.model.LocalTextType;
import com.armand.cms.core.persist.model.Paging;
import com.armand.cms.core.persist.model.PagingSearch;
import com.armand.cms.core.persist.stub.HistoryModelRepositoryStub;
import com.armand.cms.core.utils.TextUtils;
import com.armand.cms.core.website.model.WebsiteViewType;

@Repository
public class SubNavItemRepositoryStub
    extends HistoryModelRepositoryStub<SubNavItem>
    implements SubNavItemRepository {

  @PostConstruct
  public void init() {
    createSubNavItemsInformation(1000);
    createSubNavItemsStaff(1001);
  }

  private void createSubNavItemsInformation(long navItemId) {
    // about us
    SubNavItem subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    CmsPage page = new CmsPage();
    page.setUrl("about_us");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "About us", "За нас"));
    subNavItem.setPage(page);
    saveModel(subNavItem);

    // ethics and values
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    page = new CmsPage();
    page.setUrl("ethics_and_values");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Ethics and Values", "Eтика и Вредности"));
    subNavItem.setPage(page);
    saveModel(subNavItem);

    // our mission
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    page = new CmsPage();
    page.setUrl("our_mission");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Our mission", "Нашата мисија"));
    subNavItem.setPage(page);
    saveModel(subNavItem);

    // patronage
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    page = new CmsPage();
    page.setUrl("patronage");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Patronage", "Патронат"));
    subNavItem.setPage(page);
    saveModel(subNavItem);

    // achievements
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    page = new CmsPage();
    page.setUrl("achievements");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Achievements", "Достигнувања"));
    subNavItem.setPage(page);
    saveModel(subNavItem);

    // testimonials
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    page = new CmsPage();
    page.setUrl("testimonials");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Testimonials", "Што рекоа за нас"));
    subNavItem.setPage(page);
    saveModel(subNavItem);

    // partners
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    page = new CmsPage();
    page.setUrl("partners");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Partners", "Партнери"));
    subNavItem.setPage(page);
    saveModel(subNavItem);
  }

  private void createSubNavItemsStaff(long navItemId) {
    // principal
    SubNavItem subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    CmsPage page = new CmsPage();
    page.setUrl("principal");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Principal", "Директор"));
    subNavItem.setPage(page);
    saveModel(subNavItem);

    // administration
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    page = new CmsPage();
    page.setUrl("administration");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Administration", "Администрација"));
    subNavItem.setPage(page);
    saveModel(subNavItem);

    // support staff
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    page = new CmsPage();
    page.setUrl("support_staff");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Support staff", "Стручни соработници"));
    subNavItem.setPage(page);
    saveModel(subNavItem);

    // subject teachers
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    page = new CmsPage();
    page.setUrl("subject_teachers");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Subject teachers", "Предметна настава"));
    subNavItem.setPage(page);
    saveModel(subNavItem);

    // class teachers
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    page = new CmsPage();
    page.setUrl("class_teachers");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Class teachers", "Одделенска настава"));
    subNavItem.setPage(page);
    saveModel(subNavItem);

    // technical personnel
    subNavItem = new SubNavItem();
    subNavItem.setNavItemId(navItemId);
    page = new CmsPage();
    page.setUrl("technical_personnel");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Technical personnel", "Технички персонал"));
    subNavItem.setPage(page);
    saveModel(subNavItem);
  }

  @Override
  public Paging<SubNavItem> getPagingModels(PagingSearch pagingSearch, long websiteId, WebsiteViewType websiteViewType) {
    return getPagingModels(pagingSearch);
  }
}
