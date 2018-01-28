package com.armand.cms.core.content.model;

public enum ParagraphLayout {
  TextRightMediaLeft,
  TextLeftMediaRight,
  TextBottomMediaTop,
  TextTopMediaBottom,
  TextInFrontMediaBehind;

  public String getId() {
    return name();
  }
}
