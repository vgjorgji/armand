package com.armand.cms.core.website.model;

import com.armand.cms.core.persist.model.HistoryModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company extends HistoryModel {

  private long contactUserId;
  private String name;
  private String address1;
  private String address2;
  private String phone1;
  private String phone2;
  private String email;

}
