package com.armand.cms.core.design.stub;

import java.util.Collections;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.conf.FeedType;
import com.armand.cms.core.conf.Icon;
import com.armand.cms.core.design.model.CmsPage;
import com.armand.cms.core.design.model.ExternalPage;
import com.armand.cms.core.design.model.FeedPage;
import com.armand.cms.core.design.model.Page;
import com.armand.cms.core.design.model.PageRepository;
import com.armand.cms.core.localization.model.LocalTextType;
import com.armand.cms.core.persist.model.Fetch;
import com.armand.cms.core.persist.stub.HistoryModelRepositoryStub;
import com.armand.cms.core.utils.TextUtils;

@Repository
public class PageRepositoryStub
    extends HistoryModelRepositoryStub<Page>
    implements PageRepository {

  @PostConstruct
  public void init() {
    createMainNavPages();
    createNavItems();
    createSubNavItems();
    createExternalPages();
  }

  private void createMainNavPages() {
    // home
    CmsPage page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("home");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Home", "Почетна"));
    saveModel(page);

    // school
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("school");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "School", "Училиште"));
    saveModel(page);

    // curriculum
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("curriculum");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Teaching", "Настава"));
    saveModel(page);

    // activities
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("activities");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Activities", "Активности"));
    saveModel(page);

    // children's corner
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("childrens_corner");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Children's corner", "Детско катче"));
    saveModel(page);

    // research
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("research");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Research", "Истражувања"));
    saveModel(page);

    // contact
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("contact");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Contact", "Контакт"));
    saveModel(page);
  }

  private void createNavItems() {
    createNavItemsSchool();
    createNavItemsCurriculum();
    createNavItemsActivities();
    createNavItemsChildren();
  }

  private void createNavItemsSchool() {
    // information
    CmsPage page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("information");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Infromation", "Информации"));
    saveModel(page);

    // staff
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("staff");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Staff", "Вработени"));
    saveModel(page);

    // school board
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("school_board");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "School board", "Учлишен одбор"));
    saveModel(page);

    // parents council
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("parents_council");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Parents' Council", "Совет на родители"));
    saveModel(page);

    // documents
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("documents");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Documents", "Документи"));
    saveModel(page);
  }

  private void createNavItemsCurriculum() {
    String[] classNumbers = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    // classes
    for (int i = 0; i < classNumbers.length; i++) {
      int classNumber = i + 1;
      CmsPage page = new CmsPage();
      page.setWebsiteViewId(1000);
      page.setUrl(classNumber + "_class");
      page.setTitle(TextUtils.createLocalText(LocalTextType.Small, classNumbers[i] + " class", classNumbers[i] + " одделение"));
      saveModel(page);
    }
  }

  private void createNavItemsActivities() {
    // news
    CmsPage page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("news");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "News", "Новости"));
    saveModel(page);

    // gallery
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("gallery");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Gallery", "Галерија"));
    saveModel(page);

    // events
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("events");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Events", "Настани"));
    saveModel(page);

    // projects
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("projects");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Projects", "Проекти"));
    saveModel(page);

    // surveys
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("surveys");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Surveys", "Анкети"));
    saveModel(page);
  }

  private void createNavItemsChildren() {
    // songs and stories
    CmsPage page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("songs_and_stories");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Songs and Stories", "Песни и Раскази"));
    saveModel(page);

    // quiz
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("quizs");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Quizs", "Квизови"));
    saveModel(page);

    // interesting things
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("interesting_things");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Interesting things", "Занимливости"));
    saveModel(page);

    // games
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("games");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Games", "Игри"));
    saveModel(page);
  }

  private void createSubNavItems() {
    createSubNavItemsInformation();
    createSubNavItemsStaff();
  }

  private void createSubNavItemsInformation() {
    // about us
    CmsPage page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("about_us");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "About us", "За нас"));
    saveModel(page);

    // ethics and values
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("ethics_and_values");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Ethics and Values", "Eтика и Вредности"));
    saveModel(page);

    // our mission
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("our_mission");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Our mission", "Нашата мисија"));
    saveModel(page);

    // patronage
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("patronage");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Patronage", "Патронат"));
    saveModel(page);

    // achievements
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("achievements");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Achievements", "Достигнувања"));
    saveModel(page);

    // testimonials
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("testimonials");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Testimonials", "Што рекоа за нас"));
    saveModel(page);

    // partners
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("partners");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Partners", "Партнери"));
    saveModel(page);
  }

  private void createSubNavItemsStaff() {
    // principal
    CmsPage page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("principal");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Principal", "Директор"));
    saveModel(page);

    // administration
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("administration");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Administration", "Администрација"));
    saveModel(page);

    // support staff
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("support_staff");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Support staff", "Стручни соработници"));
    saveModel(page);

    // subject teachers
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("subject_teachers");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Subject teachers", "Предметна настава"));
    saveModel(page);

    // class teachers
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("class_teachers");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Class teachers", "Одделенска настава"));
    saveModel(page);

    // technical personnel
    page = new CmsPage();
    page.setWebsiteViewId(1000);
    page.setUrl("technical_personnel");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Technical personnel", "Технички персонал"));
    saveModel(page);
  }

  private void createExternalPages() {
    ExternalPage externalPage = new ExternalPage();
    externalPage.setWebsiteViewId(1000);
    externalPage.setIcon(Icon.Facebook);
    externalPage.setUrl("https://www.facebook.com/");
    externalPage.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Facebook", "Facebook"));
    saveModel(externalPage);

    FeedPage feedPage = new FeedPage();
    feedPage.setWebsiteViewId(1000);
    feedPage.setUrl("gallery");
    feedPage.setFeedType(FeedType.Article);
    feedPage.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Gallery Feed", "Галерија Feed"));
    saveModel(feedPage);
  }

  @Override
  public ExternalPage getExternalPage(long websiteViewId, String url) {
    for (Page page : getAllModels().getModels()) {
      if (page instanceof ExternalPage && page.getUrl().equals(url)) {
        return (ExternalPage) page;
      }
    }
    return null;
  }

  @Override
  public CmsPage getCmsPage(long websiteViewId, String url) {
    for (Page page : getAllModels().getModels()) {
      if (page instanceof CmsPage && page.getUrl().equals(url)) {
        return (CmsPage) page;
      }
    }
    return null;
  }

  @Override
  public Fetch<CmsPage> getCmsPages(long websiteViewId) {
    Fetch<Page> models = getModels(Collections.singletonList(websiteViewId), null);
    Fetch<CmsPage> result = new Fetch<>(models.size());
    for (Page page : models.getModels()) {
      if (page instanceof CmsPage) {
        result.put(page.getId(), (CmsPage) page);
      }
    }
    return result;
  }

  @Override
  public FeedPage getFeedPage(long websiteViewId, String url, FeedType feedType) {
    for (Page page : getAllModels().getModels()) {
      if (page instanceof FeedPage && page.getUrl().equals(url)
          && ((FeedPage) page).getFeedType() == feedType) {
        return (FeedPage) page;
      }
    }
    return null;
  }

  @Override
  protected long getParentId(Page model, String parentField) {
    return model.getWebsiteViewId();
  }
}
