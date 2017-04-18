package com.vcms.web.admin.model;

public class Snippet {

	private String text;
	private boolean html;
	
	public Snippet() {
	}

	public Snippet(String text, boolean html) {
		this.text = text;
		this.html = html;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public boolean isHtml() {
		return html;
	}
	
	public void setHtml(boolean html) {
		this.html = html;
	}
	
}
