package com.vcms.web.admin.model;

public class Template {
	
	private String id;        // ID of HTML element containing the template
	private String replaceId; // ID of HTML element to render the outcome template in
	private Object data;
	
	public Template() {
	}
	
	public Template(String id, String replaceId, Object data) {
		this.id = id;
		this.replaceId = replaceId;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReplaceId() {
		return replaceId;
	}

	public void setReplaceId(String replaceId) {
		this.replaceId = replaceId;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
