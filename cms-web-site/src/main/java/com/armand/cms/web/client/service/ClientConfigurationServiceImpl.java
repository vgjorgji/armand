package com.armand.cms.web.client.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.armand.cms.core.website.model.Website;
import com.armand.cms.core.website.model.WebsiteRepository;
import com.armand.cms.core.website.model.WebsiteView;
import com.armand.cms.core.website.model.WebsiteViewRepository;
import com.armand.cms.core.website.model.WebsiteViewType;

@Service
public class ClientConfigurationServiceImpl implements ClientConfigurationService {

	@Value("#{contextParameters['websiteName']}")
	private String websiteName;
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@Autowired
	private WebsiteViewRepository websiteVeiwRepository;
	
	private Website website;
	private WebsiteView websiteView;
	
	@PostConstruct
	public void init() {
		website = websiteRepository.getModel(websiteName);
		if (website == null) {
			throw new IllegalStateException("No website for: " + websiteName);
		}
		websiteView = websiteVeiwRepository.getModel(website.getId(), WebsiteViewType.Live);
		if (websiteView == null) {
			throw new IllegalStateException("No website view for Live website :" + websiteName);
		}
	}
	
	@Override
	public String getWebsiteName() {
		return websiteName;
	}

	@Override
	public Website getWebsite() {
		return website;
	}

	@Override
	public WebsiteView getWebsiteView() {
		return websiteView;
	}

}
