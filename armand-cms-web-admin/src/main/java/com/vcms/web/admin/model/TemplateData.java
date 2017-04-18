package com.vcms.web.admin.model;

import java.util.HashMap;
import java.util.Map;

public class TemplateData {

	private Map<String, Object> map = new HashMap<>();
	
	public void addObject(String name, Object object) {
		map.put(name, object);
	}
	
	public Map<String, Object> getData() {
		return map;
	}
	
}
