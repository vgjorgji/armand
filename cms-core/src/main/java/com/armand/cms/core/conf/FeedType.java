package com.armand.cms.core.conf;

import java.util.Arrays;
import java.util.List;

import com.armand.cms.core.design.model.FeedFilter;
import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.utils.TextUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FeedType {
  Article(Icon.Article,
      TextUtils.createLocalTextSmall("Read More", "Прочитај Повеќе"),
      Arrays.asList(FeedFilter.Latest, FeedFilter.Popular, FeedFilter.Views)),

  Album(Icon.Album,
      TextUtils.createLocalTextSmall("Open Album", "Отвори го Албумот"),
      Arrays.asList(FeedFilter.Latest, FeedFilter.Popular, FeedFilter.Views)),

  Event(Icon.Event,
      TextUtils.createLocalTextSmall("View Event", "Види го Настанот"),
      Arrays.asList(FeedFilter.Upcoming, FeedFilter.Current, FeedFilter.Past, FeedFilter.Latest,
          FeedFilter.Popular, FeedFilter.Views)),

  Survey(Icon.Survey,
      TextUtils.createLocalTextSmall("Answer Survery", "Одговори на Анкетата"),
      Arrays.asList(FeedFilter.Active, FeedFilter.Finished, FeedFilter.Latest, FeedFilter.Popular,
          FeedFilter.Views)),

  Quiz(Icon.Quiz,
      TextUtils.createLocalTextSmall("Start Quiz", "Започни со Квизот"),
      Arrays.asList(FeedFilter.Latest, FeedFilter.Popular, FeedFilter.Views)),

  Research(Icon.Research,
      TextUtils.createLocalTextSmall("Read Research", "Прочитај го Истражувањето"),
      Arrays.asList(FeedFilter.Latest, FeedFilter.Popular, FeedFilter.Views)),

  PublicProcurement(Icon.PublicProcurement,
      TextUtils.createLocalTextSmall("Announcement for Public Procurement", "Оглас за Јавна Набавка"),
      Arrays.asList(FeedFilter.Active, FeedFilter.Finished, FeedFilter.Latest, FeedFilter.Popular,
          FeedFilter.Views)),

  Project(Icon.Project,
      TextUtils.createLocalTextSmall("Project Info", "Информации за Проектот"),
      Arrays.asList(FeedFilter.Preparing, FeedFilter.Constructing, FeedFilter.Maintenance, FeedFilter.Finished,
          FeedFilter.Latest, FeedFilter.Popular, FeedFilter.Views)),

  Partner(Icon.Partner,
      TextUtils.createLocalTextSmall("Partner Info", "Информации за Партнерот"),
      Arrays.asList(FeedFilter.Latest, FeedFilter.Popular, FeedFilter.Views, FeedFilter.VIP));


  private Icon icon;
  private LocalText linkText;
  private List<FeedFilter> filters;

}
