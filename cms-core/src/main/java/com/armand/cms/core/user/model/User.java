package com.armand.cms.core.user.model;

import java.io.Serializable;

import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.persist.model.HistoryModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User extends HistoryModel implements Serializable {

  private static final long serialVersionUID = 3245779839673032603L;

  private String username;
  private String password;
  private boolean enabled;
  private boolean master;

  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private Language language;

  public String getFullName() {
    return lastName + " " + firstName;
  }

}
