package com.vcms.user.stub;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;
import com.vcms.utils.StubUtils;

@Repository
public class UserStubRepository implements UserRepository {

	private Map<String, User> map = new HashMap<>();
	
	@PostConstruct
	public void init() {
		User user = StubUtils.createStubDbModel(new User(), 1000);
		user.setUsername("root");
		user.setPassword("root");
		user.setEnabled(true);
		user.setFirstName("User");
		user.setLastName("Root");
		user.setEmail("root.user@email.com");
		map.put(user.getUsername(), user);
		
		user = StubUtils.createStubDbModel(new User(), 1001);
		user.setUsername("admin");
		user.setPassword("admin");
		user.setEnabled(true);
		user.setFirstName("User");
		user.setLastName("Admin");
		user.setEmail("admin.user@email.com");
		map.put(user.getUsername(), user);
		
		user = StubUtils.createStubDbModel(new User(), 1002);
		user.setUsername("demo");
		user.setPassword("demo");
		user.setEnabled(true);
		user.setFirstName("User");
		user.setLastName("Demo");
		user.setEmail("demo.user@email.com");
		map.put(user.getUsername(), user);
	}
	
	@Override
	public User getUser(String username) {
		return map.get(username);
	}

}
