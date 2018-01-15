package com.armand.cms.core.comment.model;

import com.armand.cms.core.persist.model.DbModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment extends DbModel {

  private long parentId;
  private String name;
  private String email;
  private String text;

}
