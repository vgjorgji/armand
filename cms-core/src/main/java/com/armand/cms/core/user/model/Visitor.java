package com.armand.cms.core.user.model;

import java.io.Serializable;
import java.util.Date;

import com.armand.cms.core.persist.model.DbModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Visitor extends DbModel implements Serializable {

  private static final long serialVersionUID = -1533341933678307075L;

  private long userId;
  private Date startDate;
  private String remoteAddress;
  private String remoteHost;
  private String sessionId;

}
