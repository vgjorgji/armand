package com.vcms.conf.cms;

import java.util.HashSet;
import java.util.Set;

import com.vcms.utils.Utils;

public enum CmsPackage {
	BASIC(300, false, false, true, false,
			Utils.asSet(Component.Header, Component.Navigation, Component.Footer, 
					Component.Titles, Component.Paragraphs, Component.Medias, Component.Links,
					Component.Jumbotron, Component.Highlights, Component.ContactForms, Component.ContactInfos),
			new HashSet<FeedType>()),
	
	DYNAMIC(400, true, false, true, false,
			Utils.asSet(Component.Header, Component.Navigation, Component.Footer, 
					Component.Titles, Component.Paragraphs, Component.Medias, Component.Links,
					Component.Jumbotron, Component.Highlights, Component.ContactForms, Component.ContactInfos,
					Component.Feed),
			Utils.asSet(FeedType.Aricle, FeedType.Album, FeedType.Survey)),
	
	BUSINESS(500, true, true, true, true,
			Utils.asSet(Component.values()),
			Utils.asSet(FeedType.values()));

	private long price;
	private boolean optionSearch;
	private boolean optionNotification;
	private boolean optionLanguage;
	private boolean optionLogin;
	private Set<Component> components;
	private Set<FeedType> feedTypes;
	
	
	/**
	 * Constructor.
	 */
	private CmsPackage(long price,
			boolean optionSearch,
			boolean optionNotification,
			boolean optionLanguage,
			boolean optionLogin,
			Set<Component> components,
			Set<FeedType> feedTypes) {
		this.price = price;
		this.optionSearch = optionSearch;
		this.optionNotification = optionNotification;
		this.optionLanguage = optionLanguage;
		this.optionLogin = optionLogin;
		this.components = components;
		this.feedTypes = feedTypes;
	}
	
	public long getPrice() {
		return price;
	}
	
	public boolean isOptionSearch() {
		return optionSearch;
	}

	public boolean isOptionNotification() {
		return optionNotification;
	}

	public boolean isOptionLanguage() {
		return optionLanguage;
	}

	public boolean isOptionLogin() {
		return optionLogin;
	}

	public Set<Component> getComponents() {
		return components;
	}
	
	public boolean isComponentSupported(Component component) {
		return components.contains(component);
	}
	
	public Set<FeedType> getFeedTypes() {
		return feedTypes;
	}
	
	public boolean isFeedTypeSupported(FeedType feedType) {
		return feedTypes.contains(feedType);
	}
	
}
