package com.vcms.persist.model;

import java.util.Collection;
import java.util.List;

public interface DbModelRepository<T extends DbModel> {
	
	void saveModel(T model);
	
	T getModel(long id);
	
	List<T> getModels(Collection<Long> ids);
}
