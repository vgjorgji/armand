package com.vcms.web.admin.model.tree;

import java.util.ArrayList;
import java.util.List;

import com.vcms.conf.cms.Icon;

public class Node {
	
	private Long id;
	private String title;
	private Icon icon;
	private List<SubNode> subNodes = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public List<SubNode> getSubNodes() {
		return subNodes;
	}

	public void addSubNode(SubNode subNode) {
		subNodes.add(subNode);
	}

}
