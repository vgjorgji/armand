package com.vcms.user.stub;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.localization.model.Language;
import com.vcms.persist.stub.HistoryModelRepositoryStub;
import com.vcms.user.model.PowerGroup;
import com.vcms.user.model.WebsiteUser;
import com.vcms.user.model.WebsiteUserRepository;
import com.vcms.utils.TextUtils;

@Repository
public class WebsiteUserRepositoryStub 
		extends HistoryModelRepositoryStub<WebsiteUser>
		implements WebsiteUserRepository {

	@PostConstruct
	public void init() {
		WebsiteUser websiteUser = new WebsiteUser();
		websiteUser.setUserId(1000);
		websiteUser.setWebsiteId(1000);
		websiteUser.setPowerGroup(PowerGroup.Roots);
		websiteUser.setLanguage(Language.English);
		websiteUser.setJobPosition(TextUtils.createLocalTextSmall("Test job position", "Тест работна позиција"));
		websiteUser.setBiography(TextUtils.createLocalTextSmall("Biography...", "Биографија..."));
		saveModel(websiteUser);
		
		websiteUser = new WebsiteUser();
		websiteUser.setUserId(1000);
		websiteUser.setWebsiteId(1001);
		websiteUser.setPowerGroup(PowerGroup.Roots);
		websiteUser.setLanguage(Language.English);
		websiteUser.setJobPosition(TextUtils.createLocalTextSmall("Test job position", "Тест работна позиција"));
		websiteUser.setBiography(TextUtils.createLocalTextSmall("Biography...", "Биографија..."));
		saveModel(websiteUser);
		
		websiteUser = new WebsiteUser();
		websiteUser.setUserId(1001);
		websiteUser.setWebsiteId(1000);
		websiteUser.setPowerGroup(PowerGroup.Administrators);
		websiteUser.setLanguage(Language.English);
		websiteUser.setJobPosition(TextUtils.createLocalTextSmall("Test job position", "Тест работна позиција"));
		websiteUser.setBiography(TextUtils.createLocalTextSmall("Biography...", "Биографија..."));
		saveModel(websiteUser);
		
		websiteUser = new WebsiteUser();
		websiteUser.setUserId(1002);
		websiteUser.setWebsiteId(1000);
		websiteUser.setPowerGroup(PowerGroup.Members);
		websiteUser.setLanguage(Language.Macedonian);
		websiteUser.setJobPosition(TextUtils.createLocalTextSmall("Test job position", "Тест работна позиција"));
		websiteUser.setBiography(TextUtils.createLocalTextSmall("Biography...", "Биографија..."));
		saveModel(websiteUser);
	}

	@Override
	public List<WebsiteUser> getWebsitesForUser(long userId) {
		List<WebsiteUser> result = new ArrayList<>();
		for (WebsiteUser userWebsite : getAllModels()) {
			if (userWebsite.getUserId() == userId) {
				result.add(userWebsite);
			}
		}
		return result;
	}

	@Override
	public List<WebsiteUser> getUsersForWebsite(long websiteId) {
		List<WebsiteUser> result = new ArrayList<>();
		for (WebsiteUser userWebsite : getAllModels()) {
			if (userWebsite.getWebsiteId() == websiteId) {
				result.add(userWebsite);
			}
		}
		return result;
	}

	@Override
	public WebsiteUser getModel(long userId, long websiteId) {
		for (WebsiteUser userWebsite : getAllModels()) {
			if (userWebsite.getUserId() == userId && userWebsite.getWebsiteId() == websiteId) {
				return userWebsite;
			}
		}
		return null;
	}

	@Override
	protected boolean searchModel(WebsiteUser model, String query) {
		return true;
	}
	
}
