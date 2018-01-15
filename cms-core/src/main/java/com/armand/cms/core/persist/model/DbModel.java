package com.armand.cms.core.persist.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DbModel {

  private long id = 0;

  @Override
  public String toString() {
    return getClass().getSimpleName() + "[id=" + id + "]";
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof DbModel && id == ((DbModel) obj).getId();
  }

  @Override
  public int hashCode() {
    return Long.valueOf(id).hashCode();
  }

}
