package com.armand.cms.core.content.model;

import com.armand.cms.core.media.model.Media;

public class HeaderItem extends ContentModel {

	private Media logo;

	public Media getLogo() {
		return logo;
	}

	public void setLogo(Media logo) {
		this.logo = logo;
	}
	
}
