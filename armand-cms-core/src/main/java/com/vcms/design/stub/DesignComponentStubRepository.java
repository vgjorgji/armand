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
import com.vcms.design.model.CmsPage;
import com.vcms.design.model.DesignComponent;
import com.vcms.design.model.DesignComponentRepository;
import com.vcms.design.model.ExternalPage;
import com.vcms.design.model.FeedDesignComponent;
import com.vcms.design.model.FeedFilter;
import com.vcms.design.model.FeedPage;
import com.vcms.design.model.LayoutPosition;
import com.vcms.hashtag.model.HashTag;
import com.vcms.hashtag.model.HashTags;
import com.vcms.localization.model.Language;
import com.vcms.localization.model.LocalText;
import com.vcms.localization.model.LocalTextType;
import com.vcms.media.model.Media;
import com.vcms.media.model.MediaType;
import com.vcms.persist.model.ContentModel;
import com.vcms.utils.Utils;

@Repository
public class DesignComponentStubRepository implements DesignComponentRepository {
	
	private List<DesignComponent> list = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		// header
		DesignComponent component = Utils.createStubDbModel(new DesignComponent(), 1000);
		component.setPageId(1000);
		component.setComponent(Component.Header);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Header);
		component.setSortOrder(0);
		list.add(component);
		
		// navigation
		component = Utils.createStubDbModel(new DesignComponent(), 1001);
		component.setPageId(1000);
		component.setComponent(Component.Navigation);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Header);
		component.setSortOrder(1);
		component.setContentModels(createNavigation());
		list.add(component);
		
		// jumbotron
		component = Utils.createStubDbModel(new DesignComponent(), 1002);
		component.setPageId(1000);
		component.setComponent(Component.Jumbotron);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Header);
		component.setSortOrder(2);
		component.setContentModels(createJumbotron());
		list.add(component);
		
		
		// paragraph container (about us)
		component = Utils.createStubDbModel(new DesignComponent(), 1004);
		component.setPageId(1000);
		component.setComponent(Component.Paragraphs);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Top);
		component.setSortOrder(4);
		component.setContentModels(createParagraphAboutUs());
		list.add(component);
		
		// highlights
		component = Utils.createStubDbModel(new DesignComponent(), 1003);
		component.setPageId(1000);
		component.setComponent(Component.Highlights);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Top);
		component.setBackgroundColor(SingleColor.VeryLightGray);
		component.setItemsLayout(ItemsLayout.FourColumns);
		component.setSortOrder(3);
		component.setContentModels(createHighlights());
		list.add(component);
		
		// gallery title
		component = Utils.createStubDbModel(new DesignComponent(), 1003);
		component.setPageId(1000);
		component.setComponent(Component.Titles);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Top);
		component.setSortOrder(3);
		component.setContentModels(new ArrayList<ContentModel>());
		component.getContentModels().add(createTitleItem("Gallery", "Галерија"));
		list.add(component);
		
		// gallery
		FeedDesignComponent feedComponent = Utils.createStubDbModel(new FeedDesignComponent(), 1052);
		feedComponent.setPageId(1000);
		feedComponent.setComponent(Component.Feed);
		feedComponent.setComponentStyle(ComponentStyle.Learn);
		feedComponent.setLayoutPosition(LayoutPosition.Top);
		feedComponent.setSortOrder(0);
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
		component = Utils.createStubDbModel(new DesignComponent(), 1003);
		component.setPageId(1000);
		component.setComponent(Component.Titles);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Center);
		component.setBackgroundColor(SingleColor.VeryLightGray);
		component.setSortOrder(3);
		component.setContentModels(new ArrayList<ContentModel>());
		component.getContentModels().add(createTitleItem("News", "Новости"));
		list.add(component);
		
		// news latest
		feedComponent = Utils.createStubDbModel(new FeedDesignComponent(), 1060);
		feedComponent.setPageId(1000);
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
		component = Utils.createStubDbModel(new DesignComponent(), 1003);
		component.setPageId(1000);
		component.setComponent(Component.Titles);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Right);
		component.setSortOrder(3);
		component.setContentModels(new ArrayList<ContentModel>());
		component.getContentModels().add(createTitleItem("Popular", "Популарни"));
		list.add(component);
		
		// news popular
		feedComponent = Utils.createStubDbModel(new FeedDesignComponent(), 1061);
		feedComponent.setPageId(1000);
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
		component = Utils.createStubDbModel(new DesignComponent(), 1051);
		component.setPageId(1000);
		component.setComponent(Component.Paragraphs);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Bottom);
		component.setSortOrder(4);
		component.setContentModels(createParagraphs());
		list.add(component);
		
		// news popular title
		component = Utils.createStubDbModel(new DesignComponent(), 1003);
		component.setPageId(1000);
		component.setComponent(Component.Titles);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Bottom);
		component.setSortOrder(3);
		component.setContentModels(new ArrayList<ContentModel>());
		component.getContentModels().add(createTitleItem("How to find us", "Како да не најдете"));
		list.add(component);
		
		// contact info
		component = Utils.createStubDbModel(new DesignComponent(), 1038);
		component.setPageId(1000);
		component.setComponent(Component.ContactInfos);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Bottom);
		component.setSortOrder(38);
		component.setContentModels(createContactInfo());
		list.add(component);
		
		// contact form
		component = Utils.createStubDbModel(new DesignComponent(), 1039);
		component.setPageId(1000);
		component.setComponent(Component.ContactForms);
		component.setComponentStyle(ComponentStyle.Learn);
		component.setLayoutPosition(LayoutPosition.Bottom);
		component.setSortOrder(39);
		list.add(component);
		
		
		// footer
		component = Utils.createStubDbModel(new DesignComponent(), 1040);
		component.setPageId(1000);
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
		MainNavItem navItem = Utils.createStubDbModel(new MainNavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("home");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Home", "Почетна"));
		navItem.setPage(page);
		navigation.add(navItem);

		// school
		navItem = Utils.createStubDbModel(new MainNavItem(), 1001);
		page = new CmsPage();
		page.setUrl("school");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "School", "Училиште"));
		navItem.setPage(page);
		navItem.setNavItems(createNavItemsSchool());
		navigation.add(navItem);

		// curriculum
		navItem = Utils.createStubDbModel(new MainNavItem(), 1002);
		page = new CmsPage();
		page.setUrl("curriculum");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Curriculum", "Наставна програма"));
		navItem.setPage(page);
		navItem.setNavItems(createNavItemsCurriculum());
		navigation.add(navItem);

		// activities
		navItem = Utils.createStubDbModel(new MainNavItem(), 1003);
		page = new CmsPage();
		page.setUrl("activities");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Activities", "Активности"));
		navItem.setPage(page);
		navItem.setNavItems(createNavItemsActivities());
		navigation.add(navItem);

		// children's corner
		navItem = Utils.createStubDbModel(new MainNavItem(), 1004);
		page = new CmsPage();
		page.setUrl("childrens_corner");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Children's corner", "Детско катче"));
		navItem.setPage(page);
		navItem.setNavItems(createNavItemsChildren());
		navigation.add(navItem);

		// research
		navItem = Utils.createStubDbModel(new MainNavItem(), 1005);
		page = new CmsPage();
		page.setUrl("research");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Research", "Истражувања"));
		navItem.setPage(page);
		navigation.add(navItem);

		// contact
		navItem = Utils.createStubDbModel(new MainNavItem(), 1006);
		page = new CmsPage();
		page.setUrl("contact");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Contact", "Контакт"));
		navItem.setPage(page);
		navigation.add(navItem);

		// result
		return navigation;
	}


	private List<NavItem> createNavItemsSchool() {
		List<NavItem> school = new ArrayList<>();

		// information
		NavItem navItem = Utils.createStubDbModel(new NavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("information");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Infromation", "Информации"));
		navItem.setPage(page);
		navItem.setSubNavItems(createSubNavItemsInformation());
		school.add(navItem);

		// staff
		navItem = Utils.createStubDbModel(new NavItem(), 1001);
		page = new CmsPage();
		page.setUrl("staff");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Staff", "Вработени"));
		navItem.setPage(page);
		navItem.setSubNavItems(createSubNavItemsStaff());
		school.add(navItem);

		// school board
		navItem = Utils.createStubDbModel(new NavItem(), 1002);
		page = new CmsPage();
		page.setUrl("school_board");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "School board", "Учлишен одбор"));
		navItem.setPage(page);
		school.add(navItem);
		
		// parents council
		navItem = Utils.createStubDbModel(new NavItem(), 1003);
		page = new CmsPage();
		page.setUrl("parents_council");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Parents' Council", "Совет на родители"));
		navItem.setPage(page);
		school.add(navItem);

		// documents
		navItem = Utils.createStubDbModel(new NavItem(), 1004);
		page = new CmsPage();
		page.setUrl("documents");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Documents", "Документи"));
		navItem.setPage(page);
		school.add(navItem);

		// result
		return school;
	}
	
	private List<SubNavItem> createSubNavItemsInformation() {
		List<SubNavItem> information = new ArrayList<>();

		// about us
		SubNavItem subNavItem = Utils.createStubDbModel(new SubNavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("about_us");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "About us", "За нас"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// ethics and values
		subNavItem = Utils.createStubDbModel(new SubNavItem(), 1001);
		page = new CmsPage();
		page.setUrl("ethics_and_values");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Ethics and Values", "Eтика и Вредности"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// our mission
		subNavItem = Utils.createStubDbModel(new SubNavItem(), 1002);
		page = new CmsPage();
		page.setUrl("our_mission");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Our mission", "Нашата мисија"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// patronage
		subNavItem = Utils.createStubDbModel(new SubNavItem(), 1003);
		page = new CmsPage();
		page.setUrl("patronage");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Patronage", "Патронат"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// achievements
		subNavItem = Utils.createStubDbModel(new SubNavItem(), 1004);
		page = new CmsPage();
		page.setUrl("achievements");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Achievements", "Достигнувања"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// testimonials
		subNavItem = Utils.createStubDbModel(new SubNavItem(), 1005);
		page = new CmsPage();
		page.setUrl("testimonials");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Testimonials", "Што рекоа за нас"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// partners
		subNavItem = Utils.createStubDbModel(new SubNavItem(), 1006);
		page = new CmsPage();
		page.setUrl("partners");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Partners", "Партнери"));
		subNavItem.setPage(page);
		information.add(subNavItem);

		// result
		return information;
	}

	private List<SubNavItem> createSubNavItemsStaff() {
		List<SubNavItem> staff = new ArrayList<>();

		// principal
		SubNavItem subNavItem = Utils.createStubDbModel(new SubNavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("principal");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Principal", "Директор"));
		subNavItem.setPage(page);
		staff.add(subNavItem);

		// administration
		subNavItem = Utils.createStubDbModel(new SubNavItem(), 1001);
		page = new CmsPage();
		page.setUrl("administration");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Administration", "Администрација"));
		subNavItem.setPage(page);
		staff.add(subNavItem);

		// support staff
		subNavItem = Utils.createStubDbModel(new SubNavItem(), 1002);
		page = new CmsPage();
		page.setUrl("support_staff");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Support staff", "Стручни соработници"));
		subNavItem.setPage(page);
		staff.add(subNavItem);

		// subject teachers
		subNavItem = Utils.createStubDbModel(new SubNavItem(), 1003);
		page = new CmsPage();
		page.setUrl("subject_teachers");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Subject teachers", "Предметна настава"));
		subNavItem.setPage(page);
		staff.add(subNavItem);

		// class teachers
		subNavItem = Utils.createStubDbModel(new SubNavItem(), 1004);
		page = new CmsPage();
		page.setUrl("class_teachers");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Class teachers", "Одделенска настава"));
		subNavItem.setPage(page);
		staff.add(subNavItem);

		// technical personnel
		subNavItem = Utils.createStubDbModel(new SubNavItem(), 1005);
		page = new CmsPage();
		page.setUrl("technical_personnel");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Technical personnel", "Технички персонал"));
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
			NavItem navItem = Utils.createStubDbModel(new NavItem(), 1000 + classNumber);
			CmsPage page = new CmsPage();
			page.setUrl(classNumber + "_class");
			page.setTitle(Utils.createLocalText(LocalTextType.Small, classNumbers[i] + " class", classNumbers[i] + " одделение"));
			navItem.setPage(page);
			curriculum.add(navItem);
		}

		// result
		return curriculum;
	}

	private List<NavItem> createNavItemsActivities() {
		List<NavItem> activities = new ArrayList<>();

		// news
		NavItem navItem = Utils.createStubDbModel(new NavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("news");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "News", "Новости"));
		navItem.setPage(page);
		activities.add(navItem);
		
		// gallery
		navItem = Utils.createStubDbModel(new NavItem(), 1002);
		page = new CmsPage();
		page.setUrl("gallery");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Gallery", "Галерија"));
		navItem.setPage(page);
		activities.add(navItem);

		// events
		navItem = Utils.createStubDbModel(new NavItem(), 1001);
		page = new CmsPage();
		page.setUrl("events");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Events", "Настани"));
		navItem.setPage(page);
		activities.add(navItem);

		// projects
		navItem = Utils.createStubDbModel(new NavItem(), 1003);
		page = new CmsPage();
		page.setUrl("projects");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Projects", "Проекти"));
		navItem.setPage(page);
		activities.add(navItem);

		// surveys
		navItem = Utils.createStubDbModel(new NavItem(), 1004);
		page = new CmsPage();
		page.setUrl("surveys");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Surveys", "Анкети"));
		navItem.setPage(page);
		activities.add(navItem);

		// result
		return activities;
	}
	
	private List<NavItem> createNavItemsChildren() {
		List<NavItem> children = new ArrayList<>();

		// songs and stories
		NavItem navItem = Utils.createStubDbModel(new NavItem(), 1000);
		CmsPage page = new CmsPage();
		page.setUrl("songs_and_stories");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Songs and Stories", "Песни и Раскази"));
		navItem.setPage(page);
		children.add(navItem);

		// quiz
		navItem = Utils.createStubDbModel(new NavItem(), 1001);
		page = new CmsPage();
		page.setUrl("quizs");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Quizs", "Квизови"));
		navItem.setPage(page);
		children.add(navItem);

		// interesting things
		navItem = Utils.createStubDbModel(new NavItem(), 1002);
		page = new CmsPage();
		page.setUrl("interesting_things");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Interesting things", "Занимливости"));
		navItem.setPage(page);
		children.add(navItem);

		// games
		navItem = Utils.createStubDbModel(new NavItem(), 1003);
		page = new CmsPage();
		page.setUrl("games");
		page.setTitle(Utils.createLocalText(LocalTextType.Small, "Games", "Игри"));
		navItem.setPage(page);
		children.add(navItem);

		// result
		return children;
	}
	
	private List<ContentModel> createJumbotron() {
		List<ContentModel> jumbotron = new ArrayList<>();
		
		// 1
		JumbotronItem jumbotronItem = Utils.createStubDbModel(new JumbotronItem(), 1000);
		Title title = createTitle("Header 1", "Наслов 1");
		Paragraph paragraph = createJumbotronParagraph();
		jumbotronItem.setTitle(title);
		jumbotronItem.setParagraph(paragraph);
		jumbotron.add(jumbotronItem);
		
		// 2
		jumbotronItem = Utils.createStubDbModel(new JumbotronItem(), 1001);
		title = createTitle("Header 2", "Наслов 2");
		title.setAlign(Align.Center);
		paragraph = createJumbotronParagraph();
		paragraph.setAlign(Align.Center);
		paragraph.getMedia().setSrc("/static/img/2.jpg");
		jumbotronItem.setTitle(title);
		jumbotronItem.setParagraph(paragraph);
		jumbotron.add(jumbotronItem);
		
		// 3
		jumbotronItem = Utils.createStubDbModel(new JumbotronItem(), 1002);
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
		title.setText(Utils.createLocalText(LocalTextType.Normal, enText, mkText));
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
		paragraph.setPage(createPageReadMore(new CmsPage()));
		return paragraph;
	}
	
	private List<ContentModel> createHighlights() {
		List<ContentModel> highlights = new ArrayList<>();

		// 1
		HighlightItem highlightItem = Utils.createStubDbModel(new HighlightItem(), 1000);
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
		highlightItem = Utils.createStubDbModel(new HighlightItem(), 1001);
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
		highlightItem = Utils.createStubDbModel(new HighlightItem(), 1002);
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
		highlightItem = Utils.createStubDbModel(new HighlightItem(), 1003);
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
	
	private List<ContentModel> createGallery() {
		List<ContentModel> gallery = new ArrayList<>();
		
		// 1
		FeedItem album = createFeedItem();
		fillFeedItemAlbum(album);
		album.getMedia().setSrc("/static/img/stub/a3.jpg");
		album.setDate(Utils.getDateFromString("20.01.2015"));
		gallery.add(album);
		
		// 2
		album = createFeedItem();
		fillFeedItemAlbum(album);
		album.getMedia().setSrc("/static/img/stub/a4.jpg");
		album.setDate(Utils.getDateFromString("20.01.2015"));
		album.getLocation().addText(Language.English, "Big location name for look and feel");
		album.getLocation().addText(Language.Macedonian, "Големо име за локација за да се осети дизајнот");
		gallery.add(album);
		
		// 3
		album = createFeedItem();
		fillFeedItemAlbum(album);
		album.getMedia().setSrc("/static/img/stub/a5.jpg");
		album.setDate(Utils.getDateFromString("10.04.2016"));
		gallery.add(album);
		
		// 4
		album = createFeedItem();
		fillFeedItemAlbum(album);
		album.getMedia().setSrc("/static/img/stub/a6.jpg");
		album.setDate(Utils.getDateFromString("15.10.2016"));
		gallery.add(album);
		
		// result
		return gallery;
	}


	private List<ContentModel> createNews() {
		List<ContentModel> news = new ArrayList<>();
		
		// 1
		FeedItem newsItem = createFeedItem();
		fillFeedItemArticle(newsItem);
		news.add(newsItem);
		
		// 2
		newsItem = createFeedItem();
		fillFeedItemArticle(newsItem);
		newsItem.getMedia().setSrc("/static/img/stub/a4.jpg");
		news.add(newsItem);
		
		// 3
		newsItem = createFeedItem();
		fillFeedItemAlbum(newsItem);
		newsItem.getMedia().setSrc("/static/img/stub/a5.jpg");
		news.add(newsItem);
		
		// 4
		newsItem = createFeedItem();
		fillFeedItemEvent(newsItem);
		newsItem.getMedia().setSrc("/static/img/stub/a6.jpg");
		news.add(newsItem);
		
		// result
		return news;
	}
	
	
	private FeedItem createFeedItem() {
		FeedItem feedItem = Utils.createStubDbModel(new FeedItem(), 1000);
		
		// title
		feedItem.setTitle(new LocalText(LocalTextType.Normal));
		feedItem.getTitle().addText(Language.English, "This is the name of the Feed. Can be a big one.");
		feedItem.getTitle().addText(Language.Macedonian, "Оваа е името на Новоста. Може да биде големо.");
		
		// info
		feedItem.setInfoText(new LocalText(LocalTextType.Large));
		feedItem.getInfoText().addText(Language.English,
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed"
						+ " do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut"
						+ " enim ad minim veniam, quis nostrud eiusmod tempor incididunt ut"
						+ " labore et dolore magna aliqua exercitation ullamco laboris nisi ut"
						+ " aliquip ex ea commodo consequat.");
		feedItem.getInfoText().addText(Language.Macedonian,
				"Содржина на македонски јазик. Оваа е обичен текст за да поплни место"
						+ "	и да се добие изглед. Тој ќе се замени потоа со вистински содржински"
						+ "	текст. Текст голем, мал или среден. Александар Македонски е македонски крал од династијата Аргеади, "
						+ " син на Филип II Македонски и Олимпија, ќерка на молоскиот владетел Неоптолем.");
		
		// media
		feedItem.setMedia(new Media());
		feedItem.getMedia().setType(MediaType.Image);
		feedItem.getMedia().setSrc("/static/img/stub/a2.jpg");
		
		// category
		Category category = new Category();
		category.setColor(ModernColor.Amethyst);
		category.setName(Utils.createLocalTextSmall("Category", "Категорија"));
		Categories categories = new Categories();
		categories.addModel(category);
		feedItem.setCategories(categories);
		
		// hash tags
		HashTag hashTag = new HashTag();
		hashTag.setName(Utils.createLocalTextSmall("Hash Tag", "Ознака"));
		HashTags hashTags = new HashTags();
		hashTags.addModel(hashTag);
		feedItem.setHashTags(hashTags);
		
		// result
		return feedItem;
	}
	
	private void fillFeedItemArticle(FeedItem feedItem) {
		FeedPage page = createPageReadMore(new FeedPage());
		page.setFeedType(FeedType.Aricle);
		feedItem.setPage(page);
		feedItem.getTitle().addText(Language.English, "Article");
		feedItem.getTitle().addText(Language.Macedonian, "Статија");
		feedItem.setCreatedDate(Utils.getDateFromString("03.05.2016"));
	}
	
	private void fillFeedItemAlbum(FeedItem feedItem) {
		FeedPage page = createPageReadMore(new FeedPage());
		page.setFeedType(FeedType.Album);
		feedItem.setPage(page);
		feedItem.getTitle().addText(Language.English, "Album");
		feedItem.getTitle().addText(Language.Macedonian, "Албум");
		feedItem.setDate(Utils.getDateFromString("01.03.2016"));
		feedItem.setLocation(Utils.createLocalTextSmall("Location one", "Локација еден"));
	}
	
	private void fillFeedItemEvent(FeedItem feedItem) {
		FeedPage page = createPageReadMore(new FeedPage());
		page.setFeedType(FeedType.Event);
		feedItem.setPage(page);
		feedItem.getTitle().addText(Language.English, "Event");
		feedItem.getTitle().addText(Language.Macedonian, "Настан");
		feedItem.setDateStart(Utils.getDateTimeFromString("03.04.2016 09:30"));
		feedItem.setDateEnd(Utils.getDateTimeFromString("03.04.2016 10:30"));
		feedItem.setLocation(Utils.createLocalTextSmall("Location Temp", "Локација Некаде"));
	}
	
	private List<ContentModel> createParagraphAboutUs() {
		List<ContentModel> paragraphContainer = new ArrayList<>();
		
		// 1
		ParagraphItem paragraphItem = Utils.createStubDbModel(new ParagraphItem(), 1000);
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
		ParagraphItem paragraphItem = Utils.createStubDbModel(new ParagraphItem(), 1000);
		Paragraph paragraph = createParagraph();
		paragraph.getMedia().setSrc("/static/img/stub/a2.jpg");
		paragraph.setLayout(ParagraphLayout.TextRightMediaLeft);
		paragraphItem.setParagraph(paragraph);
		paragraphContainer.add(paragraphItem);
		
		// 2
		paragraphItem = Utils.createStubDbModel(new ParagraphItem(), 1001);
		paragraph = createParagraphOnlyText();
		paragraphItem.setParagraph(paragraph);
		paragraphContainer.add(paragraphItem);
		
		// result
		return paragraphContainer;
	}
	
	private List<ContentModel> createContactInfo() {
		List<ContentModel> contactInfoList = new ArrayList<>();

		// footer
		ContactInfoItem contactInfo = Utils.createStubDbModel(new ContactInfoItem(), 1000);
		contactInfo.setLongitude(41.636513);
		contactInfo.setLatitude(22.467497);
		contactInfo.setAddress1(new LocalText(LocalTextType.Normal));
		contactInfo.getAddress1().addText(Language.English, "Coast 8th September, nr. 149");
		contactInfo.getAddress1().addText(Language.Macedonian, "Кеј 8-ми Септември, бр. 149");
		contactInfo.setAddress2(new LocalText(LocalTextType.Normal));
		contactInfo.getAddress2().addText(Language.English, "2420, Radovish, Macedonia");
		contactInfo.getAddress2().addText(Language.Macedonian, "2420, Радовиш, Македонија");
		contactInfo.setPhone1("+1 800 254 5478");
		contactInfo.setPhone2("+1 800 587 47895");
		contactInfo.setEmail("info@email.com");
		contactInfoList.add(contactInfo);

		// result
		return contactInfoList;
	}
	
	private List<ContentModel> createFooter() {
		List<ContentModel> footer = new ArrayList<>();

		// facebook
		FooterItem footerItem = Utils.createStubDbModel(new FooterItem(), 1000);
		ExternalPage page = new ExternalPage();
		page.setIcon(Icon.Facebook);
		page.setUrl("https://www.facebook.com/");
		footerItem.setPage(page);
		footer.add(footerItem);
		
		// twitter
		footerItem = Utils.createStubDbModel(new FooterItem(), 1000);
		page = new ExternalPage();
		page.setIcon(Icon.Twitter);
		page.setUrl("https://www.twitter.com/");
		footerItem.setPage(page);
		footer.add(footerItem);
		
		// youtube
		footerItem = Utils.createStubDbModel(new FooterItem(), 1000);
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


	private <T extends CmsPage> T createPageReadMore(T page) {
		page.setTitle(Utils.createLocalText(LocalTextType.Normal, "Read More", "Прочитај Повеќе"));
		page.setUrl("/");
		return page;
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
		paragraph.setPage(createPageReadMore(new CmsPage()));
		return paragraph;
	}
	
	
	@Override
	public List<DesignComponent> getDesignComponents(long pageId) {
		return list;
	}

}
