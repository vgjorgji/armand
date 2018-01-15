package com.armand.cms.core.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.armand.cms.core.persist.model.DbModel;

public final class Utils {

  private Utils() {
    // utility class
  }

  @SuppressWarnings("unchecked")
  public static <T> Set<T> asSet(T... objects) {
    Set<T> set = new HashSet<>();
    if (objects != null) {
      set.addAll(Arrays.asList(objects));
    }
    return set;
  }

  public static <T extends DbModel> Map<Long, T> mapList(List<T> list) {
    Map<Long, T> map = new HashMap<>();
    for (T model : list) {
      map.put(model.getId(), model);
    }
    return map;
  }

}
