package com.vcms.website.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.vcms.conf.cms.CmsPackage;
import com.vcms.localization.model.Language;
import com.vcms.persist.model.HistoryModel;

public class Website extends HistoryModel {
	
	private long companyId;
	private String name;
	private String baseUrl;
	private CmsPackage cmsPackage;
	private List<Language> languages;
	private WebsiteStatus status;
	private Date expiryDate;

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

	@JsonFormat(shape = Shape.STRING, pattern = "dd.MM.yyyy")
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
