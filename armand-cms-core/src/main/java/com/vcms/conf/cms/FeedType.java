package com.vcms.conf.cms;

import java.util.Arrays;
import java.util.List;

import com.vcms.design.model.FeedFilter;
import com.vcms.localization.model.LocalText;
import com.vcms.utils.TextUtils;

public enum FeedType {
	Aricle(Icon.Article, 
			TextUtils.createLocalTextSmall("Read More", "Прочитај Повеќе"),
			Arrays.asList(FeedFilter.Latest, FeedFilter.Popular, FeedFilter.Viws)),
	
	Album(Icon.Album, 
			TextUtils.createLocalTextSmall("Open Album", "Отвори го Албумот"),
			Arrays.asList(FeedFilter.Latest, FeedFilter.Popular, FeedFilter.Viws)),
	
	Event(Icon.Event, 
			TextUtils.createLocalTextSmall("View Event", "Види го Настанот"),
			Arrays.asList(FeedFilter.Upcoming, FeedFilter.Current, FeedFilter.Past, FeedFilter.Latest, 
					FeedFilter.Popular, FeedFilter.Viws)),
	
	Survey(Icon.Survey, 
			TextUtils.createLocalTextSmall("Answer Survery", "Одговори на Анкетата"),
			Arrays.asList(FeedFilter.Active, FeedFilter.Finished, FeedFilter.Latest, FeedFilter.Popular, 
					FeedFilter.Viws)),
	
	Quiz(Icon.Quiz, 
			TextUtils.createLocalTextSmall("Start Quiz", "Започни со Квизот"),
			Arrays.asList(FeedFilter.Latest, FeedFilter.Popular, FeedFilter.Viws)),
	
	Research(Icon.Research, 
			TextUtils.createLocalTextSmall("Read Research", "Прочитај го Истражувањето"),
			Arrays.asList(FeedFilter.Latest, FeedFilter.Popular, FeedFilter.Viws)),
	
	PublicProcurement(Icon.PublicProcurement, 
			TextUtils.createLocalTextSmall("Announcement for Public Procurement", "Оглас за Јавна Набавка"),
			Arrays.asList(FeedFilter.Active, FeedFilter.Finished, FeedFilter.Latest, FeedFilter.Popular, 
					FeedFilter.Viws)),
	
	Project(Icon.Project, 
			TextUtils.createLocalTextSmall("Project Info", "Информации за Проектот"),
			Arrays.asList(FeedFilter.Preparing, FeedFilter.Constructing, FeedFilter.Maintenance, FeedFilter.Finished, 
					FeedFilter.Latest, FeedFilter.Popular, FeedFilter.Viws)),
	
	Partner(Icon.Partner, 
			TextUtils.createLocalTextSmall("Partner Info", "Информации за Партнерот"),
			Arrays.asList(FeedFilter.Latest, FeedFilter.Popular, FeedFilter.Viws, FeedFilter.VIP));
	

	private Icon icon;
	private LocalText linkText;
	private List<FeedFilter> filters;
	
	/**
	 * Constructor.
	 */
	private FeedType(Icon icon, LocalText linkText, List<FeedFilter> filter) {
		this.icon = icon;
		this.linkText = linkText;
		this.filters = filter;
	}
	
	public Icon getIcon() {
		return icon;
	}
	
	public LocalText getLinkText() {
		return linkText;
	}
	
	public List<FeedFilter> getFilters() {
		return filters;
	}
	
}
