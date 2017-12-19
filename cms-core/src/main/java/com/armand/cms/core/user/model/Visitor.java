package com.armand.cms.core.user.model;

import java.io.Serializable;
import java.util.Date;

import com.armand.cms.core.persist.model.DbModel;

public class Visitor extends DbModel implements Serializable {
	
	private static final long serialVersionUID = -1533341933678307075L;
	
	private long userId;
	private Date startDate;
	private String remoteAddress;
	private String remoteHost;
	private String sessionId;
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
