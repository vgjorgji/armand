package com.vcms.persist.repo;

import com.vcms.persist.model.DbModel;
import com.vcms.persist.model.DbModelRepository;
import com.vcms.persist.model.Fetch;
import com.vcms.persist.model.Paging;
import com.vcms.persist.model.PagingSearch;

public abstract class DbModelRepositoryImpl<T extends DbModel> implements DbModelRepository<T> {
	
	@Override
	public final void saveModel(T model) {
		if (model.getId() == 0) {
			setNewModelId(model);
			interceptBeforeInsertModel(model);
			insertModel(model);
			
		} else {
			T current = getModel(model.getId());
			if (current != null) {
				merge(current, model);
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


	@Override
	public final Paging<T> getPagingModels(PagingSearch pagingSearch) {
		// fix
		if (pagingSearch.getPage() < 1) {
			pagingSearch.setPage(1);
		}
		if (pagingSearch.getSize() < 1) {
			pagingSearch.setSize(PagingSearch.SIZES[0]);
		}
		
		// count
		long count = countModels(pagingSearch.getQuery());
		
		// paging result
		Paging<T> paging = new Paging<>();
		paging.setSize(pagingSearch.getSize());
		paging.setQuery(pagingSearch.getQuery());
		paging.setModelsCount(count);
		paging.setPageCount((int) Math.ceil(count / (paging.getSize() * 1.0)));
		paging.setPage(pagingSearch.getPage() <= paging.getPageCount() ? pagingSearch.getPage() : 0);
		paging.setModelsStart(count > 0 ? (paging.getPage() - 1) * paging.getSize() + 1 : 0);
		paging.setModelsEnd(paging.getPageCount() == paging.getPage() ? count :  paging.getPage() * paging.getSize());
		
		// models
		Fetch<T> fetch = getModels(paging);
		paging.setFetch(fetch);
		
		// result
		return paging;
	}
	
	/**
	 * Counts the total number of models for the given search query.
	 * @param query search query
	 * @return total number of models
	 */
	protected abstract long countModels(String query);
	
	/**
	 * Returns the models for the given paging context.
	 * @param paging paging context
	 * @return list of models
	 */
	protected abstract Fetch<T> getModels(Paging<T> paging);
	
}
