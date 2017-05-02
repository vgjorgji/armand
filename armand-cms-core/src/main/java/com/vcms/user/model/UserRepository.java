package com.vcms.user.model;

import java.util.List;

import com.vcms.persist.model.HistoryModelRepository;

public interface UserRepository extends HistoryModelRepository<User> {

	User getUser(String username);
	
	List<User> getMasterUsers();
	
}
