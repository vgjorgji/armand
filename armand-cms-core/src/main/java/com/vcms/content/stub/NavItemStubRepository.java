package com.vcms.content.stub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vcms.content.model.NavItem;
import com.vcms.content.model.NavItemRepository;
import com.vcms.design.model.CmsPage;
import com.vcms.localization.model.LocalTextType;
import com.vcms.utils.StubUtils;
import com.vcms.utils.TextUtils;

@Repository
public class NavItemStubRepository implements NavItemRepository {

	public List<NavItem> getModels(long designComponentId) {
		List<NavItem> result = new ArrayList<>();
		createNavItemsSchool(result, 1001);
		createNavItemsCurriculum(result, 1002);
		createNavItemsActivities(result, 1003);
		createNavItemsChildren(result, 1004);
		return result;
	}
	
	private void createNavItemsSchool(List<NavItem> result, long mainNavItemId) {
		// information
		NavItem navItem = StubUtils.createStubDbModel(new NavItem(), 1000);
		navItem.setMainNavItemId(mainNavItemId);
		CmsPage page = new CmsPage();
		page.setUrl("information");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Infromation", "Информации"));
		navItem.setPage(page);
		result.add(navItem);

		// staff
		navItem = StubUtils.createStubDbModel(new NavItem(), 1001);
		navItem.setMainNavItemId(mainNavItemId);
		page = new CmsPage();
		page.setUrl("staff");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Staff", "Вработени"));
		navItem.setPage(page);
		result.add(navItem);

		// school board
		navItem = StubUtils.createStubDbModel(new NavItem(), 1002);
		navItem.setMainNavItemId(mainNavItemId);
		page = new CmsPage();
		page.setUrl("school_board");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "School board", "Учлишен одбор"));
		navItem.setPage(page);
		result.add(navItem);
		
		// parents council
		navItem = StubUtils.createStubDbModel(new NavItem(), 1003);
		navItem.setMainNavItemId(mainNavItemId);
		page = new CmsPage();
		page.setUrl("parents_council");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Parents' Council", "Совет на родители"));
		navItem.setPage(page);
		result.add(navItem);

		// documents
		navItem = StubUtils.createStubDbModel(new NavItem(), 1004);
		navItem.setMainNavItemId(mainNavItemId);
		page = new CmsPage();
		page.setUrl("documents");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Documents", "Документи"));
		navItem.setPage(page);
		result.add(navItem);
	}
	
	private void createNavItemsCurriculum(List<NavItem> result, long mainNavItemId) {
		String[] classNumbers = new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

		// classes
		for (int i = 0; i < classNumbers.length; i++) {
			int classNumber = i + 1;
			NavItem navItem = StubUtils.createStubDbModel(new NavItem(), 1005 + classNumber);
			navItem.setMainNavItemId(mainNavItemId);
			CmsPage page = new CmsPage();
			page.setUrl(classNumber + "_class");
			page.setTitle(TextUtils.createLocalText(LocalTextType.Small, classNumbers[i] + " class", classNumbers[i] + " одделение"));
			navItem.setPage(page);
			result.add(navItem);
		}
	}
	
	private void createNavItemsActivities(List<NavItem> activities, long mainNavItemId) {
		// news
		NavItem navItem = StubUtils.createStubDbModel(new NavItem(), 1014);
		navItem.setMainNavItemId(mainNavItemId);
		CmsPage page = new CmsPage();
		page.setUrl("news");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "News", "Новости"));
		navItem.setPage(page);
		activities.add(navItem);
		
		// gallery
		navItem = StubUtils.createStubDbModel(new NavItem(), 1015);
		navItem.setMainNavItemId(mainNavItemId);
		page = new CmsPage();
		page.setUrl("gallery");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Gallery", "Галерија"));
		navItem.setPage(page);
		activities.add(navItem);

		// events
		navItem = StubUtils.createStubDbModel(new NavItem(), 1016);
		navItem.setMainNavItemId(mainNavItemId);
		page = new CmsPage();
		page.setUrl("events");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Events", "Настани"));
		navItem.setPage(page);
		activities.add(navItem);

		// projects
		navItem = StubUtils.createStubDbModel(new NavItem(), 1017);
		navItem.setMainNavItemId(mainNavItemId);
		page = new CmsPage();
		page.setUrl("projects");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Projects", "Проекти"));
		navItem.setPage(page);
		activities.add(navItem);

		// surveys
		navItem = StubUtils.createStubDbModel(new NavItem(), 1018);
		navItem.setMainNavItemId(mainNavItemId);
		page = new CmsPage();
		page.setUrl("surveys");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Surveys", "Анкети"));
		navItem.setPage(page);
		activities.add(navItem);
	}
	
	private void createNavItemsChildren(List<NavItem> result, long mainNavItemId) {
		// songs and stories
		NavItem navItem = StubUtils.createStubDbModel(new NavItem(), 1019);
		navItem.setMainNavItemId(mainNavItemId);
		CmsPage page = new CmsPage();
		page.setUrl("songs_and_stories");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Songs and Stories", "Песни и Раскази"));
		navItem.setPage(page);
		result.add(navItem);

		// quiz
		navItem = StubUtils.createStubDbModel(new NavItem(), 1020);
		navItem.setMainNavItemId(mainNavItemId);
		page = new CmsPage();
		page.setUrl("quizs");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Quizs", "Квизови"));
		navItem.setPage(page);
		result.add(navItem);

		// interesting things
		navItem = StubUtils.createStubDbModel(new NavItem(), 1021);
		navItem.setMainNavItemId(mainNavItemId);
		page = new CmsPage();
		page.setUrl("interesting_things");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Interesting things", "Занимливости"));
		navItem.setPage(page);
		result.add(navItem);

		// games
		navItem = StubUtils.createStubDbModel(new NavItem(), 1022);
		navItem.setMainNavItemId(mainNavItemId);
		page = new CmsPage();
		page.setUrl("games");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Games", "Игри"));
		navItem.setPage(page);
		result.add(navItem);
	}

}
