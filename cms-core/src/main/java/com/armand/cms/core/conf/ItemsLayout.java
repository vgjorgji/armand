package com.armand.cms.core.conf;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemsLayout {
  OneColumn("col-md-12"),
  TwoColumns("col-md-6"),
  ThreeColumns("col-md-4"),
  FourColumns("col-md-3"),
  SixColumns("col-md-2");

  private String cssClass;

}
