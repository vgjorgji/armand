package com.vcms.date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFormat(shape = Shape.OBJECT)
public enum CountdownType {
	Expired(0, "fa fa-clock-o text-danger"),
	Warning(10, "fa fa-clock-o text-warning"),
	TakeNote(30, "fa fa-clock-o text-primary"),
	Normal(750, "fa fa-clock-o text-success"),
	Infinity(Long.MAX_VALUE, "fa fa-clock-o");

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
