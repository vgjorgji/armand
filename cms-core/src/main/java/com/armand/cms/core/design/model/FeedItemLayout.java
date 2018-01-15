package com.armand.cms.core.design.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedItemLayout {

  private boolean link = true;
  private boolean media = true;
  private boolean titleAsLink = true;
  private boolean text = true;
  private boolean hashTags = true;
  private boolean categories = true;
  private boolean stats = true;

}
