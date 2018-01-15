package com.armand.cms.core.website.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Getter;

@Getter
@JsonFormat(shape = Shape.OBJECT)
public enum WebsiteStatus {
  Offline("fa light-danger"),
  Construction("fa light-warning"),
  Online("fa light-success");

  private String cssClass;

  WebsiteStatus(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getId() {
    return name();
  }

}
