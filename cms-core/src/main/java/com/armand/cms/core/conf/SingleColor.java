package com.armand.cms.core.conf;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SingleColor {
  White("#fff"),
  LightGrayBlue("#eee"),
  VeryLightGray("#f1f1f1");

  private String hex;

}
