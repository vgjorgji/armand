package com.armand.cms.core.conf;

import java.util.HashSet;
import java.util.Set;

import com.armand.cms.core.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonFormat(shape = Shape.OBJECT)
public enum CmsPackage {
  Basic("fa fa-cube",
      Utils.asSet(Component.Header, Component.Navigation, Component.Footer,
          Component.Titles, Component.Paragraphs, Component.Medias, Component.Links,
          Component.Jumbotron, Component.Highlights, Component.ContactForms, Component.ContactInfos),
      new HashSet<FeedType>(),
      Utils.asSet(CmsOption.Language)),

  Dynamic("fa fa-cubes",
      Utils.asSet(Component.Header, Component.Navigation, Component.Footer,
          Component.Titles, Component.Paragraphs, Component.Medias, Component.Links,
          Component.Jumbotron, Component.Highlights, Component.ContactForms, Component.ContactInfos,
          Component.Feed),
      Utils.asSet(FeedType.Article, FeedType.Album, FeedType.Survey),
      Utils.asSet(CmsOption.Search, CmsOption.Language)),

  Business("fa fa-star",
      Utils.asSet(Component.values()),
      Utils.asSet(FeedType.values()),
      Utils.asSet(CmsOption.values()));

  private String cssClass;
  private Set<Component> components;
  private Set<FeedType> feedTypes;
  private Set<CmsOption> options;


  public String getId() {
    return name();
  }

  public String getCssClass() {
    return cssClass;
  }

  @JsonIgnore
  public Set<Component> getComponents() {
    return components;
  }

  public boolean isComponentSupported(Component component) {
    return components.contains(component);
  }

  @JsonIgnore
  public Set<FeedType> getFeedTypes() {
    return feedTypes;
  }

  public boolean isFeedTypeSupported(FeedType feedType) {
    return feedTypes.contains(feedType);
  }

  @JsonIgnore
  public Set<CmsOption> getOptions() {
    return options;
  }

  public boolean isOptionSupported(CmsOption option) {
    return options.contains(option);
  }
}
