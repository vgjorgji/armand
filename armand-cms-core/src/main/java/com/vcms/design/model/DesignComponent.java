package com.vcms.design.model;

import com.vcms.conf.cms.Component;
import com.vcms.conf.cms.ComponentStyle;
import com.vcms.conf.cms.ItemsLayout;
import com.vcms.conf.cms.SingleColor;
import com.vcms.persist.model.HistoryModel;

public class DesignComponent extends HistoryModel {
	
	private long pageId;
	private int sortOrder;
	private Component component;
	private ComponentStyle componentStyle;
	private LayoutPosition layoutPosition;
	private SingleColor backgroundColor = SingleColor.White;
	private ItemsLayout itemsLayout = ItemsLayout.OneColumn;
	
	public long getPageId() {
		return pageId;
	}

	public void setPageId(long pageId) {
		this.pageId = pageId;
	}
	
	public ComponentStyle getComponentStyle() {
		return componentStyle;
	}

	public void setComponentStyle(ComponentStyle componentStyle) {
		this.componentStyle = componentStyle;
	}

	public Component getComponent() {
		return component;
	}
	
	public void setComponent(Component component) {
		this.component = component;
	}
	
	public LayoutPosition getLayoutPosition() {
		return layoutPosition;
	}
	
	public void setLayoutPosition(LayoutPosition layoutPosition) {
		this.layoutPosition = layoutPosition;
	}
	
	public SingleColor getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(SingleColor backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	public ItemsLayout getItemsLayout() {
		return itemsLayout;
	}

	public void setItemsLayout(ItemsLayout itemsLayout) {
		this.itemsLayout = itemsLayout;
	}

	public String getCssClass() {
		return component + "-" + componentStyle;
	}

}
