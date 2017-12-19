package com.armand.cms.core.user.stub;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.persist.stub.HistoryModelRepositoryStub;
import com.armand.cms.core.user.model.WebsiteUser;
import com.armand.cms.core.user.model.WebsiteUserRepository;
import com.armand.cms.core.utils.TextUtils;
import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.persist.model.Fetch;
import com.armand.cms.core.user.model.PowerGroup;

@Repository
public class WebsiteUserRepositoryStub 
		extends HistoryModelRepositoryStub<WebsiteUser>
		implements WebsiteUserRepository {

	@PostConstruct
	public void init() {
		WebsiteUser websiteUser = new WebsiteUser();
		websiteUser.setUserId(1000);
		websiteUser.setWebsiteId(1000);
		websiteUser.setWebsiteGroupId(1000);
		websiteUser.setPowerGroup(PowerGroup.Roots);
		websiteUser.setLanguage(Language.English);
		websiteUser.setJobPosition(TextUtils.createLocalTextSmall("Test job position", "Тест работна позиција"));
		websiteUser.setBiography(TextUtils.createLocalTextSmall("Biography...", "Биографија..."));
		saveModel(websiteUser);
		
		websiteUser = new WebsiteUser();
		websiteUser.setUserId(1000);
		websiteUser.setWebsiteId(1001);
		websiteUser.setWebsiteGroupId(1002);
		websiteUser.setPowerGroup(PowerGroup.Roots);
		websiteUser.setLanguage(Language.English);
		websiteUser.setJobPosition(TextUtils.createLocalTextSmall("Test job position", "Тест работна позиција"));
		websiteUser.setBiography(TextUtils.createLocalTextSmall("Biography...", "Биографија..."));
		saveModel(websiteUser);
		
		websiteUser = new WebsiteUser();
		websiteUser.setUserId(1001);
		websiteUser.setWebsiteId(1000);
		websiteUser.setWebsiteGroupId(1001);
		websiteUser.setPowerGroup(PowerGroup.Administrators);
		websiteUser.setLanguage(Language.English);
		websiteUser.setJobPosition(TextUtils.createLocalTextSmall("Test job position", "Тест работна позиција"));
		websiteUser.setBiography(TextUtils.createLocalTextSmall("Biography...", "Биографија..."));
		saveModel(websiteUser);
		
		websiteUser = new WebsiteUser();
		websiteUser.setUserId(1002);
		websiteUser.setWebsiteId(1000);
		websiteUser.setWebsiteGroupId(1001);
		websiteUser.setPowerGroup(PowerGroup.Members);
		websiteUser.setLanguage(Language.Macedonian);
		websiteUser.setJobPosition(TextUtils.createLocalTextSmall("Test job position", "Тест работна позиција"));
		websiteUser.setBiography(TextUtils.createLocalTextSmall("Biography...", "Биографија..."));
		saveModel(websiteUser);
	}

	@Override
	public Fetch<WebsiteUser> getWebsitesForUser(long userId) {
		Fetch<WebsiteUser> fetch = new Fetch<>();
		for (WebsiteUser userWebsite : getAllModels().getModels()) {
			if (userWebsite.getUserId() == userId) {
				fetch.put(userWebsite.getId(), userWebsite);
			}
		}
		return fetch;
	}

	@Override
	public Fetch<WebsiteUser> getUsersForWebsite(long websiteId) {
		Fetch<WebsiteUser> fetch = new Fetch<>();
		for (WebsiteUser userWebsite : getAllModels().getModels()) {
			if (userWebsite.getWebsiteId() == websiteId) {
				fetch.put(userWebsite.getId(), userWebsite);
			}
		}
		return fetch;
	}

	@Override
	public WebsiteUser getModel(long userId, long websiteId) {
		for (WebsiteUser userWebsite : getAllModels().getModels()) {
			if (userWebsite.getUserId() == userId && userWebsite.getWebsiteId() == websiteId) {
				return userWebsite;
			}
		}
		return null;
	}

	@Override
	protected long getParentId(WebsiteUser model, String parentField) {
		return model.getWebsiteGroupId();
	}

}
