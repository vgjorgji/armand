package com.vcms.persist.model;

import java.util.Collection;

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
	 * @return fetch object
	 */
	Fetch<T> getModels(Collection<Long> ids);
	
	/**
	 * Returns all models for the given parent IDs and there is additional parameter 'parentField'
	 * to support multiple parent search.
	 * @param parentIds IDs of the parent
	 * @param parentField support for multiple parent search
	 * @return fetch object
	 */
	Fetch<T> getModels(Collection<Long> parentIds, String parentField);
	
	/**
	 * Returns all models.
	 * @return fetch object
	 */
	Fetch<T> getAllModels();
	
	/**
	 * Searches for models in the given paging search.
	 * @return Paging
	 */
	Paging<T> getPagingModels(PagingSearch paging);
}
