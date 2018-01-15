package com.armand.cms.core.localization.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LocalTextType {
  Small(100),
  Normal(255),
  Large(1000),
  Rich(2000);

  private int size;

}
