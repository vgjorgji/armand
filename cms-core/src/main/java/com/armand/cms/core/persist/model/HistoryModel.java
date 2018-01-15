package com.armand.cms.core.persist.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Setter;

@Setter
public abstract class HistoryModel extends DbModel {

  // history
  private String createdBy;
  private Date createdDate;
  private String changedBy;
  private Date changedDate;
  private int version;

  @JsonIgnore
  public String getCreatedBy() {
    return createdBy;
  }

  @JsonIgnore
  public Date getCreatedDate() {
    return createdDate;
  }

  @JsonIgnore
  public String getChangedBy() {
    return changedBy;
  }

  @JsonIgnore
  public Date getChangedDate() {
    return changedDate;
  }

  @JsonIgnore
  public int getVersion() {
    return version;
  }

}
