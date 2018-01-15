package com.armand.cms.core.localization.model;

import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
@JsonFormat(shape = Shape.OBJECT)
public enum Language {
  English("flag flag-usa", new Locale("en")),
  Macedonian("flag flag-macedonia", new Locale("mk"));

  private String cssClass;
  private Locale locale;

  Language(String cssClass, Locale locale) {
    this.cssClass = cssClass;
    this.locale = locale;
  }

  public String getId() {
    return name();
  }

  @JsonIgnore
  public Locale getLocale() {
    return locale;
  }

}
