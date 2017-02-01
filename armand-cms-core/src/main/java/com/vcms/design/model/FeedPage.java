package com.vcms.design.model;

import com.vcms.conf.cms.FeedType;

public class FeedPage extends CmsPage {
	
	private long feedItemId;
	private FeedType feedType;
	
	public long getFeedItemId() {
		return feedItemId;
	}

	public void setFeedItemId(long feedItemId) {
		this.feedItemId = feedItemId;
	}

	public FeedType getFeedType() {
		return feedType;
	}

	public void setFeedType(FeedType feedType) {
		this.feedType = feedType;
	}
	
	@Override
	public Link createLink() {
		Link link = new Link();
		link.setUrl("/" + feedType.name().toLowerCase() + "/" + getUrl());
		link.setText(feedType.getLinkText());
		link.setIcon(feedType.getIcon());
		link.setExternal(false);
		return link;
	}
	
}
