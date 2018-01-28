package com.armand.cms.core.content.stub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.content.model.MainNavItem;
import com.armand.cms.core.content.model.MainNavItemRepository;
import com.armand.cms.core.design.model.CmsPage;
import com.armand.cms.core.localization.model.LocalTextType;
import com.armand.cms.core.utils.StubUtils;
import com.armand.cms.core.utils.TextUtils;

@Repository
public class MainNavItemRepositoryStub implements MainNavItemRepository {

  public List<MainNavItem> getModels(long designComponentId) {
    List<MainNavItem> result = new ArrayList<>();

    // home
    MainNavItem navItem = StubUtils.createStubDbModel(new MainNavItem(), 1000);
    CmsPage page = new CmsPage();
    page.setUrl("home");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Home", "Почетна"));
    navItem.setPage(page);
    result.add(navItem);

    // school
    navItem = StubUtils.createStubDbModel(new MainNavItem(), 1001);
    page = new CmsPage();
    page.setUrl("school");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "School", "Училиште"));
    navItem.setPage(page);
    result.add(navItem);

    // curriculum
    navItem = StubUtils.createStubDbModel(new MainNavItem(), 1002);
    page = new CmsPage();
    page.setUrl("curriculum");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Teaching", "Настава"));
    navItem.setPage(page);
    result.add(navItem);

    // activities
    navItem = StubUtils.createStubDbModel(new MainNavItem(), 1003);
    page = new CmsPage();
    page.setUrl("activities");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Activities", "Активности"));
    navItem.setPage(page);
    result.add(navItem);

    // children's corner
    navItem = StubUtils.createStubDbModel(new MainNavItem(), 1004);
    page = new CmsPage();
    page.setUrl("childrens_corner");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Children's corner", "Детско катче"));
    navItem.setPage(page);
    result.add(navItem);

    // research
    navItem = StubUtils.createStubDbModel(new MainNavItem(), 1005);
    page = new CmsPage();
    page.setUrl("research");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Research", "Истражувања"));
    navItem.setPage(page);
    result.add(navItem);

    // contact
    navItem = StubUtils.createStubDbModel(new MainNavItem(), 1006);
    page = new CmsPage();
    page.setUrl("contact");
    page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Contact", "Контакт"));
    navItem.setPage(page);
    result.add(navItem);

    // result
    return result;
  }

}
