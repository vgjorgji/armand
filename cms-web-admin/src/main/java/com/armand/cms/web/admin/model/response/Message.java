package com.armand.cms.web.admin.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

  private String text;
  private boolean ignorePrefix = false;
  private boolean error = false;
  private String field;

  public Message(String text, boolean error, String field) {
    this(text, true, error, field);
  }

  public Message text(String text) {
    this.text = text;
    return this;
  }

  public Message ignorePrefix(boolean ignorePrefix) {
    this.ignorePrefix = ignorePrefix;
    return this;
  }

  public Message error(boolean error) {
    this.error = error;
    return this;
  }

  public Message field(String field) {
    this.field = field;
    return this;
  }

}
