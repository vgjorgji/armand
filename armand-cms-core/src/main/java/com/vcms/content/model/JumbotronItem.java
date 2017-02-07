package com.vcms.content.model;

public class JumbotronItem extends ContentModel {
	
	private Title title;
	private Paragraph paragraph;

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Paragraph getParagraph() {
		return paragraph;
	}
	
	public void setParagraph(Paragraph paragraph) {
		this.paragraph = paragraph;
	}
	
}
