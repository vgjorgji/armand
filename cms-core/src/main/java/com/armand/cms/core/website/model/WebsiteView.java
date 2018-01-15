package com.armand.cms.core.website.model;

import com.armand.cms.core.conf.Font;
import com.armand.cms.core.conf.ModernColor;
import com.armand.cms.core.conf.Style;
import com.armand.cms.core.persist.model.HistoryModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebsiteView extends HistoryModel {

  private long websiteId;
  private WebsiteViewType viewType;
  private Style style;
  private ModernColor color;
  private ModernColor selectColor;
  private Font font;

}
