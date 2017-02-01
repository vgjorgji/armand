package com.vcms.content.stub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vcms.content.model.MainNavItem;
import com.vcms.content.model.MainNavItemRepository;
import com.vcms.design.model.CmsPage;
import com.vcms.localization.model.LocalTextType;
import com.vcms.utils.StubUtils;

@Repository
public class MainNavItemStubRepository implements MainNavItemRepository {

	public List<MainNavItem> getModels(long designComponentId) {
		List<MainNavItem> result = new ArrayList<>();

		// home
		MainNavItem navItem = StubUtils.createStubDbModel(new MainNavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("home");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Home", "Почетна"));
		navItem.setPage(page);
		result.add(navItem);

		// school
		navItem = StubUtils.createStubDbModel(new MainNavItem(), 1001);
		page = new CmsPage();
		page.setUrl("school");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "School", "Училиште"));
		navItem.setPage(page);
		result.add(navItem);

		// curriculum
		navItem = StubUtils.createStubDbModel(new MainNavItem(), 1002);
		page = new CmsPage();
		page.setUrl("curriculum");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Curriculum", "Наставна програма"));
		navItem.setPage(page);
		result.add(navItem);

		// activities
		navItem = StubUtils.createStubDbModel(new MainNavItem(), 1003);
		page = new CmsPage();
		page.setUrl("activities");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Activities", "Активности"));
		navItem.setPage(page);
		result.add(navItem);

		// children's corner
		navItem = StubUtils.createStubDbModel(new MainNavItem(), 1004);
		page = new CmsPage();
		page.setUrl("childrens_corner");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Children's corner", "Детско катче"));
		navItem.setPage(page);
		result.add(navItem);

		// research
		navItem = StubUtils.createStubDbModel(new MainNavItem(), 1005);
		page = new CmsPage();
		page.setUrl("research");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Research", "Истражувања"));
		navItem.setPage(page);
		result.add(navItem);

		// contact
		navItem = StubUtils.createStubDbModel(new MainNavItem(), 1006);
		page = new CmsPage();
		page.setUrl("contact");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Contact", "Контакт"));
		navItem.setPage(page);
		result.add(navItem);

		// result
		return result;
	}

}
