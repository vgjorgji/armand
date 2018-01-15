package com.armand.cms.core.design.model;

import com.armand.cms.core.conf.Icon;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalPage extends Page {

  private Icon icon;

  @Override
  public Link createLink() {
    Link link = new Link();
    link.setUrl(getUrl());
    link.setText(getTitle());
    link.setIcon(icon);
    link.setExternal(true);
    return link;
  }

}
