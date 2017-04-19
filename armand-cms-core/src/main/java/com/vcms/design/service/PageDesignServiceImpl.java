package com.vcms.design.service;

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
public class PageDesignServiceImpl implements PageDesignService {

	@Autowired
	private PageDesignRepository pageDesignRepository;
	
	@Autowired
	private DesignComponentRepository designComponentRepository;
	
	@Autowired
	private ContentService contentService;

	
	@Override
	public PageDesign getPageDesign(long pageId, Website website) {
		// get and check
		PageDesign pageDesign = pageDesignRepository.getPageDesign(pageId);
		if (pageDesign != null) {
			
			// load
			List<DesignComponent> designComponents = designComponentRepository.getDesignComponents(pageDesign.getPageId());
			
			// filter
			for (DesignComponent designComponent : designComponents) {
				if (website.getCmsPackage().isComponentSupported(designComponent.getComponent())) {
					
					// load content models
					designComponent.setContentModels(contentService.getContentModels(designComponent));
					pageDesign.addDesignComponent(designComponent);
				}
			}
		}

		// result
		return pageDesign;
	}

}
