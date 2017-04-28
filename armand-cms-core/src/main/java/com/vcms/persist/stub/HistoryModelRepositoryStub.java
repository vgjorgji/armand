package com.vcms.persist.stub;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.vcms.persist.model.HistoryModel;
import com.vcms.persist.model.Paging;
import com.vcms.persist.repo.HistoryModelRepositoryImpl;

public abstract class HistoryModelRepositoryStub<T extends HistoryModel> extends HistoryModelRepositoryImpl<T> {

	private List<T> list = new ArrayList<>();

	@Override
	protected void setNewModelId(T model) {
		model.setId(list.size() + 1000L);
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
	public void deleteModel(T model) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == model.getId()) {
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
	public List<T> getModels(Collection<Long> ids) {
		List<T> result = new ArrayList<>(ids.size());
		for (T model : list) {
			if (ids.contains(model.getId())) {
				result.add(model);
			}
		}
		return result;
	}

	@Override
	public List<T> getAllModels() {
		return list;
	}
	
	@Override
	protected long countModels(String query) {
		return search(query).size();
	}
	
	@Override
	protected List<T> getModels(Paging<T> paging) {
		List<T> searchList = search(paging.getQuery());
		return searchList.subList((int) paging.getModelsStart() - 1, (int) paging.getModelsEnd());
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
	protected abstract boolean searchModel(T model, String query);

}
