package com.armand.cms.web.admin.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Snippet {

  private String text;
  private boolean html = false;

  public Snippet text(String text) {
    this.text = text;
    return this;
  }

  public Snippet html(boolean html) {
    this.html = html;
    return this;
  }

}
