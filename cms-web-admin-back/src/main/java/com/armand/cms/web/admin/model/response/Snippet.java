package com.armand.cms.web.admin.model.response;

public class Snippet {

  private String text;
  private boolean html = false;

  public Snippet() {
  }

  public Snippet(String text, boolean html) {
    this.text = text;
    this.html = html;
  }

  public String getText() {
    return text;
  }

  public Snippet text(String text) {
    this.text = text;
    return this;
  }

  public boolean isHtml() {
    return html;
  }

  public Snippet html(boolean html) {
    this.html = html;
    return this;
  }

}
