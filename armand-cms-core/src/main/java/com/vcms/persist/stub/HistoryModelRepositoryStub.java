package com.vcms.persist.stub;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.vcms.persist.model.HistoryModel;
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
	
	protected List<T> getList() {
		return list;
	}

}
