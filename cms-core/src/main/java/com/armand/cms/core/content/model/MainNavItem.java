package com.armand.cms.core.content.model;

import java.util.ArrayList;
import java.util.List;

import com.armand.cms.core.design.model.Link;
import com.armand.cms.core.design.model.Page;
import lombok.Getter;

@Getter
public class MainNavItem extends ContentModel {

  private Page page;
  private Link link;
  private List<NavItem> navItems;

  public void setPage(Page page) {
    this.page = page;
    this.link = page.createLink();
  }

  public List<NavItem> getNavItems() {
    if (navItems == null) {
      navItems = new ArrayList<>();
    }
    return navItems;
  }

  public void setNavItems(List<NavItem> navItems) {
    this.navItems = navItems;
  }

}
