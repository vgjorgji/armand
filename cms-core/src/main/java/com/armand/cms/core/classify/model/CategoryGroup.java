package com.armand.cms.core.classify.model;

import com.armand.cms.core.conf.ModernColor;
import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.persist.model.HistoryModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryGroup extends HistoryModel {

  private long parentId;
  private LocalText name;
  private ModernColor color;

}
