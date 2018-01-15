package com.armand.cms.web.admin.model.tree;

import java.util.ArrayList;
import java.util.List;

import com.armand.cms.core.conf.Icon;
import lombok.Getter;

@Getter
public class MainNode {

  private long id;
  private String title;
  private Icon icon;
  private List<Node> nodes = new ArrayList<>();

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setIcon(Icon icon) {
    this.icon = icon;
  }

  public void addNode(Node node) {
    nodes.add(node);
  }

}
