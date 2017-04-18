package com.vcms.persist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class DbModel {
	
	private long id = 0;
	private DbModelState state = DbModelState.NEW;  // persistence
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonIgnore
	public DbModelState getState() {
		return state;
	}
	
	public void setState(DbModelState state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "[id=" + id + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HistoryModel) {
			return Long.valueOf(id).equals(((HistoryModel) obj).getId());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Long.valueOf(id).hashCode();
	}
	
}
