package com.armand.cms.core.design.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.armand.cms.core.conf.Component;
import com.armand.cms.core.conf.ComponentStyle;
import com.armand.cms.core.conf.ItemsLayout;
import com.armand.cms.core.conf.SingleColor;
import com.armand.cms.core.content.model.ContentModel;
import com.armand.cms.core.persist.model.HistoryModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesignComponent extends HistoryModel {

  private long pageDesignId;
  private int sortOrder;
  private Component component;
  private ComponentStyle componentStyle;
  private LayoutPosition layoutPosition;
  private SingleColor backgroundColor = SingleColor.White;
  private ItemsLayout itemsLayout = ItemsLayout.OneColumn;
  private List<ContentModel> contentModels = new ArrayList<>();

  public String getFragment() {
    return StringUtils.uncapitalize(component.name()) + "-" + StringUtils.uncapitalize(componentStyle.name());
  }

  public String getFragmentMethod() {
    return component + "-" + componentStyle;
  }

}
