package com.vcms.website.stub;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.vcms.conf.cms.CmsPackage;
import com.vcms.localization.model.Language;
import com.vcms.persist.stub.HistoryModelRepositoryStub;
import com.vcms.utils.DateUtils;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;
import com.vcms.website.model.WebsiteStatus;

@Repository
public class WebsiteRepositoryStub 
		extends HistoryModelRepositoryStub<Website> 
		implements WebsiteRepository {
	
	@PostConstruct
	public void init() {
		Website website = new Website();
		website.setCompanyId(1000);
		website.setName("Demo Website");
		website.setBaseUrl("http://www.vcms-demo.noip.com");
		website.setCmsPackage(CmsPackage.Business);
		website.setLanguages(Arrays.asList(Language.Macedonian, Language.English));
		website.setStatus(WebsiteStatus.Online);
		website.setExpiryDate(DateUtils.getDateFromString("14.12.2018"));
		saveModel(website);
		
		website = new Website();
		website.setCompanyId(1000);
		website.setName("Sample Website");
		website.setBaseUrl("http://www.sample-demo.noip.com");
		website.setCmsPackage(CmsPackage.Dynamic);
		website.setLanguages(Arrays.asList(Language.English));
		website.setStatus(WebsiteStatus.Construction);
		saveModel(website);
	}
	
	@Override
	public Website getModel(String name) {
		for (Website website : getList()) {
			if (StringUtils.equals(website.getName(), name)) {
				return website;
			}
		}
		return null;
	}
	
	@Override
	protected void merge(Website current, Website model) {
		model.setCompanyId(current.getCompanyId());
	}

}
