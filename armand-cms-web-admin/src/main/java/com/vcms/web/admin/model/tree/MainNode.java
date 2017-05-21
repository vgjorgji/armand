package com.vcms.web.admin.model.tree;

import java.util.ArrayList;
import java.util.List;

import com.vcms.conf.cms.Icon;

public class MainNode {
	
	private long id;
	private String title;
	private Icon icon;
	private List<Node> nodes = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<Node> getNodes() {
		return nodes;
	}
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
}
