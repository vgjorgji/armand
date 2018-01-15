package com.armand.cms.core.content.model;

import com.armand.cms.core.localization.model.LocalText;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactInfoItem extends ContentModel {

  private double longitude;
  private double latitude;
  private LocalText address1;
  private LocalText address2;
  private String phone1;
  private String phone2;
  private String email;

}
