package com.vcms.design.service;

import com.vcms.design.model.PageDesign;
import com.vcms.website.model.Website;

public interface PageDesignService {

	/**
	 * Gets the pageDesign model for pageId and website for filtering.
	 * 
	 * @param pageId page id
	 * @param website for filtering
	 * @return pageDesign
	 */
	PageDesign getPageDesign(long pageId, Website website);

}
