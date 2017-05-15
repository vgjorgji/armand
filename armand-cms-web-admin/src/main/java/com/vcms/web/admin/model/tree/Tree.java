package com.vcms.web.admin.model.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	
	private List<MainNode> mainNodes = new ArrayList<>();

	public List<MainNode> getMainNodes() {
		return mainNodes;
	}

	public void addMainNode(MainNode mainNode) {
		mainNodes.add(mainNode);
	}
	
}
