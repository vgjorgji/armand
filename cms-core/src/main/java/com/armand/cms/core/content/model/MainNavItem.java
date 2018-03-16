package com.armand.cms.core.content.model;

import java.util.ArrayList;
import java.util.List;

import com.armand.cms.core.design.model.Link;
import com.armand.cms.core.design.model.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainNavItem extends ContentModel {

  private long websiteViewId;
  private long pageId;

  private Page page;
  @Setter(value = AccessLevel.NONE)
  private Link link;
  private List<NavItem> navItems;

  public List<NavItem> getNavItems() {
    if (navItems == null) {
      navItems = new ArrayList<>();
    }
    return navItems;
  }

  public void setPage(Page page) {
    this.pageId = page.getId();
    this.page = page;
    this.link = page.createLink();
  }

}
