package com.vcms.website.stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.conf.cms.CmsPackage;
import com.vcms.localization.model.Language;
import com.vcms.utils.Utils;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;
import com.vcms.website.model.WebsiteStatus;

@Repository
public class WebsiteStubRepository implements WebsiteRepository {
	
	private Map<String, Website> map = new HashMap<>();
	
	@PostConstruct
	public void init() {
		Website website = Utils.createStubDbModel(new Website(), 1000);
		website.setCompanyId(1000);
		website.setName("Demo");
		website.setBaseUrl("www.vcms-demo.noip.com");
		website.setCmsPackage(CmsPackage.BUSINESS);
		website.setLanguages(Arrays.asList(Language.Macedonian, Language.English));
		website.setStatus(WebsiteStatus.ONLINE);
		map.put(website.getName(), website);
		
		website = Utils.createStubDbModel(new Website(), 1000);
		website.setCompanyId(1000);
		website.setName("Sample");
		website.setBaseUrl("www.sample-demo.noip.com");
		website.setCmsPackage(CmsPackage.DYNAMIC);
		website.setLanguages(Arrays.asList(Language.English));
		website.setStatus(WebsiteStatus.ONLINE);
		map.put(website.getName(), website);
	}

	@Override
	public Website getWebsite(String name) {
		return map.get(name);
	}

	@Override
	public List<Website> getUserWebsites(long userId) {
		return new ArrayList<>(map.values());
	}

}
