package com.armand.cms.core.design.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Layout {

  private boolean top = false;
  private boolean left = false;
  private boolean right = false;
  private boolean bottom = false;

  public String getCenterColumnCss() {
    if (!left && !right) {
      return "col-md-12";
    } else if (left && right) {
      return "col-md-4";
    } else {
      return "col-md-8";
    }
  }

}
