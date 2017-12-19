package com.armand.cms.core.date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFormat(shape = Shape.OBJECT)
public enum CountdownType {
	Expired(0, "text-danger text-bold"),
	Warning(10, "text-warning text-bold"),
	TakeNote(30, "text-primary"),
	Normal(750, ""),
	Infinity(Long.MAX_VALUE, "");

	private long threshold;
	private String cssClass;
	
	private CountdownType(long threshold, String cssClass) {
		this.threshold = threshold;
		this.cssClass = cssClass;
	}

	public String getId() {
		return name();
	}

	@JsonIgnore
	public long getThreshold() {
		return threshold;
	}

	public String getCssClass() {
		return cssClass;
	}
	
}
