package com.vcms.persist.stub;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.vcms.persist.model.DbModel;
import com.vcms.persist.model.Fetch;
import com.vcms.persist.model.Paging;
import com.vcms.persist.repo.DbModelRepositoryImpl;

public abstract class DbModelRepositoryStub<T extends DbModel> extends DbModelRepositoryImpl<T> {
	
	private long ID_GEN = 1000;
	private List<T> list = new ArrayList<>();

	@Override
	protected void setNewModelId(T model) {
		model.setId(ID_GEN);
		ID_GEN++;
	}

	@Override
	protected void insertModel(T model) {
		list.add(model);
	}

	@Override
	protected void updateModel(T current, T model) {
		int index = list.indexOf(current);
		if (index >= 0) {
			list.set(index, model);
		}
	}
	
	@Override
	public void deleteModel(long id) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		if (index >= 0) {
			list.remove(index);
		}
	}

	@Override
	public T getModel(long id) {
		for (T model : list) {
			if (model.getId() == id) {
				return model;
			}
		}
		return null;
	}

	@Override
	public Fetch<T> getModels(Collection<Long> ids) {
		Fetch<T> fetch = new Fetch<>(ids.size());
		for (T model : list) {
			if (ids.contains(model.getId())) {
				fetch.put(model.getId(), model);
			}
		}
		return fetch;
	}
	
	@Override
	public Fetch<T> getModels(Collection<Long> parentIds, String parentField) {
		Fetch<T> fetch = new Fetch<>(parentIds.size());
		for (T model : list) {
			if (parentIds.contains(getParentId(model, parentField))) {
				fetch.put(model.getId(), model);
			}
		}
		return fetch;
	}
	
	/**
	 * Returns the Parent ID for the given model.
	 * Also the parentField is provided for multiple parent search. 
	 * @param model model
	 * @param parentField support for multiple parent search
	 * @return parent ID
	 */
	protected long getParentId(T model, String parentField) {
		// for overriding
		return 0;
	}

	@Override
	public Fetch<T> getAllModels() {
		Fetch<T> fetch = new Fetch<>(list.size());
		for (T model : list) {
			fetch.put(model.getId(), model);
		}
		return fetch;
	}
	
	@Override
	protected long countModels(String query) {
		return search(query).size();
	}

	@Override
	protected Fetch<T> getModels(Paging<T> paging) {
		List<T> searchList = search(paging.getQuery());
		if (CollectionUtils.isEmpty(searchList)) {
			return new Fetch<>();
		}
		List<T> subList = searchList.subList((int) paging.getModelsStart() - 1, (int) paging.getModelsEnd());
		
		// create fetch object
		Fetch<T> fetch = new Fetch<>(searchList.size());
		for (T model : subList) {
			fetch.put(model.getId(), model);
		}
		return fetch;
	}

	private List<T> search(String query) {
		List<T> result = null;
		if (StringUtils.isBlank(query)) {
			result = list;
		} else {
			result = new ArrayList<>();
			for (T model : list) {
				if (searchModel(model, query)) {
					result.add(model);
				}
			}
		}
		return result;
	}

	/**
	 * Searches for the given query string in any attributes in the given model.
	 * @param model model to search in
	 * @param query query to search for
	 * @return true if the query exist in any model attribute
	 */
	protected boolean searchModel(T model, String query) {
		// for overriding
		return true;
	}

}
