package com.vcms.user.stub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.localization.model.Language;
import com.vcms.user.model.PowerGroup;
import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;
import com.vcms.user.model.UserWebsite;
import com.vcms.user.model.UserWebsiteRepository;
import com.vcms.utils.Utils;
import com.vcms.website.model.Website;

@Repository
public class UserWebsiteStubRepository implements UserWebsiteRepository {

	private List<UserWebsite> list = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		User user = new User();
		user.setUsername("demo");
		user.setPassword("demo");
		user.setEnabled(true);
		user.setPowerGroup(PowerGroup.Roots);
		
		user.setWebsites(new ArrayList<Website>());
		Website website = new Website();
		website.setName("Demo");
		user.getWebsites().add(website);
		
		user.setFirstName(Utils.createLocalTextSmall("Demo", "Демо"));
		user.setLastName(Utils.createLocalTextSmall("User", "Корисник"));
		user.setEmail("demo.user@email.com");
		user.setLanguage(Language.Macedonian);
		
		user.setJobPosition(Utils.createLocalTextSmall("Test job position", "Тест работна позиција"));
		user.setBiography(Utils.createLocalTextSmall("Biography...", "Биографија..."));
		map.put(user.getUsername(), user);
	}

	@Override
	public List<UserWebsite> getWebsitesForUser(long userId) {
		List<UserWebsite> result = new ArrayList<>();
		for (UserWebsite userWebsite : list) {
			if (userWebsite.getUserId() == userId) {
				result.add(userWebsite);
			}
		}
		return result;
	}

	@Override
	public List<UserWebsite> getUsersForWebsite(long websiteId) {
		List<UserWebsite> result = new ArrayList<>();
		for (UserWebsite userWebsite : list) {
			if (userWebsite.getWebsiteId() == websiteId) {
				result.add(userWebsite);
			}
		}
		return result;
	}
	
}
