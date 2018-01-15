package com.armand.cms.core.comment.model;

import java.util.ArrayList;
import java.util.List;

import com.armand.cms.core.persist.model.DbModel;
import lombok.Getter;

@Getter
public class Comments extends DbModel {

  private List<Comment> models = new ArrayList<>();

  public void addModel(Comment model) {
    models.add(model);
  }

  public int getSize() {
    return models.size();
  }

}
