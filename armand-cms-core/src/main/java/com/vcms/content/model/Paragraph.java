package com.vcms.content.model;

import com.vcms.design.model.Link;
import com.vcms.design.model.Page;
import com.vcms.localization.model.LocalText;
import com.vcms.media.model.Media;

public class Paragraph {

	private ParagraphLayout layout = ParagraphLayout.TextLeftMediaRight;
	private Media media;
	private LocalText text;
	private Align align = Align.Left;
	private Page page;
	private Link link;
	
	public ParagraphLayout getLayout() {
		return layout;
	}
	
	public void setLayout(ParagraphLayout layout) {
		this.layout = layout;
	}
	
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

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
		this.link = page.createLink();
	}

	public Link getLink() {
		return link;
	}

}
