package com.vcms.persist.model;

import java.util.List;

public class PagingResult<T extends DbModel> {
	
	private int page;
	private int pageCount;
	private int size;
	private long modelsStart;
	private long modelsEnd;
	private long modelsCount;
	private String query;
	private List<T> models;
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public boolean isPagePreviousEnabled() {
		return page > 1;
	}
	
	public boolean isPageNextEnabled() {
		return page < pageCount;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int[] getSizes() {
		return Paging.SIZES;
	}

	public long getModelsStart() {
		return modelsStart;
	}

	public void setModelsStart(long modelsStart) {
		this.modelsStart = modelsStart;
	}

	public long getModelsEnd() {
		return modelsEnd;
	}

	public void setModelsEnd(long modelsEnd) {
		this.modelsEnd = modelsEnd;
	}

	public long getModelsCount() {
		return modelsCount;
	}

	public void setModelsCount(long modelsCount) {
		this.modelsCount = modelsCount;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<T> getModels() {
		return models;
	}

	public void setModels(List<T> models) {
		this.models = models;
	}
	
}
