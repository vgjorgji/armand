package com.vcms.web.admin.model;

public class TemplateDataObject {

	private String name;
	private Object object;
	
	public TemplateDataObject(String name, Object object) {
		this.name = name;
		this.object = object;
	}

	public String getName() {
		return name;
	}
	
	public Object getObject() {
		return object;
	}
}
