package com.vcms.web.admin.model;

public class Message {

	private String text;
	private boolean ignorePrefix = false;
	private boolean error = false;
	private String field;
	
	public Message() {
	}
	
	public Message(String text, boolean error, String field) {
		this(text, true, error, field);
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

	public Message text(String text) {
		this.text = text;
		return this;
	}

	public boolean isIgnorePrefix() {
		return ignorePrefix;
	}
	
	public Message ignorePrefix(boolean ignorePrefix) {
		this.ignorePrefix = ignorePrefix;
		return this;
	}
	public boolean isError() {
		return error;
	}
	
	public Message error(boolean error) {
		this.error = error;
		return this;
	}
	
	public String getField() {
		return field;
	}
	
	public Message field(String field) {
		this.field = field;
		return this;
	}
	
}
