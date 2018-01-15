package com.armand.cms.core.user.model;

import com.armand.cms.core.persist.model.HistoryModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebsiteGroup extends HistoryModel {

  private long websiteId;
  private String name;
  private boolean master;

}
