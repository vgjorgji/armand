package com.vcms.design.stub;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.classify.model.Categories;
import com.vcms.classify.model.Category;
import com.vcms.conf.cms.Component;
import com.vcms.conf.cms.ComponentStyle;
import com.vcms.conf.cms.FeedType;
import com.vcms.conf.cms.Icon;
import com.vcms.conf.cms.ItemsLayout;
import com.vcms.conf.cms.ModernColor;
import com.vcms.conf.cms.SingleColor;
import com.vcms.content.model.Align;
import com.vcms.content.model.ContactInfoItem;
import com.vcms.content.model.FeedItem;
import com.vcms.content.model.FooterItem;
import com.vcms.content.model.HighlightItem;
import com.vcms.content.model.JumbotronItem;
import com.vcms.content.model.MainNavItem;
import com.vcms.content.model.NavItem;
import com.vcms.content.model.Paragraph;
import com.vcms.content.model.ParagraphItem;
import com.vcms.content.model.ParagraphLayout;
import com.vcms.content.model.SubNavItem;
import com.vcms.content.model.Title;
import com.vcms.content.model.TitleItem;
import com.vcms.design.model.DesignComponent;
import com.vcms.design.model.DesignComponentRepository;
import com.vcms.design.model.FeedDesignComponent;
import com.vcms.design.model.FeedFilter;
import com.vcms.design.model.LayoutPosition;
import com.vcms.hashtag.model.HashTag;
import com.vcms.hashtag.model.HashTags;
import com.vcms.localization.model.Language;
import com.vcms.localization.model.LocalText;
import com.vcms.localization.model.LocalTextType;
import com.vcms.media.model.Media;
import com.vcms.media.model.MediaType;
import com.vcms.persist.model.ContentModel;
import com.vcms.utils.StubUtils;
import com.vcms.utils.Utils;
import com.vcms.website.model.CmsPage;
import com.vcms.website.model.ExternalPage;
import com.vcms.website.model.FeedPage;

@Repository
public class DesignComponentStubRepository implements DesignComponentRepository {
	
