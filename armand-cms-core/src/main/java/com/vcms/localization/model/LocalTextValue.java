package com.vcms.localization.model;

import com.vcms.persist.model.DbModel;

public class LocalTextValue extends DbModel {

	private long localTextId;
	private Language language;
	private String value;
	
	public long getLocalTextId() {
		return localTextId;
	}

	public void setLocalTextId(long localTextId) {
		this.localTextId = localTextId;
	}

	public Language getLanguage() {
		return language;
	}
	
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
}
