package com.vcms.content.model;

import java.util.Date;

import com.vcms.classify.model.Categories;
import com.vcms.comment.model.Comments;
import com.vcms.design.model.FeedPage;
import com.vcms.design.model.Link;
import com.vcms.hashtag.model.HashTags;
import com.vcms.localization.model.LocalText;
import com.vcms.media.model.Media;

public class FeedItem extends ContentModel {
	
	private LocalText title;
	private LocalText infoText;
	private Media media;
	private FeedPage page;
	private Link link;
	private Categories categories;
	private HashTags hashTags;
	private Comments comments;

	private Date date;
	private Date dateStart;
	private Date dateEnd;
	private LocalText location;
	
	public LocalText getTitle() {
		return title;
	}

	public void setTitle(LocalText title) {
		this.title = title;
	}
	
	public LocalText getInfoText() {
		return infoText;
	}

	public void setInfoText(LocalText infoText) {
		this.infoText = infoText;
	}

	public Media getMedia() {
		return media;
	}
	
	public void setMedia(Media media) {
		this.media = media;
	}
	
	
	public FeedPage getPage() {
		return page;
	}

	public void setPage(FeedPage page) {
		this.page = page;
		this.link = page.createLink();
	}
	
	public Link getLink() {
		return link;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public HashTags getHashTags() {
		return hashTags;
	}

	public void setHashTags(HashTags hashTags) {
		this.hashTags = hashTags;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalText getLocation() {
		return location;
	}

	public void setLocation(LocalText location) {
		this.location = location;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	
}
