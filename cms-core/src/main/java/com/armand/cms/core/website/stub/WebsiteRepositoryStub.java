package com.armand.cms.core.website.stub;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.armand.cms.core.persist.stub.HistoryModelRepositoryStub;
import com.armand.cms.core.website.model.WebsiteRepository;
import com.armand.cms.core.conf.cms.CmsPackage;
import com.armand.cms.core.date.DateUtils;
import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.website.model.Website;
import com.armand.cms.core.website.model.WebsiteStatus;

@Repository
public class WebsiteRepositoryStub 
		extends HistoryModelRepositoryStub<Website> 
		implements WebsiteRepository {
	
	@PostConstruct
	public void init() {
		Website website = new Website();
		website.setCompanyId(1000);
		website.setName("Demo Website");
		website.setBaseUrl("www.vcms-demo.noip.com");
		website.setCmsPackage(CmsPackage.Business);
		website.setLanguages(Arrays.asList(Language.Macedonian, Language.English));
		website.setStatus(WebsiteStatus.Online);
		website.setExpiryDate(DateUtils.getDateFromString("14.12.2018"));
		saveModel(website);
		
		website = new Website();
		website.setCompanyId(1000);
		website.setName("Sample Website");
		website.setBaseUrl("www.sample-demo.noip.com");
		website.setCmsPackage(CmsPackage.Dynamic);
		website.setLanguages(Arrays.asList(Language.English));
		website.setStatus(WebsiteStatus.Construction);
		saveModel(website);
	}
	
	@Override
	public Website getModel(String name) {
		for (Website website : getAllModels().getModels()) {
			if (StringUtils.equals(website.getName(), name)) {
				return website;
			}
		}
		return null;
	}

	@Override
	protected boolean searchModel(Website model, String query) {
		String text = model.getId()
				+ "%" + model.getBaseUrl()
				+ "%" + model.getName()
				+ "%" + model.getCmsPackage().name()
				+ "%" + model.getPrimaryLanguage().name()
				+ "%" + model.getStatus().name();
		return StringUtils.contains(text, query);
	}
	
}
