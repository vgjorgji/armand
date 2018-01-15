package com.armand.cms.core.media.model;

import com.armand.cms.core.persist.model.HistoryModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Media extends HistoryModel {

  private long websiteId;
  private MediaType type;
  private String src;
  private String thumbnailSrc;
  private int width;
  private int height;
  private boolean external;

}
