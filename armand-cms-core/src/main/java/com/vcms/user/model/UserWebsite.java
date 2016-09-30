package com.vcms.user.model;

import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

import com.vcms.localization.model.Language;
import com.vcms.localization.model.LocalText;
import com.vcms.media.model.Media;
import com.vcms.persist.model.HistoryModel;
import com.vcms.website.model.Website;

public class UserWebsite extends HistoryModel {

	private long websiteId;
	private long userId;

	private PowerGroup powerGroup;
	private Language language;

	private LocalText jobPosition;
	private LocalText biography;
	private Media media;

	// on-demand
	private Website website;

	public long getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(long websiteId) {
		this.websiteId = websiteId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public PowerGroup getPowerGroup() {
		return powerGroup;
	}

	public void setPowerGroup(PowerGroup powerGroup) {
		this.powerGroup = powerGroup;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public LocalText getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(LocalText jobPosition) {
		this.jobPosition = jobPosition;
	}

	public LocalText getBiography() {
		return biography;
	}

	public void setBiography(LocalText biography) {
		this.biography = biography;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public Website getWebsite() {
		return website;
	}

	public void setWebsite(Website website) {
		this.website = website;
	}

	public Set<Role> getUserRolesForWebsite() {
		if (website == null) {
			throw new IllegalStateException("No website for userWebsite: " + toString());
		}
		if (powerGroup == null) {
			throw new IllegalStateException("No PowerGroup for userWebsite: " + toString());
		}
		if (website.getCmsPackage() == null) {
			throw new IllegalStateException("No CmsPackage for website: " + website);
		}
		return powerGroup.getRolesForCmsPackage(website.getCmsPackage());
	}

	public Language getUserLanguageForWebsite() {
		Language websiteLanguage = null;

		// 1. has webiste
		if (website != null) {
			if (CollectionUtils.isEmpty(website.getLanguages())) {
				throw new IllegalStateException("No Languages defined for website: " + website);
			}

			// has set language: validate against the website languages
			if (language != null) {
				if (website.getLanguages().contains(language)) {
					websiteLanguage = language;
				} else {
					websiteLanguage = website.getPrimaryLanguage();
				}

			} else {
				websiteLanguage = website.getPrimaryLanguage();
			}

		} else {
			// 2. no website, use only language
			if (language != null) {
				websiteLanguage = language;
			}
		}

		// user language for the website, can be null
		return websiteLanguage;
	}

}
