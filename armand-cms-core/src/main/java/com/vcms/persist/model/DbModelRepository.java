package com.vcms.persist.model;

import java.util.Collection;
import java.util.List;

public interface DbModelRepository<T extends DbModel> {
	
	/**
	 * Saves the model (insert or update) depending of the ID.
	 * @param model model to save
	 */
	void saveModel(T model);
	
	/**
	 * Deletes the model for the given ID.
	 * @param id id of the model
	 */
	void deleteModel(long id);
	
	/**
	 * Returns the model for the given ID.
	 * @param id id of the model
	 * @return model
	 */
	T getModel(long id);
	
	/**
	 * Returns all models for the given IDs
	 * @param ids IDs of the model
	 * @return list of models
	 */
	List<T> getModels(Collection<Long> ids);
	
	/**
	 * Returns all models.
	 * @return list of models
	 */
	List<T> getAllModels();
	
	/**
	 * Searches for models in the given paging search.
	 * @return Paging
	 */
	Paging<T> getPagingModels(PagingSearch paging);
}
