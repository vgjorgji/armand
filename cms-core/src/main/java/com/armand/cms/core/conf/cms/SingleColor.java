package com.armand.cms.core.conf.cms;

public enum SingleColor {
	White("#fff"),
	LightGrayBlue("#eee"),
	VeryLightGray("#f1f1f1");
	
	private String hex;
	
	private SingleColor(String hex) {
		this.hex = hex;
	}
	
	public String getHex() {
		return hex;
	}
}
