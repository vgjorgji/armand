package com.vcms.date;

public class Duration {
	
	private String textShort;
	private String textLong;
	
	public String getTextShort() {
		return textShort;
	}
	
	public void setTextShort(String textShort) {
		this.textShort = textShort;
	}
	
	public String getTextLong() {
		return textLong;
	}
	
	public void setTextLong(String textLong) {
		this.textLong = textLong;
	}

	@Override
	public String toString() {
		return "Duration [textShort=" + textShort + ", textLong=" + textLong + "]";
	}
	
}
