package com.vcms.user.model;

import com.vcms.persist.model.Fetch;
import com.vcms.persist.model.HistoryModelRepository;

public interface UserRepository extends HistoryModelRepository<User> {

	User getUser(String username);
	
	Fetch<User> getMasterUsers();
	
}
