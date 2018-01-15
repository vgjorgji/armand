package com.armand.cms.core.content.model;

import com.armand.cms.core.localization.model.LocalText;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Title {

  private LocalText text;
  private Align align = Align.Left;

}
