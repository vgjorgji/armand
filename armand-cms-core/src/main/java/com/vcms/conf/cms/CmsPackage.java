package com.vcms.conf.cms;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.vcms.utils.Utils;

@JsonFormat(shape = Shape.OBJECT)
public enum CmsPackage {
	Basic("fa fa-cube", 
			Utils.asSet(Component.Header, Component.Navigation, Component.Footer, 
					Component.Titles, Component.Paragraphs, Component.Medias, Component.Links,
					Component.Jumbotron, Component.Highlights, Component.ContactForms, Component.ContactInfos),
			new HashSet<FeedType>(),
			Utils.asSet(CmsOption.Language)),
	
	Dynamic("fa fa-cubes",
			Utils.asSet(Component.Header, Component.Navigation, Component.Footer, 
					Component.Titles, Component.Paragraphs, Component.Medias, Component.Links,
					Component.Jumbotron, Component.Highlights, Component.ContactForms, Component.ContactInfos,
					Component.Feed),
			Utils.asSet(FeedType.Aricle, FeedType.Album, FeedType.Survey),
			Utils.asSet(CmsOption.Search, CmsOption.Language)),
	
	Business("fa fa-star",
			Utils.asSet(Component.values()),
			Utils.asSet(FeedType.values()),
			Utils.asSet(CmsOption.values()));

	private String cssClass;
	private Set<CmsOption> options;
	private Set<Component> components;
	private Set<FeedType> feedTypes;
	
	
	/**
	 * Constructor.
	 */
	private CmsPackage(String cssClass,
			Set<Component> components,
			Set<FeedType> feedTypes,
			Set<CmsOption> options) {
		this.cssClass = cssClass;
		this.components = components;
		this.feedTypes = feedTypes;
		this.options = options;
	}

	public String getId() {
		return name();
	}
	
	public String getCssClass() {
		return cssClass;
	}

	@JsonIgnore
	public Set<Component> getComponents() {
		return components;
	}
	
	public boolean isComponentSupported(Component component) {
		return components.contains(component);
	}
	
	@JsonIgnore
	public Set<FeedType> getFeedTypes() {
		return feedTypes;
	}
	
	public boolean isFeedTypeSupported(FeedType feedType) {
		return feedTypes.contains(feedType);
	}
	
	@JsonIgnore
	public Set<CmsOption> getOptions() {
		return options;
	}
	
	public boolean isOptionSupported(CmsOption option) {
		return options.contains(option);
	}
}
