package com.vcms.persist.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Fetch<T> {
	
	private LinkedHashMap<Long, T> map;
	
	public Fetch() {
		map = new LinkedHashMap<>();
	}
	
	public Fetch(int initialCapacity) {
		map = new LinkedHashMap<>(initialCapacity);
	}
	
	public boolean containsKey(Long id) {
		return map.containsKey(id);
	}
	
	public void put(Long id, T model) {
		map.put(id, model);
	}
	
	public T getModel(Long id) {
		return map.get(id);
	}
	
	public int size() {
		return map.size();
	}
	
	public boolean isEmpty() {
		return map.isEmpty();
	}
	
	public Set<Entry<Long, T>> entries() {
		return map.entrySet();
	}
	
	public List<T> listModels() {
		List<T> list = new ArrayList<>(size());
		for (Entry<Long, T> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
	
	public List<Long> listIds() {
		List<Long> list = new ArrayList<>(size());
		for (Entry<Long, T> entry : map.entrySet()) {
			list.add(entry.getKey());
		}
		return list;
	}

}
