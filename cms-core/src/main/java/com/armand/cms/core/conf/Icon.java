package com.armand.cms.core.conf;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = Shape.OBJECT)
public enum Icon {
  // link
  Link("fa fa-book"),

  // feed
  Article("fa fa-newspaper-o"),
  Album("fa fa-camera"),
  Event("fa fa-calendar-o"),
  Survey("fa fa-bar-chart"),
  Quiz("fa fa-question-circle"),
  Research("fa fa-graduation-cap"),
  PublicProcurement("fa fa-edge"),
  Project("fa fa-product-hunt"),
  Partner("fa fa-gears"),

  // highlights
  Education("fa fa-graduation-cap"),
  Heart("fa fa-heart"),
  Star("fa fa-star"),
  Like("fa fa-thumbs-o-up"),

  // user
  UserSecret("fa fa-user-secret"),

  // social
  Facebook("fa fa-facebook-official"),
  Twitter("fa fa-twitter"),
  Youtube("fa fa-youtube");

  private String cssClass;

  public String getId() {
    return name();
  }
}
