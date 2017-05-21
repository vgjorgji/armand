package com.vcms.user.stub;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.vcms.persist.model.Fetch;
import com.vcms.persist.stub.HistoryModelRepositoryStub;
import com.vcms.user.model.WebsiteGroup;
import com.vcms.user.model.WebsiteGroupRepository;

@Repository
public class WebsiteGroupRepositoryStub 
		extends HistoryModelRepositoryStub<WebsiteGroup>
		implements WebsiteGroupRepository {

	@PostConstruct
	public void init() {
		WebsiteGroup websiteUser = new WebsiteGroup();
		websiteUser.setWebsiteId(1000);
		websiteUser.setName("Group Masters");
		websiteUser.setMaster(true);
		saveModel(websiteUser);
		
		websiteUser = new WebsiteGroup();
		websiteUser.setWebsiteId(1000);
		websiteUser.setName("Group Users");
		saveModel(websiteUser);
		
		websiteUser = new WebsiteGroup();
		websiteUser.setWebsiteId(1001);
		websiteUser.setName("Group Masters");
		websiteUser.setMaster(true);
		saveModel(websiteUser);
	}

	@Override
	public Fetch<WebsiteGroup> getGroupsForWebsites(Collection<Long> websiteIds) {
		Fetch<WebsiteGroup> fetch = new Fetch<>();
		for (WebsiteGroup websiteGroup : getAllModels().getModels()) {
			if (websiteIds.contains(websiteGroup.getWebsiteId())) {
				fetch.put(websiteGroup.getId(), websiteGroup);
			}
		}
		return fetch;
	}
	
	@Override
	protected long getParentId(WebsiteGroup model, String parentField) {
		return model.getWebsiteId();
	}

	@Override
	protected boolean searchModel(WebsiteGroup model, String query) {
		String text = model.getId()
				+ "%" + model.getName();
		return StringUtils.contains(text, query);
	}

}
