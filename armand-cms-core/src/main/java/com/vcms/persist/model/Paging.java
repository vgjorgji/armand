package com.vcms.persist.model;

public class Paging {
	
	public static final int[] SIZES = new int[] { 10, 25, 50, 100 };

	private int page = 1;
	private int size = SIZES[0];
	private String search;
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getSearch() {
		return search;
	}
	
	public void setSearch(String search) {
		this.search = search;
	}
	
}
