package com.armand.cms.core.media.model;

public enum MediaType {
  Image,
  Video,
  Document;

  public String getId() {
    return name();
  }
}
