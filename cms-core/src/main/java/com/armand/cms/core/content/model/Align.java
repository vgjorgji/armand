package com.armand.cms.core.content.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Align {
  Left("text-left", "pull-left"),
  Center("text-center", ""),
  Right("text-right", "pull-right");

  private String textCssClass;
  private String floatCssClass;

}
