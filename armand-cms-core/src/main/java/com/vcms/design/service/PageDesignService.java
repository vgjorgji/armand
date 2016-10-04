package com.vcms.design.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcms.content.service.ContentService;
import com.vcms.design.model.DesignComponent;
import com.vcms.design.model.DesignComponentRepository;
import com.vcms.design.model.PageDesign;
import com.vcms.design.model.PageDesignRepository;
import com.vcms.website.model.Website;

@Service
public class PageDesignService {

	@Autowired
	private PageDesignRepository pageDesignRepository;
	
	@Autowired
	private DesignComponentRepository designComponentRepository;
	
	@Autowired
	private ContentService contentService;

	
	/**
	 * Gets the pageDesign model for pageId and website for filtering.
	 * 
	 * @param pageId page id
	 * @param website for filtering
	 * @return pageDesign
	 */
	public PageDesign getPageDesign(long pageId, Website website) {
		PageDesign pageDesign = pageDesignRepository.getPageDesign(pageId);

		// check model
		if (pageDesign != null) {
			
			// load
			List<DesignComponent> designComponents = designComponentRepository.getDesignComponents(pageDesign.getPageId());
			
			// filter
			List<DesignComponent> result = new ArrayList<>(designComponents.size());
			for (DesignComponent designComponent : designComponents) {
				if (website.getCmsPackage().isComponentSupported(designComponent.getComponent())) {
					
					// load content models
					designComponent.setContentModels(contentService.getContentModels(designComponent));
					result.add(designComponent);
				}
			}
		}

		// result
		return pageDesign;
	}

}
