package com.armand.cms.core.content.model;

import com.armand.cms.core.persist.model.HistoryModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ContentModel extends HistoryModel {

  private long designComponentId;
  private int sortOrder;

}
