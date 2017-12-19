package com.armand.cms.core.design.model;

import java.util.ArrayList;
import java.util.List;

import com.armand.cms.core.conf.cms.ItemsLayout;
import com.armand.cms.core.content.model.ContentModel;
import com.armand.cms.core.persist.model.HistoryModel;
import com.armand.cms.core.conf.cms.Component;
import com.armand.cms.core.conf.cms.ComponentStyle;
import com.armand.cms.core.conf.cms.SingleColor;

public class DesignComponent extends HistoryModel {
	
	private long pageDesignId;
	private int sortOrder;
	private Component component;
	private ComponentStyle componentStyle;
	private LayoutPosition layoutPosition;
	private SingleColor backgroundColor = SingleColor.White;
	private ItemsLayout itemsLayout = ItemsLayout.OneColumn;
	private List<ContentModel> contentModels = new ArrayList<>();

	public long getPageDesignId() {
		return pageDesignId;
	}

	public void setPageDesignId(long pageDesignId) {
		this.pageDesignId = pageDesignId;
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
	
	public List<ContentModel> getContentModels() {
		return contentModels;
	}

	public void setContentModels(List<ContentModel> contentModels) {
		this.contentModels = contentModels;
	}

	public String getCssClass() {
		return component + "-" + componentStyle;
	}

}
