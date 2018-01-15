package com.armand.cms.core.content.stub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.classify.model.Categories;
import com.armand.cms.core.classify.model.Category;
import com.armand.cms.core.conf.Component;
import com.armand.cms.core.conf.FeedType;
import com.armand.cms.core.conf.ModernColor;
import com.armand.cms.core.content.model.ContentModel;
import com.armand.cms.core.content.model.FeedItem;
import com.armand.cms.core.content.model.FeedItemRepository;
import com.armand.cms.core.date.DateUtils;
import com.armand.cms.core.design.model.DesignComponent;
import com.armand.cms.core.design.model.FeedDesignComponent;
import com.armand.cms.core.design.model.FeedPage;
import com.armand.cms.core.hashtag.model.HashTag;
import com.armand.cms.core.hashtag.model.HashTags;
import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.localization.model.LocalTextType;
import com.armand.cms.core.media.model.Media;
import com.armand.cms.core.media.model.MediaType;
import com.armand.cms.core.utils.StubUtils;
import com.armand.cms.core.utils.TextUtils;

@Repository
public class FeedItemRepositoryStub implements FeedItemRepository {

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
    album.setDate(DateUtils.getDateFromString("20.01.2015"));
    gallery.add(album);

    // 2
    album = createFeedItem();
    fillFeedItemAlbum(album);
    album.getMedia().setSrc("/static/img/stub/a4.jpg");
    album.setDate(DateUtils.getDateFromString("20.01.2015"));
    album.getLocation().addText(Language.English, "Big location name for look and feel");
    album.getLocation().addText(Language.Macedonian, "Големо име за локација за да се осети дизајнот");
    gallery.add(album);

    // 3
    album = createFeedItem();
    fillFeedItemAlbum(album);
    album.getMedia().setSrc("/static/img/stub/a5.jpg");
    album.setDate(DateUtils.getDateFromString("10.04.2016"));
    gallery.add(album);

    // 4
    album = createFeedItem();
    fillFeedItemAlbum(album);
    album.getMedia().setSrc("/static/img/stub/a6.jpg");
    album.setDate(DateUtils.getDateFromString("15.10.2016"));
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
    category.setName(TextUtils.createLocalTextSmall("Category", "Категорија"));
    Categories categories = new Categories();
    categories.addModel(category);
    feedItem.setCategories(categories);

    // hash tags
    HashTag hashTag = new HashTag();
    hashTag.setName(TextUtils.createLocalTextSmall("Hash Tag", "Ознака"));
    HashTags hashTags = new HashTags();
    hashTags.addModel(hashTag);
    feedItem.setHashTags(hashTags);

    // result
    return feedItem;
  }

  private void fillFeedItemArticle(FeedItem feedItem) {
    FeedPage page = StubUtils.createPageReadMore(new FeedPage());
    page.setFeedType(FeedType.Article);
    feedItem.setPage(page);
    feedItem.getTitle().addText(Language.English, "Article");
    feedItem.getTitle().addText(Language.Macedonian, "Статија");
    feedItem.setCreatedDate(DateUtils.getDateFromString("03.05.2016"));
  }

  private void fillFeedItemAlbum(FeedItem feedItem) {
    FeedPage page = StubUtils.createPageReadMore(new FeedPage());
    page.setFeedType(FeedType.Album);
    feedItem.setPage(page);
    feedItem.getTitle().addText(Language.English, "Album");
    feedItem.getTitle().addText(Language.Macedonian, "Албум");
    feedItem.setDate(DateUtils.getDateFromString("01.03.2016"));
    feedItem.setLocation(TextUtils.createLocalTextSmall("Location one", "Локација еден"));
  }

  private void fillFeedItemEvent(FeedItem feedItem) {
    FeedPage page = StubUtils.createPageReadMore(new FeedPage());
    page.setFeedType(FeedType.Event);
    feedItem.setPage(page);
    feedItem.getTitle().addText(Language.English, "Event");
    feedItem.getTitle().addText(Language.Macedonian, "Настан");
    feedItem.setDateStart(DateUtils.getDateTimeFromString("03.04.2016 09:30"));
    feedItem.setDateEnd(DateUtils.getDateTimeFromString("03.04.2016 10:30"));
    feedItem.setLocation(TextUtils.createLocalTextSmall("Location Temp", "Локација Некаде"));
  }

}
