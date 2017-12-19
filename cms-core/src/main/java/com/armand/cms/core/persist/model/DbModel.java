package com.armand.cms.core.persist.model;

public abstract class DbModel {
	
	private long id = 0;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "[id=" + id + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DbModel) {
			return id == ((DbModel) obj).getId();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Long.valueOf(id).hashCode();
	}
	
}
