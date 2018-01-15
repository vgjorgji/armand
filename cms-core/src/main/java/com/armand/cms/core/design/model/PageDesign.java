package com.armand.cms.core.design.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.armand.cms.core.conf.SingleColor;
import com.armand.cms.core.persist.model.HistoryModel;
import lombok.Getter;

@Getter
public class PageDesign extends HistoryModel {

  private long pageId;
  private Layout layout = new Layout();
  private Map<LayoutPosition, List<DesignComponent>> designComponents = new HashMap<>();

  public void setPageId(long pageId) {
    this.pageId = pageId;
  }

  public void addDesignComponent(DesignComponent component) {
    if (!designComponents.containsKey(component.getLayoutPosition())) {
      designComponents.put(component.getLayoutPosition(), new ArrayList<DesignComponent>());
    }
    designComponents.get(component.getLayoutPosition()).add(component);
  }

  public List<DesignComponent> getHeaderComponents() {
    return getLayoutPositionComponents(LayoutPosition.Header);
  }

  public List<DesignComponent> getTopComponents() {
    return getLayoutPositionComponents(LayoutPosition.Top);
  }

  public List<DesignComponent> getLeftComponents() {
    return getLayoutPositionComponents(LayoutPosition.Left);
  }

  public List<DesignComponent> getCenterComponents() {
    return getLayoutPositionComponents(LayoutPosition.Center);
  }

  public SingleColor getCenterComponentsColor() {
    List<DesignComponent> centerComponents = getCenterComponents();
    if (!CollectionUtils.isEmpty(centerComponents)) {
      return centerComponents.get(0).getBackgroundColor();
    }
    return SingleColor.White;
  }

  public List<DesignComponent> getRightComponents() {
    return getLayoutPositionComponents(LayoutPosition.Right);
  }

  public List<DesignComponent> getBottomComponents() {
    return getLayoutPositionComponents(LayoutPosition.Bottom);
  }

  public List<DesignComponent> getFooterComponents() {
    return getLayoutPositionComponents(LayoutPosition.Footer);
  }

  private List<DesignComponent> getLayoutPositionComponents(LayoutPosition layoutPosition) {
    if (designComponents.containsKey(layoutPosition)) {
      return designComponents.get(layoutPosition);
    }
    return Collections.emptyList();
  }

}
