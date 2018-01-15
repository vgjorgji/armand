package com.armand.cms.core.persist.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging<T> {

  private int page;
  private int pageCount;
  private int size;
  private long modelsStart;
  private long modelsEnd;
  private long modelsCount;
  private String query;
  private Fetch<T> fetch;

  public boolean isPagePreviousEnabled() {
    return page > 1;
  }

  public boolean isPageNextEnabled() {
    return page < pageCount;
  }

  public int[] getSizes() {
    return PagingSearch.SIZES;
  }

}
