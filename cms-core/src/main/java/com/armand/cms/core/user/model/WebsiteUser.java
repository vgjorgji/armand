package com.armand.cms.core.user.model;

import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.media.model.Media;
import com.armand.cms.core.persist.model.HistoryModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebsiteUser extends HistoryModel {

  private long userId;
  private long websiteId;
  private long websiteGroupId;

  private PowerGroup powerGroup;
  private Language language;

  private LocalText jobPosition;
  private LocalText biography;
  private Media media;

}
