package com.vcms.website.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum WebsiteStatus {
	Offline("fa light-danger"), 
	Construction("fa light-warning"), 
	Online("fa light-success");
	
	private String cssClass;
	
	private WebsiteStatus(String cssClass) {
		this.cssClass = cssClass;
	}
	
	public String getId() {
		return name();
	}

	public String getCssClass() {
		return cssClass;
	}
	
}
