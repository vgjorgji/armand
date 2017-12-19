package com.armand.cms.core.content.model;

public enum Align {
	Left("text-left", "pull-left"),
	Center("text-center", ""),
	Right("text-right", "pull-right");
	
	private String textCssClass;
	private String floatCssClass;
	
	private Align(String textCssClass, String floatCssClass) {
		this.textCssClass = textCssClass;
		this.floatCssClass = floatCssClass;
	}
	
	public String getTextCssClass() {
		return textCssClass;
	}
	
	public String getFloatCssClass() {
		return floatCssClass;
	}
}
