package com.vcms.persist.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Fetch<T> {
	
	private Map<Long, Integer> idsMap;
	private List<T> models;
	
	public Fetch() {
		idsMap = new LinkedHashMap<>();
		models = new ArrayList<>();
	}
	
	public Fetch(int initialCapacity) {
		idsMap = new LinkedHashMap<>(initialCapacity);
		models = new ArrayList<>();
	}
	
	public boolean hasId(Long id) {
		return idsMap.containsKey(id);
	}
	
	public void put(Long id, T model) {
		idsMap.put(id, models.size());
		models.add(model);
	}
	
	public T getModel(Long id) {
		return models.get(idsMap.get(id));
	}
	
	public int getIndex(Long id) {
		return idsMap.get(id);
	}
	
	public int size() {
		return idsMap.size();
	}
	
	public boolean isEmpty() {
		return idsMap.isEmpty();
	}
	
	public List<T> getModels() {
		return models;
	}
	
	public List<Long> listIds() {
		List<Long> list = new ArrayList<>(size());
		for (Entry<Long, Integer> entry : idsMap.entrySet()) {
			list.add(entry.getKey());
		}
		return list;
	}

}
