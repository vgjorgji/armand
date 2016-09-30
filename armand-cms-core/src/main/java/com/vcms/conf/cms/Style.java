package com.vcms.conf.cms;

public enum Style {
	Black("#fff", "#000", "#000", "#000", "#000"),
	BlackModern("#fff", "#000", "#333", "#000", "#000"),
	BlackLight("#fff", "#000", "#333", "#777", "#000");

	private String backgroundHex;
	private String header1Hex;
	private String header3Hex;
	private String paragraphHex;
	private String inputHex;
	
	private Style(String backgroundHex, 
			String header1Hex, 
			String header3Hex, 
			String paragraphHex, 
			String inputHex) {
		this.backgroundHex = backgroundHex;
		this.header1Hex = header1Hex;
		this.header3Hex = header3Hex;
		this.paragraphHex = paragraphHex;
		this.inputHex = inputHex;
	}
	
	public String getBackgroundHex() {
		return backgroundHex;
	}
	
	public String getHeader1Hex() {
		return header1Hex;
	}
	
	public String getHeader3Hex() {
		return header3Hex;
	}
	public String getParagraphHex() {
		return paragraphHex;
	}
	
	public String getInputHex() {
		return inputHex;
	}
}
