package com.armand.cms.web.admin.model.response;

import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Fragment {

  private String id;                // ID of HTML element containing the fragment
  private String replaceId;         // ID of HTML element to render the outcome fragment in
  private boolean show = true;
  @Getter(value = AccessLevel.NONE)
  private FragmentData fragmentData = new FragmentData();

  Fragment(String id) {
    this.id = id;
  }

  public Fragment replaceId(String replaceId) {
    this.replaceId = replaceId;
    return this;
  }

  public Fragment show() {
    this.show = true;
    return this;
  }

  public Fragment hide() {
    this.show = false;
    return this;
  }

  public Map<String, Object> getData() {
    return fragmentData.getMap();
  }

  public FragmentData data() {
    return fragmentData;
  }

}