	private List<DesignComponent> list = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		// header
		DesignComponent component = StubUtils.createStubDbModel(new DesignComponent(), 1000);
		component.setPageDesignId(1000);
		component.setComponent(Component.Header);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Header);
		component.setSortOrder(0);
		list.add(component);
		
		// navigation
		component = StubUtils.createStubDbModel(new DesignComponent(), 1001);
		component.setPageDesignId(1000);
		component.setComponent(Component.Navigation);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Header);
		component.setSortOrder(1);
		component.setContentModels(createNavigation());
		list.add(component);
		
		// jumbotron
		component = StubUtils.createStubDbModel(new DesignComponent(), 1002);
		component.setPageDesignId(1000);
		component.setComponent(Component.Jumbotron);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Header);
		component.setSortOrder(2);
		component.setContentModels(createJumbotron());
		list.add(component);
		
		
		// paragraph container (about us)
		component = StubUtils.createStubDbModel(new DesignComponent(), 1004);
		component.setPageDesignId(1000);
		component.setComponent(Component.Paragraphs);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Top);
		component.setSortOrder(4);
		component.setContentModels(createParagraphAboutUs());
		list.add(component);
		
		// highlights
		component = StubUtils.createStubDbModel(new DesignComponent(), 1003);
		component.setPageDesignId(1000);
		component.setComponent(Component.Highlights);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Top);
		component.setBackgroundColor(SingleColor.VeryLightGray);
		component.setItemsLayout(ItemsLayout.FourColumns);
		component.setSortOrder(3);
		component.setContentModels(createHighlights());
		list.add(component);
		
		// gallery title
		component = StubUtils.createStubDbModel(new DesignComponent(), 1003);
		component.setPageDesignId(1000);
		component.setComponent(Component.Titles);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Top);
		component.setSortOrder(3);
		component.setContentModels(new ArrayList<ContentModel>());
		component.getContentModels().add(createTitleItem("Gallery", "Галерија"));
		list.add(component);
		
		// gallery
		FeedDesignComponent feedComponent = StubUtils.createStubDbModel(new FeedDesignComponent(), 1052);
		feedComponent.setPageDesignId(1000);
		feedComponent.setComponent(Component.Feed);
		feedComponent.setComponentStyle(ComponentStyle.Learn);
		feedComponent.setLayoutPosition(LayoutPosition.Top);
		feedComponent.setSortOrder(0);
		feedComponent.setFeedType(FeedType.Album);
		feedComponent.setFeedFilter(FeedFilter.Latest);
		feedComponent.setItemsLayout(ItemsLayout.TwoColumns);
		feedComponent.getFeedItemLayout().setTitleAsLink(false);
		feedComponent.getFeedItemLayout().setText(false);
		feedComponent.getFeedItemLayout().setLink(false);
		feedComponent.getFeedItemLayout().setHashTags(false);
		feedComponent.getFeedItemLayout().setStats(false);
		feedComponent.setContentModels(createGallery());
		list.add(feedComponent);
		
		
		// CENTER: news latest title
		component = StubUtils.createStubDbModel(new DesignComponent(), 1003);
		component.setPageDesignId(1000);
		component.setComponent(Component.Titles);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Center);
		component.setBackgroundColor(SingleColor.VeryLightGray);
		component.setSortOrder(3);
		component.setContentModels(new ArrayList<ContentModel>());
		component.getContentModels().add(createTitleItem("News", "Новости"));
		list.add(component);
		
		// news latest
		feedComponent = StubUtils.createStubDbModel(new FeedDesignComponent(), 1060);
		feedComponent.setPageDesignId(1000);
		feedComponent.setComponent(Component.Feed);
		feedComponent.setComponentStyle(ComponentStyle.Learn);
		feedComponent.setLayoutPosition(LayoutPosition.Center);
		feedComponent.setSortOrder(0);
		feedComponent.setFeedFilter(FeedFilter.Latest);
		feedComponent.setItemsLayout(ItemsLayout.OneColumn);
		feedComponent.getFeedItemLayout().setTitleAsLink(false);
		feedComponent.setContentModels(createNews());
		list.add(feedComponent);
		
		// news popular title
		component = StubUtils.createStubDbModel(new DesignComponent(), 1003);
		component.setPageDesignId(1000);
		component.setComponent(Component.Titles);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Right);
		component.setSortOrder(3);
		component.setContentModels(new ArrayList<ContentModel>());
		component.getContentModels().add(createTitleItem("Popular", "Популарни"));
		list.add(component);
		
		// news popular
		feedComponent = StubUtils.createStubDbModel(new FeedDesignComponent(), 1061);
		feedComponent.setPageDesignId(1000);
		feedComponent.setComponent(Component.Feed);
		feedComponent.setComponentStyle(ComponentStyle.Learn);
		feedComponent.setLayoutPosition(LayoutPosition.Right);
		feedComponent.setSortOrder(0);
		feedComponent.setFeedFilter(FeedFilter.Popular);
		feedComponent.setItemsLayout(ItemsLayout.OneColumn);
		feedComponent.getFeedItemLayout().setLink(false);
		feedComponent.getFeedItemLayout().setText(false);
		feedComponent.getFeedItemLayout().setHashTags(false);
		feedComponent.getFeedItemLayout().setStats(false);
		feedComponent.setContentModels(createNews());
		list.add(feedComponent);
		
		
		// paragraph container (test)
		component = StubUtils.createStubDbModel(new DesignComponent(), 1051);
		component.setPageDesignId(1000);
		component.setComponent(Component.Paragraphs);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Bottom);
		component.setSortOrder(4);
		component.setContentModels(createParagraphs());
		list.add(component);
		
		// news popular title
		component = StubUtils.createStubDbModel(new DesignComponent(), 1003);
		component.setPageDesignId(1000);
		component.setComponent(Component.Titles);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Bottom);
		component.setSortOrder(3);
		component.setContentModels(new ArrayList<ContentModel>());
		component.getContentModels().add(createTitleItem("How to find us", "Како да не најдете"));
		list.add(component);
		
		// contact info
		component = StubUtils.createStubDbModel(new DesignComponent(), 1038);
		component.setPageDesignId(1000);
		component.setComponent(Component.ContactInfos);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Bottom);
		component.setSortOrder(38);
		component.setContentModels(createContactInfo());
		list.add(component);
		
		// contact form
		component = StubUtils.createStubDbModel(new DesignComponent(), 1039);
		component.setPageDesignId(1000);
		component.setComponent(Component.ContactForms);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Bottom);
		component.setSortOrder(39);
		list.add(component);
		
		
		// footer
		component = StubUtils.createStubDbModel(new DesignComponent(), 1040);
		component.setPageDesignId(1000);
		component.setComponent(Component.Footer);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Footer);
		component.setSortOrder(40);
		component.setContentModels(createFooter());
		list.add(component);
	}
	
	
	private List<ContentModel> createNavigation() {
		List<ContentModel> navigation = new ArrayList<>();

		// home
		MainNavItem navItem = StubUtils.createStubDbModel(new MainNavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("home");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Home", "Почетна"));
		navItem.setPage(page);
		navigation.add(navItem);

		// school
		navItem = StubUtils.createStubDbModel(new MainNavItem(), 1001);
		page = new CmsPage();
		page.setUrl("school");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "School", "Училиште"));
		navItem.setPage(page);
		navItem.setNavItems(createNavItemsSchool());
		navigation.add(navItem);

		// curriculum
		navItem = StubUtils.createStubDbModel(new MainNavItem(), 1002);
		page = new CmsPage();
		page.setUrl("curriculum");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Curriculum", "Наставна програма"));
		navItem.setPage(page);
		navItem.setNavItems(createNavItemsCurriculum());
		navigation.add(navItem);

		// activities
		navItem = StubUtils.createStubDbModel(new MainNavItem(), 1003);
		page = new CmsPage();
		page.setUrl("activities");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Activities", "Активности"));
		navItem.setPage(page);
		navItem.setNavItems(createNavItemsActivities());
		navigation.add(navItem);

		// children's corner
		navItem = StubUtils.createStubDbModel(new MainNavItem(), 1004);
		page = new CmsPage();
		page.setUrl("childrens_corner");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Children's corner", "Детско катче"));
		navItem.setPage(page);
		navItem.setNavItems(createNavItemsChildren());
		navigation.add(navItem);

		// research
		navItem = StubUtils.createStubDbModel(new MainNavItem(), 1005);
		page = new CmsPage();
		page.setUrl("research");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Research", "Истражувања"));
		navItem.setPage(page);
		navigation.add(navItem);

		// contact
		navItem = StubUtils.createStubDbModel(new MainNavItem(), 1006);
		page = new CmsPage();
		page.setUrl("contact");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Contact", "Контакт"));
		navItem.setPage(page);
		navigation.add(navItem);

		// result
		return navigation;
	}


	private List<NavItem> createNavItemsSchool() {
		List<NavItem> school = new ArrayList<>();

		// information
		NavItem navItem = StubUtils.createStubDbModel(new NavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("information");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Infromation", "Информации"));
		navItem.setPage(page);
		navItem.setSubNavItems(createSubNavItemsInformation());
		school.add(navItem);

		// staff
		navItem = StubUtils.createStubDbModel(new NavItem(), 1001);
		page = new CmsPage();
		page.setUrl("staff");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Staff", "Вработени"));
		navItem.setPage(page);
		navItem.setSubNavItems(createSubNavItemsStaff());
		school.add(navItem);

		// school board
		navItem = StubUtils.createStubDbModel(new NavItem(), 1002);
		page = new CmsPage();
		page.setUrl("school_board");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "School board", "Учлишен одбор"));
		navItem.setPage(page);
		school.add(navItem);
		
		// parents council
		navItem = StubUtils.createStubDbModel(new NavItem(), 1003);
		page = new CmsPage();
		page.setUrl("parents_council");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Parents' Council", "Совет на родители"));
		navItem.setPage(page);
		school.add(navItem);

		// documents
		navItem = StubUtils.createStubDbModel(new NavItem(), 1004);
		page = new CmsPage();
		page.setUrl("documents");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Documents", "Документи"));
		navItem.setPage(page);
		school.add(navItem);

		// result
		return school;
	}
	
	private List<SubNavItem> createSubNavItemsInformation() {
		List<SubNavItem> information = new ArrayList<>();

		// about us
		SubNavItem subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("about_us");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "About us", "За нас"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// ethics and values
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1001);
		page = new CmsPage();
		page.setUrl("ethics_and_values");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Ethics and Values", "Eтика и Вредности"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// our mission
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1002);
		page = new CmsPage();
		page.setUrl("our_mission");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Our mission", "Нашата мисија"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// patronage
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1003);
		page = new CmsPage();
		page.setUrl("patronage");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Patronage", "Патронат"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// achievements
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1004);
		page = new CmsPage();
		page.setUrl("achievements");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Achievements", "Достигнувања"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// testimonials
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1005);
		page = new CmsPage();
		page.setUrl("testimonials");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Testimonials", "Што рекоа за нас"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// partners
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1006);
		page = new CmsPage();
		page.setUrl("partners");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Partners", "Партнери"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// result
		return information;
	}

	private List<SubNavItem> createSubNavItemsStaff() {
		List<SubNavItem> staff = new ArrayList<>();

		// principal
		SubNavItem subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("principal");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Principal", "Директор"));
		subNavItem.setPage(page);
		staff.add(subNavItem);

		// administration
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1001);
		page = new CmsPage();
		page.setUrl("administration");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Administration", "Администрација"));
		subNavItem.setPage(page);
		staff.add(subNavItem);

		// support staff
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1002);
		page = new CmsPage();
		page.setUrl("support_staff");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Support staff", "Стручни соработници"));
		subNavItem.setPage(page);
		staff.add(subNavItem);

		// subject teachers
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1003);
		page = new CmsPage();
		page.setUrl("subject_teachers");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Subject teachers", "Предметна настава"));
		subNavItem.setPage(page);
		staff.add(subNavItem);

		// class teachers
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1004);
		page = new CmsPage();
		page.setUrl("class_teachers");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Class teachers", "Одделенска настава"));
		subNavItem.setPage(page);
		staff.add(subNavItem);

		// technical personnel
		subNavItem = StubUtils.createStubDbModel(new SubNavItem(), 1005);
		page = new CmsPage();
		page.setUrl("technical_personnel");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Technical personnel", "Технички персонал"));
		subNavItem.setPage(page);
		staff.add(subNavItem);

		// result
		return staff;
	}
	
	private List<NavItem> createNavItemsCurriculum() {
		List<NavItem> curriculum = new ArrayList<>();
		String[] classNumbers = new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

		// classes
		for (int i = 0; i < classNumbers.length; i++) {
			int classNumber = i + 1;
			NavItem navItem = StubUtils.createStubDbModel(new NavItem(), 1000 + classNumber);
			CmsPage page = new CmsPage();
			page.setUrl(classNumber + "_class");
			page.setTitle(StubUtils.createLocalText(LocalTextType.Small, classNumbers[i] + " class", classNumbers[i] + " одделение"));
			navItem.setPage(page);
			curriculum.add(navItem);
		}

		// result
		return curriculum;
	}

	private List<NavItem> createNavItemsActivities() {
		List<NavItem> activities = new ArrayList<>();

		// news
		NavItem navItem = StubUtils.createStubDbModel(new NavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("news");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "News", "Новости"));
		navItem.setPage(page);
		activities.add(navItem);
		
		// gallery
		navItem = StubUtils.createStubDbModel(new NavItem(), 1002);
		page = new CmsPage();
		page.setUrl("gallery");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Gallery", "Галерија"));
		navItem.setPage(page);
		activities.add(navItem);

		// events
		navItem = StubUtils.createStubDbModel(new NavItem(), 1001);
		page = new CmsPage();
		page.setUrl("events");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Events", "Настани"));
		navItem.setPage(page);
		activities.add(navItem);

		// projects
		navItem = StubUtils.createStubDbModel(new NavItem(), 1003);
		page = new CmsPage();
		page.setUrl("projects");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Projects", "Проекти"));
		navItem.setPage(page);
		activities.add(navItem);

		// surveys
		navItem = StubUtils.createStubDbModel(new NavItem(), 1004);
		page = new CmsPage();
		page.setUrl("surveys");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Surveys", "Анкети"));
		navItem.setPage(page);
		activities.add(navItem);

		// result
		return activities;
	}
	
	private List<NavItem> createNavItemsChildren() {
		List<NavItem> children = new ArrayList<>();

		// songs and stories
		NavItem navItem = StubUtils.createStubDbModel(new NavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("songs_and_stories");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Songs and Stories", "Песни и Раскази"));
		navItem.setPage(page);
		children.add(navItem);

		// quiz
		navItem = StubUtils.createStubDbModel(new NavItem(), 1001);
		page = new CmsPage();
		page.setUrl("quizs");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Quizs", "Квизови"));
		navItem.setPage(page);
		children.add(navItem);

		// interesting things
		navItem = StubUtils.createStubDbModel(new NavItem(), 1002);
		page = new CmsPage();
		page.setUrl("interesting_things");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Interesting things", "Занимливости"));
		navItem.setPage(page);
		children.add(navItem);

		// games
		navItem = StubUtils.createStubDbModel(new NavItem(), 1003);
		page = new CmsPage();
		page.setUrl("games");
		page.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Games", "Игри"));
		navItem.setPage(page);
		children.add(navItem);

		// result
		return children;
	}
	
	private List<ContentModel> createJumbotron() {
		List<ContentModel> jumbotron = new ArrayList<>();
		
		// 1
		JumbotronItem jumbotronItem = StubUtils.createStubDbModel(new JumbotronItem(), 1000);
		Title title = createTitle("Header 1", "Наслов 1");
		Paragraph paragraph = createJumbotronParagraph();
		jumbotronItem.setTitle(title);
		jumbotronItem.setParagraph(paragraph);
		jumbotron.add(jumbotronItem);
		
		// 2
		jumbotronItem = StubUtils.createStubDbModel(new JumbotronItem(), 1001);
		title = createTitle("Header 2", "Наслов 2");
		title.setAlign(Align.Center);
		paragraph = createJumbotronParagraph();
		paragraph.setAlign(Align.Center);
		paragraph.getMedia().setSrc("/static/img/2.jpg");
		jumbotronItem.setTitle(title);
		jumbotronItem.setParagraph(paragraph);
		jumbotron.add(jumbotronItem);
		
		// 3
		jumbotronItem = StubUtils.createStubDbModel(new JumbotronItem(), 1002);
		title = createTitle("Long header to see how mutch space there is, and again the same thing",
				"Голем наслов за да се види колку место има, и пак исто ваму и таму");
		title.setAlign(Align.Right);
		paragraph = createJumbotronParagraph();
		paragraph.setAlign(Align.Right);
		paragraph.getMedia().setSrc("/static/img/3.jpg");
		jumbotronItem.setTitle(title);
		jumbotronItem.setParagraph(paragraph);
		jumbotron.add(jumbotronItem);
		
		// result
		return jumbotron;
	}
	
	private TitleItem createTitleItem(String enText, String mkText) {
		TitleItem titleItem = new TitleItem();
		titleItem.setTitle(createTitle(enText, mkText));
		return titleItem;
	}
	
	private Title createTitle(String enText, String mkText) {
		Title title = new Title();
		title.setText(StubUtils.createLocalText(LocalTextType.Normal, enText, mkText));
		return title;
	}

	private Paragraph createJumbotronParagraph() {
		Paragraph paragraph = new Paragraph();

		// text
		paragraph.setText(new LocalText(LocalTextType.Large));
		paragraph.getText().addText(Language.English,
				"Lorem Ipsum is simply dummy text of the printing and"
						+ "	typesetting industry. Lorem Ipsum has been the industry's standard"
						+ "	dummy text ever since the 1500s, when an unknown printer took a"
						+ "	galley of type and scrambled it to make a type specimen book.");
		paragraph.getText().addText(Language.Macedonian,
				"Содржина на македонски јазик. Оваа е обичен текст за да поплни место"
						+ "	и да се добие изглед. Тој ќе се замени потоа со вистински содржински"
						+ "	текст. Текст голем, мал или среден. Александар Македонски е македонски крал од династијата Аргеади, "
						+ " син на Филип II Македонски и Олимпија, ќерка на молоскиот владетел Неоптолем.");

		// media
		Media media = new Media();
		media.setType(MediaType.Image);
		media.setSrc("/static/img/1.jpg");
		media.setExternal(false);
		paragraph.setMedia(media);

		// link to page
		paragraph.setPage(StubUtils.createPageReadMore(new CmsPage()));
		return paragraph;
	}
	
	private List<ContentModel> createHighlights() {
		List<ContentModel> highlights = new ArrayList<>();

		// 1
		HighlightItem highlightItem = StubUtils.createStubDbModel(new HighlightItem(), 1000);
		highlightItem.setIcon(Icon.Education);
		highlightItem.setTitle(new LocalText(LocalTextType.Small));
		highlightItem.getTitle().addText(Language.English, "Education");
		highlightItem.getTitle().addText(Language.Macedonian, "Образование");
		highlightItem.setText(new LocalText(LocalTextType.Small));
		highlightItem.getText().addText(Language.English,
				"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque explicabo.");
		highlightItem.getText().addText(Language.Macedonian,
				"Содржина на македонски јазик. Оваа е обичен текст за да поплни место и да се добие изглед.");
		highlights.add(highlightItem);

		// 2
		highlightItem = StubUtils.createStubDbModel(new HighlightItem(), 1001);
		highlightItem.setIcon(Icon.Heart);
		highlightItem.setTitle(new LocalText(LocalTextType.Small));
		highlightItem.getTitle().addText(Language.English, "Support");
		highlightItem.getTitle().addText(Language.Macedonian, "Подршка");
		highlightItem.setText(new LocalText(LocalTextType.Small));
		highlightItem.getText().addText(Language.English,
				"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque explicabo.");
		highlightItem.getText().addText(Language.Macedonian,
				"Содржина на македонски јазик. Оваа е обичен текст за да поплни место и да се добие изглед.");
		highlights.add(highlightItem);

		// 3
		highlightItem = StubUtils.createStubDbModel(new HighlightItem(), 1002);
		highlightItem.setIcon(Icon.Star);
		highlightItem.setTitle(new LocalText(LocalTextType.Small));
		highlightItem.getTitle().addText(Language.English, "Guarantee");
		highlightItem.getTitle().addText(Language.Macedonian, "Гаранција");
		highlightItem.setText(new LocalText(LocalTextType.Small));
		highlightItem.getText().addText(Language.English,
				"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque explicabo.");
		highlightItem.getText().addText(Language.Macedonian,
				"Содржина на македонски јазик. Оваа е обичен текст за да поплни место и да се добие изглед.");
		highlights.add(highlightItem);

		// 4
		highlightItem = StubUtils.createStubDbModel(new HighlightItem(), 1003);
		highlightItem.setIcon(Icon.Like);
		highlightItem.setTitle(new LocalText(LocalTextType.Small));
		highlightItem.getTitle().addText(Language.English, "Reliability");
		highlightItem.getTitle().addText(Language.Macedonian, "Веродостојност");
		highlightItem.setText(new LocalText(LocalTextType.Small));
		highlightItem.getText().addText(Language.English,
				"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque explicabo.");
		highlightItem.getText().addText(Language.Macedonian,
				"Содржина на македонски јазик. Оваа е обичен текст за да поплни место и да се добие изглед.");
		highlights.add(highlightItem);

		// result
		return highlights;
	}
	
	
	
	private List<ContentModel> createParagraphAboutUs() {
		List<ContentModel> paragraphContainer = new ArrayList<>();
		
		// 1
		ParagraphItem paragraphItem = StubUtils.createStubDbModel(new ParagraphItem(), 1000);
		Paragraph paragraph = createParagraph();
		paragraph.getMedia().setSrc("/static/img/stub/a1.jpg");
		paragraphItem.setParagraph(paragraph);
		paragraphContainer.add(paragraphItem);
		
		// result
		return paragraphContainer;
	}
	
	private List<ContentModel> createParagraphs() {
		List<ContentModel> paragraphContainer = new ArrayList<>();
		
		// 1
		ParagraphItem paragraphItem = StubUtils.createStubDbModel(new ParagraphItem(), 1000);
		Paragraph paragraph = createParagraph();
		paragraph.getMedia().setSrc("/static/img/stub/a2.jpg");
		paragraph.setLayout(ParagraphLayout.TextRightMediaLeft);
		paragraphItem.setParagraph(paragraph);
		paragraphContainer.add(paragraphItem);
		
		// 2
		paragraphItem = StubUtils.createStubDbModel(new ParagraphItem(), 1001);
		paragraph = createParagraphOnlyText();
		paragraphItem.setParagraph(paragraph);
		paragraphContainer.add(paragraphItem);
		
		// result
		return paragraphContainer;
	}
	
	private List<ContentModel> createFooter() {
		List<ContentModel> footer = new ArrayList<>();

		// facebook
		FooterItem footerItem = StubUtils.createStubDbModel(new FooterItem(), 1000);
		ExternalPage page = new ExternalPage();
		page.setIcon(Icon.Facebook);
		page.setUrl("https://www.facebook.com/");
		footerItem.setPage(page);
		footer.add(footerItem);
		
		// twitter
		footerItem = StubUtils.createStubDbModel(new FooterItem(), 1000);
		page = new ExternalPage();
		page.setIcon(Icon.Twitter);
		page.setUrl("https://www.twitter.com/");
		footerItem.setPage(page);
		footer.add(footerItem);
		
		// youtube
		footerItem = StubUtils.createStubDbModel(new FooterItem(), 1000);
		page = new ExternalPage();
		page.setIcon(Icon.Youtube);
		page.setUrl("https://www.youtube.com/");
		footerItem.setPage(page);
		footer.add(footerItem);
		
		// result
		return footer;
	}
	

	private Paragraph createParagraph() {
		Paragraph paragraph = new Paragraph();
		paragraph.setLayout(ParagraphLayout.TextLeftMediaRight);

		// text
		paragraph.setText(new LocalText(LocalTextType.Rich));
		paragraph.getText().addText(Language.English,
				"<h2>About us</h2>" + "<p>Lorem Ipsum is simply dummy text of the printing and"
						+ "	typesetting industry. Lorem Ipsum has been the industry's standard"
						+ "	dummy text ever since the 1500s, when an unknown printer took a"
						+ "	galley of type and scrambled it to make a type specimen book" + "</p>" + "<ul>" + "	<li>"
						+ "	<a href=\"#\">Ut wisi enim ad minim veniam, quis nostrud</a>" + "	</li>" + "	<li>"
						+ "	<a href=\"#\">Exerci tation ullamcorper suscipit lobortis nisl aliquip</a>" + "	</li>"
						+ "	<li>" + "	<a href=\"#\">Duis autem vel eum iriure dolor</a>" + "	</li>" + "</ul>");
		paragraph.getText().addText(Language.Macedonian,
				"<h2>За нас</h2>" + "<p>Содржина на македонски јазик. Оваа е обичен текст за да поплни место"
						+ "	и да се добие изглед. Тој ќе се замени потоа со вистински содржински"
						+ "	текст. Текст голем, мал или среден. Александар Македонски е македонски крал од династијата Аргеади, "
						+ " син на Филип II Македонски и Олимпија, ќерка на молоскиот владетел Неоптолем. " + "</p>"
						+ "<ul>" + "	<li>" + "	<a href=\"#\">Доаѓање на власт</a>" + "	</li>" + "	<li>"
						+ "	<a href=\"#\">Период на освојувањa</a>" + "	</li>" + "	<li>"
						+ "	<a href=\"#\">Личен живот</a>" + "	</li>" + "</ul>");

		// media
		Media media = new Media();
		media.setType(MediaType.Image);
		media.setSrc("/static/img/1.jpg");
		media.setExternal(false);
		paragraph.setMedia(media);
		
		// return
		return paragraph;
	}


	
	
	private Paragraph createParagraphOnlyText() {
		Paragraph paragraph = new Paragraph();
		paragraph.setLayout(ParagraphLayout.TextLeftMediaRight);
		paragraph.setText(new LocalText(LocalTextType.Rich));
		paragraph.getText().addText(Language.English,
				"<p>Lorem Ipsum is simply dummy text of the printing and"
						+ "	typesetting industry. Lorem Ipsum has been the industry's standard"
						+ "	dummy text ever since the 1500s, when an unknown printer took a"
						+ "	galley of type and scrambled it to make a type specimen book."
						+ " Lorem Ipsum is simply dummy text of the printing and"
						+ "	typesetting industry. Lorem Ipsum has been the industry's standard"
						+ "	dummy text ever since the 1500s, when an unknown printer took a"
						+ "	galley of type and scrambled it to make a type specimen book." + "</p>");
		paragraph.getText().addText(Language.Macedonian,
				"<p>Содржина на македонски јазик. Оваа е обичен текст за да поплни место"
						+ "	и да се добие изглед. Тој ќе се замени потоа со вистински содржински"
						+ "	текст. Текст голем, мал или среден. Александар Македонски е македонски крал од династијата Аргеади, "
						+ " син на Филип II Македонски и Олимпија, ќерка на молоскиот владетел Неоптолем. "
						+ " Содржина на македонски јазик. Оваа е обичен текст за да поплни место"
						+ "	и да се добие изглед. Тој ќе се замени потоа со вистински содржински"
						+ "	текст. Текст голем, мал или среден. Александар Македонски е македонски крал од династијата Аргеади, "
						+ " син на Филип II Македонски и Олимпија, ќерка на молоскиот владетел Неоптолем. " + "</p>");
		
		// link to page
		paragraph.setPage(StubUtils.createPageReadMore(new CmsPage()));
		return paragraph;
	}
	
	
	@Override
	public List<DesignComponent> getDesignComponents(long pageId) {
		return list;
	}

}
