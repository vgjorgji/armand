package com.armand.cms.core.content.model;

import com.armand.cms.core.design.model.Link;
import com.armand.cms.core.design.model.Page;
import com.armand.cms.core.persist.model.HistoryModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubNavItem extends HistoryModel {

  private long navItemId;
  private long pageId;

  private Page page;
  @Setter(value = AccessLevel.NONE)
  private Link link;

  public void setPage(Page page) {
    this.pageId = page.getId();
    this.page = page;
    this.link = page.createLink();
  }

}
