package com.vcms.content.model;

import com.vcms.media.model.Media;
import com.vcms.persist.model.ContentModel;

public class MediaItem extends ContentModel {
	
	private Media media;

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}
	
}
