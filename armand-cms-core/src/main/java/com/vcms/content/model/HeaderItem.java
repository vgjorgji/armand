package com.vcms.content.model;

import com.vcms.media.model.Media;
import com.vcms.persist.model.ContentModel;

public class HeaderItem extends ContentModel {

	private Media logo;

	public Media getLogo() {
		return logo;
	}

	public void setLogo(Media logo) {
		this.logo = logo;
	}
	
}
