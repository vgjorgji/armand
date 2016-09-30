package com.vcms.design.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

import com.vcms.conf.cms.Icon;
import com.vcms.conf.cms.SingleColor;
import com.vcms.user.model.UserGroup;

public class CmsPage extends Page {
	
	private Layout layout = new Layout();
	private Map<LayoutPosition, List<DesignComponent>> designComponents = new HashMap<>();
	private List<UserGroup> allowedGroups;
	
	public Layout getLayout() {
		return layout;
	}
	
	public List<UserGroup> getAllowedGroups() {
		return allowedGroups;
	}
	
	public void setAllowedGroups(List<UserGroup> allowedGroups) {
		this.allowedGroups = allowedGroups;
	}

	public Map<LayoutPosition, List<DesignComponent>> getDesignComponents() {
		return designComponents;
	}
	
	public void addDesignComponent(DesignComponent component) {
		if (!designComponents.containsKey(component.getLayoutPosition())) {
			designComponents.put(component.getLayoutPosition(), new ArrayList<DesignComponent>());
		}
		designComponents.get(component.getLayoutPosition()).add(component);
	}
	
	public void clearDesignComponents() {
		designComponents.clear();
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
		if (CollectionUtils.isNotEmpty(centerComponents)) {
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
	
	@Override
	public Link createLink() {
		Link link = new Link();
		link.setUrl("/page/" + getUrl());
		link.setText(getTitle());
		link.setIcon(Icon.Link);
		link.setExternal(false);
		return link;
	}

}
