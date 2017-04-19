package com.vcms.web.admin.model;

import java.util.Map;

public class Template {
	
	private String id;        // ID of HTML element containing the template
	private String replaceId; // ID of HTML element to render the outcome template in
	private TemplateData templateData = new TemplateData();
	
	public Template() {
	}
	
	public Template(String id, String replaceId) {
		this.id = id;
		this.replaceId = replaceId;
	}

	public String getId() {
		return id;
	}

	public String getReplaceId() {
		return replaceId;
	}

	public Map<String, Object> getData() {
		return templateData.getMap();
	}

	public TemplateData data() {
		return templateData;
	}

}
