package com.armand.cms.core.design.model;

import com.armand.cms.core.classify.model.Categories;
import com.armand.cms.core.conf.Component;
import com.armand.cms.core.conf.FeedType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedDesignComponent extends DesignComponent {

  private FeedType feedType;
  private FeedFilter feedFilter;
  private Categories categories;
  private int feedsPerPage;
  private boolean showSearch;
  private boolean showPagination;
  private FeedItemLayout feedItemLayout = new FeedItemLayout();

  public FeedDesignComponent() {
    super.setComponent(Component.Feed);
  }

  @Override
  public void setComponent(Component component) {
    super.setComponent(Component.Feed);
  }

}
