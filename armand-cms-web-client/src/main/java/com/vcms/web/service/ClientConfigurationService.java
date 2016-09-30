package com.vcms.web.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;
import com.vcms.website.model.WebsiteVeiwRepository;
import com.vcms.website.model.WebsiteView;
import com.vcms.website.model.WebsiteViewType;

@Service
public class ClientConfigurationService {

	@Value("#{contextParameters['websiteName']}")
	private String websiteName;
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@Autowired
	private WebsiteVeiwRepository websiteVeiwRepository;
	
	private Website website;
	private WebsiteView websiteView;
	
	@PostConstruct
	public void init() {
		website = websiteRepository.getWebsite(websiteName);
		if (website == null) {
			throw new IllegalStateException("No website for: " + websiteName);
		}
		websiteView = websiteVeiwRepository.getWebsiteView(website.getId(), WebsiteViewType.Live);
		if (websiteView == null) {
			throw new IllegalStateException("No website view for Live website :" + websiteName);
		}
	}
	
	public String getWebsiteName() {
		return websiteName;
	}

	public Website getWebsite() {
		return website;
	}

	public WebsiteView getWebsiteView() {
		return websiteView;
	}

}
