package com.vcms.web.admin.model;

import java.util.HashMap;
import java.util.Map;

public class TemplateData {

	private Map<String, Object> map = new HashMap<>();
	
	public TemplateData add(String name, Object object) {
		map.put(name, object);
		return this;
	}
	
	public Map<String, Object> getMap() {
		return map;
	}
	
}
