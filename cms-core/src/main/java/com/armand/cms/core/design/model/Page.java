package com.armand.cms.core.design.model;

import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.persist.model.HistoryModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Page extends HistoryModel {

  private long websiteViewId;
  private LocalText title;
  private String url;

  public abstract Link createLink();

}
