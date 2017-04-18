package com.vcms.conf.cms;

import java.util.HashSet;
import java.util.Set;

import com.vcms.utils.Utils;

public enum CmsPackage {
	Basic(300, 
			Utils.asSet(Component.Header, Component.Navigation, Component.Footer, 
					Component.Titles, Component.Paragraphs, Component.Medias, Component.Links,
					Component.Jumbotron, Component.Highlights, Component.ContactForms, Component.ContactInfos),
			new HashSet<FeedType>(),
			Utils.asSet(CmsOption.Language)),
	
	Dynamic(400,
			Utils.asSet(Component.Header, Component.Navigation, Component.Footer, 
					Component.Titles, Component.Paragraphs, Component.Medias, Component.Links,
					Component.Jumbotron, Component.Highlights, Component.ContactForms, Component.ContactInfos,
					Component.Feed),
			Utils.asSet(FeedType.Aricle, FeedType.Album, FeedType.Survey),
			Utils.asSet(CmsOption.Search, CmsOption.Language)),
	
	Business(500,
			Utils.asSet(Component.values()),
			Utils.asSet(FeedType.values()),
			Utils.asSet(CmsOption.values()));

	private long price;
	private Set<CmsOption> options;
	private Set<Component> components;
	private Set<FeedType> feedTypes;
	
	
	/**
	 * Constructor.
	 */
	private CmsPackage(long price,
			Set<Component> components,
			Set<FeedType> feedTypes,
			Set<CmsOption> options) {
		this.price = price;
		this.components = components;
		this.feedTypes = feedTypes;
		this.options = options;
	}
	
	public long getPrice() {
		return price;
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
	
	public Set<CmsOption> getOptions() {
		return options;
	}
	
	public boolean isOptionSupported(CmsOption option) {
		return options.contains(option);
	}
}
