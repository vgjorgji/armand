package com.vcms.user.stub;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.localization.model.Language;
import com.vcms.user.model.PowerGroup;
import com.vcms.user.model.WebsiteUser;
import com.vcms.user.model.WebsiteUserRepository;
import com.vcms.utils.StubUtils;

@Repository
public class UserWebsiteStubRepository implements WebsiteUserRepository {

	private List<WebsiteUser> list = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		WebsiteUser websiteUser = StubUtils.createStubDbModel(new WebsiteUser(), 1000);
		websiteUser.setUserId(1000);
		websiteUser.setWebsiteId(1000);
		websiteUser.setPowerGroup(PowerGroup.Roots);
		websiteUser.setLanguage(Language.English);
		websiteUser.setJobPosition(StubUtils.createLocalTextSmall("Test job position", "Тест работна позиција"));
		websiteUser.setBiography(StubUtils.createLocalTextSmall("Biography...", "Биографија..."));
		list.add(websiteUser);
		
		websiteUser = StubUtils.createStubDbModel(new WebsiteUser(), 1001);
		websiteUser.setUserId(1001);
		websiteUser.setWebsiteId(1000);
		websiteUser.setPowerGroup(PowerGroup.Administrators);
		websiteUser.setLanguage(Language.English);
		websiteUser.setJobPosition(StubUtils.createLocalTextSmall("Test job position", "Тест работна позиција"));
		websiteUser.setBiography(StubUtils.createLocalTextSmall("Biography...", "Биографија..."));
		list.add(websiteUser);
		
		websiteUser = StubUtils.createStubDbModel(new WebsiteUser(), 1002);
		websiteUser.setUserId(1002);
		websiteUser.setWebsiteId(1000);
		websiteUser.setPowerGroup(PowerGroup.Members);
		websiteUser.setLanguage(Language.Macedonian);
		websiteUser.setJobPosition(StubUtils.createLocalTextSmall("Test job position", "Тест работна позиција"));
		websiteUser.setBiography(StubUtils.createLocalTextSmall("Biography...", "Биографија..."));
		list.add(websiteUser);
	}

	@Override
	public List<WebsiteUser> getWebsitesForUser(long userId) {
		List<WebsiteUser> result = new ArrayList<>();
		for (WebsiteUser userWebsite : list) {
			if (userWebsite.getUserId() == userId) {
				result.add(userWebsite);
			}
		}
		return result;
	}

	@Override
	public List<WebsiteUser> getUsersForWebsite(long websiteId) {
		List<WebsiteUser> result = new ArrayList<>();
		for (WebsiteUser userWebsite : list) {
			if (userWebsite.getWebsiteId() == websiteId) {
				result.add(userWebsite);
			}
		}
		return result;
	}

	@Override
	public WebsiteUser getWebsiteUser(long userId, long websiteId) {
		for (WebsiteUser userWebsite : list) {
			if (userWebsite.getUserId() == userId && userWebsite.getWebsiteId() == websiteId) {
				return userWebsite;
			}
		}
		return null;
	}
	
}
