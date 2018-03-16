package com.armand.cms.core.content.model;

import java.util.ArrayList;
import java.util.List;

import com.armand.cms.core.design.model.Link;
import com.armand.cms.core.design.model.Page;
import com.armand.cms.core.persist.model.HistoryModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NavItem extends HistoryModel {

  private long mainNavItemId;
  private long pageId;

  private Page page;
  @Setter(value = AccessLevel.NONE)
  private Link link;
  private List<SubNavItem> subNavItems;

  public List<SubNavItem> getSubNavItems() {
    if (subNavItems == null) {
      subNavItems = new ArrayList<>();
    }
    return subNavItems;
  }

  public void setPage(Page page) {
    this.pageId = page.getId();
    this.page = page;
    this.link = page.createLink();
  }

}
