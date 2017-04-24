package com.vcms.persist.repo;

import com.vcms.persist.model.DbModel;
import com.vcms.persist.model.DbModelRepository;
import com.vcms.persist.model.DbModelState;

public abstract class DbModelRepositoryImpl<T extends DbModel> implements DbModelRepository<T> {
	
	@Override
	public void saveModel(T model) {
		if (model.getId() == 0) {
			setNewModelId(model);
			interceptBeforeInsertModel(model);
			insertModel(model);
			model.setState(DbModelState.EXIST);
			
		} else {
			T current = getModel(model.getId());
			if (current != null) {
				merge(current, model);
				interceptBeforeUpdateModel(current, model);
				updateModel(current, model);
			} else {
				throw new IllegalStateException("The model " + model.getId() + " is in invalid state!");
			}
		}
	}
	
	protected abstract void setNewModelId(T model);
	
	protected abstract void insertModel(T model);
	
	protected abstract void updateModel(T current, T model);
	
	protected void merge(T current, T model) {
		// for overriding
	}
	
	protected void interceptBeforeInsertModel(T model) {
		// for overriding
	}
	
	protected void interceptBeforeUpdateModel(T current, T model) {
		// for overriding
	}

}
