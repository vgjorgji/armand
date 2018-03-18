package com.armand.cms.core.design.model;

import com.armand.cms.core.conf.FeedType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedPage extends Page {

  private long feedItemId;
  private FeedType feedType;

  @Override
  public Link createLink() {
    Link link = new Link();
    link.setUrl("/" + feedType.name().toLowerCase() + "/" + getUrl());
    link.setText(feedType.getLinkText());
    link.setIcon(feedType.getIcon());
    link.setExternal(false);
    return link;
  }

}
