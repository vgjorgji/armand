package com.vcms.web.admin.model;

public class Message {

	private String text;
	private boolean ignorePrefix;
	private boolean error;
	private String field;
	
	public Message() {
	}
	
	public Message(String text, boolean ignorePrefix, boolean error, String field) {
		this.text = text;
		this.ignorePrefix = ignorePrefix;
		this.error = error;
		this.field = field;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isIgnorePrefix() {
		return ignorePrefix;
	}
	
	public void setIgnorePrefix(boolean ignorePrefix) {
		this.ignorePrefix = ignorePrefix;
	}
	public boolean isError() {
		return error;
	}
	
	public void setError(boolean error) {
		this.error = error;
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
	
}
