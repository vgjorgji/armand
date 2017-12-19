package com.armand.cms.core.design.model;

import com.armand.cms.core.classify.model.Categories;
import com.armand.cms.core.conf.cms.Component;
import com.armand.cms.core.conf.cms.FeedType;

public class FeedDesignComponent extends DesignComponent {
	
	private FeedType feedType;
	private FeedFilter feedFilter;
	private Categories categories;
	private int feedsPerPage;
	private boolean showSearch;
	private boolean showPagination;
	private FeedItemLayout feedItemLayout = new FeedItemLayout();
	
	public FeedDesignComponent() {
		super.setComponent(Component.Feed);
	}
	
	@Override
	public void setComponent(Component component) {
		super.setComponent(Component.Feed);
	}
	
	public FeedType getFeedType() {
		return feedType;
	}

	public void setFeedType(FeedType feedType) {
		this.feedType = feedType;
	}

	public FeedFilter getFeedFilter() {
		return feedFilter;
	}

	public void setFeedFilter(FeedFilter feedFilter) {
		this.feedFilter = feedFilter;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	
	public int getFeedsPerPage() {
		return feedsPerPage;
	}

	public void setFeedsPerPage(int feedsPerPage) {
		this.feedsPerPage = feedsPerPage;
	}

	public boolean isShowSearch() {
		return showSearch;
	}

	public void setShowSearch(boolean showSearch) {
		this.showSearch = showSearch;
	}

	public boolean isShowPagination() {
		return showPagination;
	}

	public void setShowPagination(boolean showPagination) {
		this.showPagination = showPagination;
	}

	public FeedItemLayout getFeedItemLayout() {
		return feedItemLayout;
	}

	public void setFeedItemLayout(FeedItemLayout feedItemLayout) {
		this.feedItemLayout = feedItemLayout;
	}

}
