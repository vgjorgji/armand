package com.armand.cms.core.hashtag.model;

import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.persist.model.HistoryModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTag extends HistoryModel {

  private long parentId;
  private LocalText name;

}
