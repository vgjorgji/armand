package com.vcms.user.stub;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.vcms.localization.model.Language;
import com.vcms.persist.model.Fetch;
import com.vcms.persist.stub.HistoryModelRepositoryStub;
import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;

@Repository
public class UserRepositoryStub
		extends HistoryModelRepositoryStub<User>
		implements UserRepository {

	@PostConstruct
	public void init() {
		User user = new User();
		user.setUsername("root");
		user.setPassword("root");
		user.setEnabled(true);
		user.setFirstName("User");
		user.setLastName("Root");
		user.setEmail("root.user@email.com");
		user.setMaster(true);
		saveModel(user);
		
		user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setEnabled(true);
		user.setFirstName("User");
		user.setLastName("Admin");
		user.setEmail("admin.user@email.com");
		saveModel(user);
		
		user = new User();
		user.setUsername("demo");
		user.setPassword("demo");
		user.setEnabled(true);
		user.setFirstName("User");
		user.setLastName("Demo");
		user.setEmail("demo.user@email.com");
		user.setPhone("070-226-480");
		user.setLanguage(Language.Macedonian);
		saveModel(user);
		
		user = new User();
		user.setUsername("disabled");
		user.setPassword("disabled");
		user.setEnabled(false);
		user.setFirstName("User");
		user.setLastName("Disabled");
		user.setEmail("disabled@email.com");
		user.setLanguage(Language.English);
		saveModel(user);
	}
	
	@Override
	public User getUser(String username) {
		for (User user : getAllModels().getModels()) {
			if (StringUtils.equals(user.getUsername(), username)) {
				return user;
			}
		}
		return null;
	}
	
	@Override
	public Fetch<User> getMasterUsers() {
		Fetch<User> fetch = new Fetch<>();
		for (User user : getAllModels().getModels()) {
			if (user.isMaster()) {
				fetch.put(user.getId(), user);
			}
		}
		return fetch;
	}

	@Override
	protected boolean searchModel(User model, String query) {
		String text = model.getId()
				+ "%" + model.getEmail()
				+ "%" + model.getFirstName()
				+ "%" + model.getLastName()
				+ "%" + model.getPhone()
				+ "%" + model.getUsername() 
				+ "%" + (model.getLanguage() != null ? model.getLanguage().name() : "");
		return StringUtils.contains(text, query);
	}

}
