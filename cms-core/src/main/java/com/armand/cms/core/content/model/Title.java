package com.armand.cms.core.content.model;

import com.armand.cms.core.localization.model.LocalText;

public class Title {
	
	private LocalText text;
	private Align align = Align.Left;
	
	public LocalText getText() {
		return text;
	}
	
	public void setText(LocalText text) {
		this.text = text;
	}
	
	public Align getAlign() {
		return align;
	}
	
	public void setAlign(Align align) {
		this.align = align;
	}

}
