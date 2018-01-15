package com.armand.cms.web.admin.model.tree;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Tree {

  private List<MainNode> mainNodes = new ArrayList<>();

  public void addMainNode(MainNode mainNode) {
    mainNodes.add(mainNode);
  }

}
