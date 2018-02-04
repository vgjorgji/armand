package com.armand.cms.web.admin.model.response;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class FragmentData {

  private Map<String, Object> map = new HashMap<>();

  public FragmentData add(String name, Object object) {
    map.put(name, object);
    return this;
  }

}
