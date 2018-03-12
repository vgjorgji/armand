package com.armand.cms.core.conf;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Font {
  Default("Arial", "css/font-default.css"),
  PtSansNarrow("PT Sans Narrow", "css/font-ptsansnarrow.css");

  private String alias;
  private String cssUrl;

  public String getId() {
    return name();
  }
}
