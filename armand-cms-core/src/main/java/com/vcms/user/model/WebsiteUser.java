package com.vcms.user.model;

import com.vcms.localization.model.Language;
import com.vcms.localization.model.LocalText;
import com.vcms.media.model.Media;
import com.vcms.persist.model.HistoryModel;

public class WebsiteUser extends HistoryModel {

	private long userId;
	private long websiteId;
	private long websiteGroupId;

	private PowerGroup powerGroup;
	private Language language;

	private LocalText jobPosition;
	private LocalText biography;
	private Media media;

	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(long websiteId) {
		this.websiteId = websiteId;
	}
	
	public long getWebsiteGroupId() {
		return websiteGroupId;
	}

	public void setWebsiteGroupId(long websiteGroupId) {
		this.websiteGroupId = websiteGroupId;
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
	
}
