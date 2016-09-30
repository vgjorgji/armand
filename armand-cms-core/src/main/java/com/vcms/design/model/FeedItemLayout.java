package com.vcms.design.model;

public class FeedItemLayout {
	
	private boolean link = true;
	private boolean media = true;
	private boolean titleAsLink = true;
	private boolean text = true;
	private boolean hashTags = true;
	private boolean categories = true;
	private boolean stats = true;
	
	public boolean isLink() {
		return link;
	}
	
	public void setLink(boolean link) {
		this.link = link;
	}

	public boolean isMedia() {
		return media;
	}

	public void setMedia(boolean media) {
		this.media = media;
	}

	public boolean isTitleAsLink() {
		return titleAsLink;
	}

	public void setTitleAsLink(boolean titleAsLink) {
		this.titleAsLink = titleAsLink;
	}

	public boolean isText() {
		return text;
	}

	public void setText(boolean text) {
		this.text = text;
	}

	public boolean isHashTags() {
		return hashTags;
	}

	public void setHashTags(boolean hashTags) {
		this.hashTags = hashTags;
	}

	public boolean isCategories() {
		return categories;
	}

	public void setCategories(boolean categories) {
		this.categories = categories;
	}

	public boolean isStats() {
		return stats;
	}

	public void setStats(boolean stats) {
		this.stats = stats;
	}
	
}
