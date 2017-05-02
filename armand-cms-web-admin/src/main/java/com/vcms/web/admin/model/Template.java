package com.vcms.web.admin.model;

import java.util.Map;

public class Template {
	
	private String id;        // ID of HTML element containing the template
	private String replaceId; // ID of HTML element to render the outcome template in
	private boolean show = true;
	private TemplateData templateData = new TemplateData();
	
	public Template() {
	}
	
	public Template(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getReplaceId() {
		return replaceId;
	}
	
	public Template replaceId(String replaceId) {
		this.replaceId = replaceId;
		return this;
	}

	public boolean isShow() {
		return show;
	}

	public Template show(boolean show) {
		this.show = show;
		return this;
	}

	public Map<String, Object> getData() {
		return templateData.getMap();
	}

	public TemplateData data() {
		return templateData;
	}

}
