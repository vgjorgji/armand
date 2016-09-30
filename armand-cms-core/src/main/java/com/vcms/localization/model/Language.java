package com.vcms.localization.model;

import java.util.Locale;

public enum Language {
	English("flag-usa", new Locale("en")),
	Macedonian("flag-macedonia", new Locale("mk"));
	
	private String flagCss;
	private Locale locale;
	
	private Language(String flagCss, Locale locale) {
		this.flagCss = flagCss;
		this.locale = locale;
	}
	
	public String getFlagCss() {
		return flagCss;
	}
	
	public Locale getLocale() {
		return locale;
	}
}
