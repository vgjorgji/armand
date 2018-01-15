package com.armand.cms.core.localization.model;

import com.armand.cms.core.persist.model.DbModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalTextValue extends DbModel {

  private long localTextId;
  private Language language;
  private String value;

}
