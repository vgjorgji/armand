package com.vcms.website.stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.vcms.conf.cms.CmsPackage;
import com.vcms.localization.model.Language;
import com.vcms.utils.StubUtils;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;
import com.vcms.website.model.WebsiteStatus;

@Repository
public class WebsiteStubRepository implements WebsiteRepository {
	
	private List<Website> list = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		Website website = StubUtils.createStubDbModel(new Website(), 1000);
		website.setCompanyId(1000);
		website.setName("Demo Website");
		website.setBaseUrl("www.vcms-demo.noip.com");
		website.setCmsPackage(CmsPackage.Business);
		website.setLanguages(Arrays.asList(Language.Macedonian, Language.English));
		website.setStatus(WebsiteStatus.Online);
		list.add(website);
		
		website = StubUtils.createStubDbModel(new Website(), 1001);
		website.setCompanyId(1000);
		website.setName("Sample Website");
		website.setBaseUrl("www.sample-demo.noip.com");
		website.setCmsPackage(CmsPackage.Dynamic);
		website.setLanguages(Arrays.asList(Language.English));
		website.setStatus(WebsiteStatus.Online);
		list.add(website);
	}
	
	@Override
	public Website getWebsite(long websiteId) {
		for (Website website : list) {
			if (website.getId() == websiteId) {
				return website;
			}
		}
		return null;
	}

	@Override
	public Website getWebsite(String name) {
		for (Website website : list) {
			if (StringUtils.equals(website.getName(), name)) {
				return website;
			}
		}
		return null;
	}

}
