package com.vcms.content.stub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vcms.classify.model.Categories;
import com.vcms.classify.model.Category;
import com.vcms.conf.cms.Component;
import com.vcms.conf.cms.FeedType;
import com.vcms.conf.cms.ModernColor;
import com.vcms.content.model.FeedItem;
import com.vcms.content.model.FeedItemRepository;
import com.vcms.design.model.DesignComponent;
import com.vcms.design.model.FeedDesignComponent;
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
import com.vcms.website.model.FeedPage;

@Repository
public class FeedItemStubRepository implements FeedItemRepository {

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		if (!Component.Feed.equals(designComponent.getComponent()) || !(designComponent instanceof FeedDesignComponent)) {
			return Collections.emptyList();
		}
		
		// safe cast
		FeedDesignComponent feedDesignComponent = (FeedDesignComponent) designComponent;
		
		// choose from type
		if (FeedType.Album.equals(feedDesignComponent.getFeedType())) {
			return createGallery();
		} else if (feedDesignComponent.getFeedType() == null) {
			return createNews();
		}
		
		// no option
		return Collections.emptyList();
	}
	
	
	@Override
	public List<FeedItem> getModels(long designComponentId) {
		return null;
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
		FeedItem feedItem = StubUtils.createStubDbModel(new FeedItem(), 1000);
		
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
		category.setName(StubUtils.createLocalTextSmall("Category", "Категорија"));
		Categories categories = new Categories();
		categories.addModel(category);
		feedItem.setCategories(categories);
		
		// hash tags
		HashTag hashTag = new HashTag();
		hashTag.setName(StubUtils.createLocalTextSmall("Hash Tag", "Ознака"));
		HashTags hashTags = new HashTags();
		hashTags.addModel(hashTag);
		feedItem.setHashTags(hashTags);
		
		// result
		return feedItem;
	}
	
	private void fillFeedItemArticle(FeedItem feedItem) {
		FeedPage page = StubUtils.createPageReadMore(new FeedPage());
		page.setFeedType(FeedType.Aricle);
		feedItem.setPage(page);
		feedItem.getTitle().addText(Language.English, "Article");
		feedItem.getTitle().addText(Language.Macedonian, "Статија");
		feedItem.setCreatedDate(Utils.getDateFromString("03.05.2016"));
	}
	
	private void fillFeedItemAlbum(FeedItem feedItem) {
		FeedPage page = StubUtils.createPageReadMore(new FeedPage());
		page.setFeedType(FeedType.Album);
		feedItem.setPage(page);
		feedItem.getTitle().addText(Language.English, "Album");
		feedItem.getTitle().addText(Language.Macedonian, "Албум");
		feedItem.setDate(Utils.getDateFromString("01.03.2016"));
		feedItem.setLocation(StubUtils.createLocalTextSmall("Location one", "Локација еден"));
	}
	
	private void fillFeedItemEvent(FeedItem feedItem) {
		FeedPage page = StubUtils.createPageReadMore(new FeedPage());
		page.setFeedType(FeedType.Event);
		feedItem.setPage(page);
		feedItem.getTitle().addText(Language.English, "Event");
		feedItem.getTitle().addText(Language.Macedonian, "Настан");
		feedItem.setDateStart(Utils.getDateTimeFromString("03.04.2016 09:30"));
		feedItem.setDateEnd(Utils.getDateTimeFromString("03.04.2016 10:30"));
		feedItem.setLocation(StubUtils.createLocalTextSmall("Location Temp", "Локација Некаде"));
	}
	
}
