package com.vcms.persist.repo;

import com.vcms.persist.model.DbModel;
import com.vcms.persist.model.DbModelRepository;

public abstract class DbModelRepositoryImpl<T extends DbModel> implements DbModelRepository<T> {
	
	@Override
	public void saveModel(T model) {
		saveModelInternal(model, false);
	}
	
	@Override
	public void saveModelFull(T model) {
		saveModelInternal(model, true);
	}
	
	private void saveModelInternal(T model, boolean full) {
		if (model.getId() == 0) {
			setNewModelId(model);
			interceptBeforeInsertModel(model);
			insertModel(model);
			
		} else {
			T current = getModel(model.getId());
			if (current != null) {
				if (!full) {
					merge(current, model);
				}
				interceptBeforeUpdateModel(current, model);
				updateModel(current, model);
			} else {
				throw new IllegalStateException("Can't save the model " + model + " because it is in invalid state!");
			}
		}
	}


	/**
	 * Sets the id of the new model.
	 * @param model model to set the id to
	 */
	protected abstract void setNewModelId(T model);
	
	/**
	 * Intercepter triggered before insertModel.
	 * @param model model that will be inserted
	 */
	protected void interceptBeforeInsertModel(T model) {
		// for overriding
	}
	
	/**
	 * Inserts the model.
	 * @param model model to insert
	 */
	protected abstract void insertModel(T model);
	
	/**
	 * Merges the current with changed model.Sets the attributes that can't be changed.
	 * @param current current (original) model
	 * @param model changed model
	 */
	protected void merge(T current, T model) {
		// for overriding
	}
	
	/**
	 * Intercepter triggered before updateModel.
	 * @param current current (original) model
	 * @param model model to update
	 */
	protected void interceptBeforeUpdateModel(T current, T model) {
		// for overriding
	}
	
	/**
	 * Updates the model.
	 * @param current current (original) model
	 * @param model model to update
	 */
	protected abstract void updateModel(T current, T model);
	
}
