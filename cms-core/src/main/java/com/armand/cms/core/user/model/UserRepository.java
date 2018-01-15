package com.armand.cms.core.user.model;

import com.armand.cms.core.persist.model.Fetch;
import com.armand.cms.core.persist.model.HistoryModelRepository;

public interface UserRepository extends HistoryModelRepository<User> {

  User getUser(String username);

  Fetch<User> getMasterUsers();

}
