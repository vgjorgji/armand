package com.vcms.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcms.design.model.DesignComponent;
import com.vcms.design.model.DesignComponentRepository;
import com.vcms.website.model.CmsPage;
import com.vcms.website.model.Page;
import com.vcms.website.model.PageRepository;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteView;

@Service
public class PageService {

	@Autowired
	private PageRepository pageRepository;

	@Autowired
	private DesignComponentRepository designComponentRepository;

	public Page getCmsPage(Website website, WebsiteView websiteView, String url) {
		CmsPage page = pageRepository.getCmsPage(websiteView.getId(), url);
		
		// check page and load design components
		if (page != null) {
			List<DesignComponent> designComponents = designComponentRepository.getDesignComponents(page.getId());
			for (DesignComponent designComponent : designComponents) {
				if (website.getCmsPackage().isComponentSupported(designComponent.getComponent())) {
					//page.addDesignComponent(designComponent);
				}
			}

			// load content components
			// TODO implement it
		}

		// result
		return page;
	}

}
