package com.armand.cms.core.persist.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingSearch {

  public static final int[] SIZES = new int[]{10, 25, 50, 100};

  private int page = 1;
  private int size = SIZES[0];
  private String query;

}
