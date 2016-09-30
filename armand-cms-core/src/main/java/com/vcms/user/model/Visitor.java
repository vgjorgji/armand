package com.vcms.user.model;

import java.util.Date;
import java.util.Set;

import com.vcms.localization.model.Language;
import com.vcms.persist.model.DbModel;
import com.vcms.utils.Utils;

public class Visitor extends DbModel {
	
	public static final Set<Role> DEFAULT_ROLES = Utils.asSet(Role.Visitor);
	public static final Language DEFAULT_LANGUAGE = Language.English;
	
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
