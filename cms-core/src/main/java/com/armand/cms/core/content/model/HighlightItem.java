package com.armand.cms.core.content.model;

import com.armand.cms.core.conf.Icon;
import com.armand.cms.core.localization.model.LocalText;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HighlightItem extends ContentModel {

  private Icon icon;
  private LocalText title;
  private LocalText text;

}
