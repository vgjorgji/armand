package com.vcms.website.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.vcms.conf.cms.CmsPackage;
import com.vcms.localization.model.Language;
import com.vcms.persist.model.HistoryModel;
import com.vcms.user.model.UserGroup;
import com.vcms.user.model.UserWebsite;

public class Website extends HistoryModel {
	
	private long companyId;
	private String name;
	private String baseUrl;
	private CmsPackage cmsPackage;
	private List<Language> languages;
	private WebsiteStatus status;
	private Date maintenanceExpiryDate;
	
	private List<WebsiteView> websiteViews;
	private List<UserGroup> groups;
	private List<UserWebsite> userWebsites;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public WebsiteStatus getStatus() {
		return status;
	}

	public void setStatus(WebsiteStatus status) {
		this.status = status;
	}
	
	public CmsPackage getCmsPackage() {
		return cmsPackage;
	}

	public void setCmsPackage(CmsPackage cmsPackage) {
		this.cmsPackage = cmsPackage;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	
	public Language getPrimaryLanguage() {
		if (CollectionUtils.isNotEmpty(languages)) {
			return languages.get(0);
		}
		return null;
	}
	
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public Date getMaintenanceExpiryDate() {
		return maintenanceExpiryDate;
	}

	public void setMaintenanceExpiryDate(Date maintenanceExpiryDate) {
		this.maintenanceExpiryDate = maintenanceExpiryDate;
	}

	public List<WebsiteView> getWebsiteViews() {
		return websiteViews;
	}

	public void setWebsiteViews(List<WebsiteView> websiteViews) {
		this.websiteViews = websiteViews;
	}

	public List<UserGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<UserGroup> groups) {
		this.groups = groups;
	}

	public List<UserWebsite> getUserWebsites() {
		return userWebsites;
	}

	public void setUserWebsites(List<UserWebsite> userWebsites) {
		this.userWebsites = userWebsites;
	}
	
}
