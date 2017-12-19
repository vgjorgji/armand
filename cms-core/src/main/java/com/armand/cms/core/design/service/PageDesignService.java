package com.armand.cms.core.design.service;

import com.armand.cms.core.design.model.PageDesign;
import com.armand.cms.core.website.model.Website;

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
