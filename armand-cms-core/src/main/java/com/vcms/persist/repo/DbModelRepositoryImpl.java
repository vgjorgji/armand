package com.vcms.persist.repo;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.vcms.persist.model.DbModel;
import com.vcms.persist.model.DbModelRepository;
import com.vcms.persist.model.Paging;
import com.vcms.persist.model.PagingResult;

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
	public final PagingResult<T> getPagingModels(Paging paging) {
		// fix
		if (paging.getPage() < 1) {
			paging.setPage(1);
		}
		if (!ArrayUtils.contains(Paging.SIZES, paging.getSize())) {
			paging.setSize(Paging.SIZES[0]);
		}
		
		// queries
		List<T> models = getModels(paging);
		long count = countModels(paging);
		
		// create
		PagingResult<T> result = new PagingResult<>();
		result.setPage(count > 0 ? paging.getPage() : 0);
		result.setSize(paging.getSize());
		result.setQuery(paging.getQuery());
		result.setModels(models);
		result.setModelsCount(count);
		result.setPageCount((int) Math.ceil(count / (paging.getSize() * 1.0)));
		result.setModelsStart(count > 0 ? (paging.getPage() - 1) * paging.getSize() + 1 : 0);
		result.setModelsEnd(result.getPageCount() == paging.getPage() ? count :  paging.getPage() * paging.getSize());
		
		// result
		return result;
	}
	
	/**
	 * Returns the models for the given paging context.
	 * @param paging paging context
	 * @return list of models
	 */
	protected abstract List<T> getModels(Paging paging);
	
	/**
	 * Counts the total number of models for the given paging context.
	 * @param paging paging context
	 * @return total number of models
	 */
	protected abstract long countModels(Paging paging);
	
}
