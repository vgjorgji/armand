package com.armand.cms.core.content.stub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.content.model.SubNavItem;
import com.armand.cms.core.content.model.SubNavItemRepository;
import com.armand.cms.core.design.model.CmsPage;
import com.armand.cms.core.localization.model.LocalTextType;
import com.armand.cms.core.utils.StubUtils;
import com.armand.cms.core.utils.TextUtils;

@Repository
public class SubNavItemRepositoryStub implements SubNavItemRepository {

	public List<SubNavItem> getModels(long designComponentId) {
		List<SubNavItem> result = new ArrayList<>();
		createSubNavItemsInformation(result, 1000);
		createSubNavItemsStaff(result, 1001);
		return result;
	}
	
	private void createSubNavItemsInformation(List<SubNavItem> result, long navItemId) {
		// about us
		SubNavItem subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1000);
		subNavItem.setNavItemId(navItemId);
		CmsPage page = new CmsPage();
		page.setUrl("about_us");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "About us", "За нас"));
		subNavItem.setPage(page);
		result.add(subNavItem);

		// ethics and values
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1001);
		subNavItem.setNavItemId(navItemId);
		page = new CmsPage();
		page.setUrl("ethics_and_values");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Ethics and Values", "Eтика и Вредности"));
		subNavItem.setPage(page);
		result.add(subNavItem);

		// our mission
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1002);
		subNavItem.setNavItemId(navItemId);
		page = new CmsPage();
		page.setUrl("our_mission");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Our mission", "Нашата мисија"));
		subNavItem.setPage(page);
		result.add(subNavItem);

		// patronage
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1003);
		subNavItem.setNavItemId(navItemId);
		page = new CmsPage();
		page.setUrl("patronage");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Patronage", "Патронат"));
		subNavItem.setPage(page);
		result.add(subNavItem);

		// achievements
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1004);
		subNavItem.setNavItemId(navItemId);
		page = new CmsPage();
		page.setUrl("achievements");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Achievements", "Достигнувања"));
		subNavItem.setPage(page);
		result.add(subNavItem);

		// testimonials
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1005);
		subNavItem.setNavItemId(navItemId);
		page = new CmsPage();
		page.setUrl("testimonials");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Testimonials", "Што рекоа за нас"));
		subNavItem.setPage(page);
		result.add(subNavItem);

		// partners
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1006);
		subNavItem.setNavItemId(navItemId);
		page = new CmsPage();
		page.setUrl("partners");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Partners", "Партнери"));
		subNavItem.setPage(page);
		result.add(subNavItem);
	}

	private void createSubNavItemsStaff(List<SubNavItem> result, long navItemId) {
		// principal
		SubNavItem subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1007);
		subNavItem.setNavItemId(navItemId);
		CmsPage page = new CmsPage();
		page.setUrl("principal");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Principal", "Директор"));
		subNavItem.setPage(page);
		result.add(subNavItem);

		// administration
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1008);
		subNavItem.setNavItemId(navItemId);
		page = new CmsPage();
		page.setUrl("administration");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Administration", "Администрација"));
		subNavItem.setPage(page);
		result.add(subNavItem);

		// support staff
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1009);
		subNavItem.setNavItemId(navItemId);
		page = new CmsPage();
		page.setUrl("support_staff");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Support staff", "Стручни соработници"));
		subNavItem.setPage(page);
		result.add(subNavItem);

		// subject teachers
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1010);
		subNavItem.setNavItemId(navItemId);
		page = new CmsPage();
		page.setUrl("subject_teachers");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Subject teachers", "Предметна настава"));
		subNavItem.setPage(page);
		result.add(subNavItem);

		// class teachers
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1011);
		subNavItem.setNavItemId(navItemId);
		page = new CmsPage();
		page.setUrl("class_teachers");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Class teachers", "Одделенска настава"));
		subNavItem.setPage(page);
		result.add(subNavItem);

		// technical personnel
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1012);
		subNavItem.setNavItemId(navItemId);
		page = new CmsPage();
		page.setUrl("technical_personnel");
		page.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Technical personnel", "Технички персонал"));
		subNavItem.setPage(page);
		result.add(subNavItem);
	}

}