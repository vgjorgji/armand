package com.vcms.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcms.website.model.WebsiteViewRepository;
import com.vcms.website.model.WebsiteView;
import com.vcms.website.model.WebsiteViewType;

@Service
public class WebsiteViewServiceImpl implements WebsiteViewService {
	
	@Autowired
	private WebsiteViewRepository websiteVeiwRepository;
	
	@Override
	public WebsiteView getWebsiteView(long websiteViewId) {
		return websiteVeiwRepository.getWebsiteView(websiteViewId);
	}

	@Override
	public WebsiteView getWebsiteView(long websiteId, WebsiteViewType viewType) {
		return  websiteVeiwRepository.getWebsiteView(websiteId, viewType);
	}

	@Override
	public void save(WebsiteView websiteView) {
		websiteVeiwRepository.save(websiteView);
	}

}
