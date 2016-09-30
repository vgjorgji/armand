package com.vcms.localization.model;

public enum LocalTextType {
	Small(100),
	Normal(255),
	Large(1000),
	Rich(2000);
	
	private int size;
	
	private LocalTextType(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
}
