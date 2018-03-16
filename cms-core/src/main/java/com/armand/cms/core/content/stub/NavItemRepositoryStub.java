package com.armand.cms.core.content.stub;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.content.model.NavItem;
import com.armand.cms.core.content.model.NavItemRepository;
import com.armand.cms.core.design.model.CmsPage;
import com.armand.cms.core.localization.model.LocalTextType;
import com.armand.cms.core.persist.model.Paging;
import com.armand.cms.core.persist.model.PagingSearch;
import com.armand.cms.core.persist.stub.HistoryModelRepositoryStub;
import com.armand.cms.core.utils.TextUtils;
import com.armand.cms.core.website.model.WebsiteViewType;

@Repository
public class NavItemRepositoryStub
    extends HistoryModelRepositoryStub<NavItem>
    implements NavItemRepository {

  @PostConstruct
  public void init() {
    createNavItemsSchool(1001);
    createNavItemsCurriculum(1002);
    createNavItemsActivities(1003);
    createNavItemsChildren(1004);
  }

  private void createNavItemsSchool(long mainNavItemId) {
    // information
    NavItem navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    CmsPage page = new CmsPage();
    page.setUrl("information");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Infromation", "Информации"));
    navItem.setPage(page);
    saveModel(navItem);

    // staff
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    page = new CmsPage();
    page.setUrl("staff");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Staff", "Вработени"));
    navItem.setPage(page);
    saveModel(navItem);

    // school board
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    page = new CmsPage();
    page.setUrl("school_board");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "School board", "Учлишен одбор"));
    navItem.setPage(page);
    saveModel(navItem);

    // parents council
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    page = new CmsPage();
    page.setUrl("parents_council");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Parents' Council", "Совет на родители"));
    navItem.setPage(page);
    saveModel(navItem);

    // documents
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    page = new CmsPage();
    page.setUrl("documents");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Documents", "Документи"));
    navItem.setPage(page);
    saveModel(navItem);
  }

  private void createNavItemsCurriculum(long mainNavItemId) {
    String[] classNumbers = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    // classes
    for (int i = 0; i < classNumbers.length; i++) {
      int classNumber = i + 1;
      NavItem navItem = new NavItem();
      navItem.setMainNavItemId(mainNavItemId);
      CmsPage page = new CmsPage();
      page.setUrl(classNumber + "_class");
      page.setTitle(TextUtils.createLocalText(LocalTextType.Small, classNumbers[i] + " class", classNumbers[i] + " одделение"));
      navItem.setPage(page);
      saveModel(navItem);
    }
  }

  private void createNavItemsActivities(long mainNavItemId) {
    // news
    NavItem navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    CmsPage page = new CmsPage();
    page.setUrl("news");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "News", "Новости"));
    navItem.setPage(page);
    saveModel(navItem);

    // gallery
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    page = new CmsPage();
    page.setUrl("gallery");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Gallery", "Галерија"));
    navItem.setPage(page);
    saveModel(navItem);

    // events
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    page = new CmsPage();
    page.setUrl("events");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Events", "Настани"));
    navItem.setPage(page);
    saveModel(navItem);

    // projects
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    page = new CmsPage();
    page.setUrl("projects");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Projects", "Проекти"));
    navItem.setPage(page);
    saveModel(navItem);

    // surveys
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    page = new CmsPage();
    page.setUrl("surveys");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Surveys", "Анкети"));
    navItem.setPage(page);
    saveModel(navItem);
  }

  private void createNavItemsChildren(long mainNavItemId) {
    // songs and stories
    NavItem navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    CmsPage page = new CmsPage();
    page.setUrl("songs_and_stories");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Songs and Stories", "Песни и Раскази"));
    navItem.setPage(page);
    saveModel(navItem);

    // quiz
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    page = new CmsPage();
    page.setUrl("quizs");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Quizs", "Квизови"));
    navItem.setPage(page);
    saveModel(navItem);

    // interesting things
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    page = new CmsPage();
    page.setUrl("interesting_things");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Interesting things", "Занимливости"));
    navItem.setPage(page);
    saveModel(navItem);

    // games
    navItem = new NavItem();
    navItem.setMainNavItemId(mainNavItemId);
    page = new CmsPage();
    page.setUrl("games");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Games", "Игри"));
    navItem.setPage(page);
    saveModel(navItem);
  }

  @Override
  public Paging<NavItem> getPagingModels(PagingSearch pagingSearch, long websiteId, WebsiteViewType websiteViewType) {
    return getPagingModels(pagingSearch);
  }
}
