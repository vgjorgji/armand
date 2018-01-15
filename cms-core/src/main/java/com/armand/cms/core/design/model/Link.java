package com.armand.cms.core.design.model;

import com.armand.cms.core.conf.Icon;
import com.armand.cms.core.localization.model.LocalText;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link {

  private String url;
  private LocalText text;
  private Icon icon;
  private boolean external;

  Link() {
    // only Page can create Link
  }

}
