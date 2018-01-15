package com.armand.cms.core.content.model;

import com.armand.cms.core.design.model.Link;
import com.armand.cms.core.design.model.Page;
import lombok.Getter;

@Getter
public class SubNavItem extends ContentModel {

  private long navItemId;
  private Page page;
  private Link link;

  public void setNavItemId(long navItemId) {
    this.navItemId = navItemId;
  }

  public void setPage(Page page) {
    this.page = page;
    this.link = page.createLink();
  }

}
