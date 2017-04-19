package com.vcms.conf.cms;

public enum ModernColor {
	Turquoise("#1abc9c", "#ffffff"),
	GreenSea("#16a085", "#ffffff"),
	Emerald("#2ecc71", "#ffffff"),
	Nephritis("#27ae60", "#ffffff"),
	PeterRiver("#3498db", "#ffffff"),
	BelizeHole("#2980b9", "#ffffff"),
	Amethyst("#9b59b6", "#ffffff"),
	Wisteria("#8e44ad", "#ffffff"),
	WetAsphalt("#34495e", "#ffffff"),
	MidnightBlue("#2c3e50", "#ffffff"),
	SunFlower("#f1c40f", "#ffffff"),
	Orange("#f39c12", "#ffffff"),
	Carrot("#e67e22", "#ffffff"),
	Pumpkin("#d35400", "#ffffff"),
	Alizarin("#e74c3c", "#ffffff"),
	Pomegranate("#c0392b", "#ffffff"),
	Clouds("#ecf0f1", "#bdc3c7"),
	Silver("#bdc3c7", "#ffffff"),
	Concrete("#95a5a6", "#ffffff"),
	Asbestos("#7f8c8d", "#ffffff"),
	Deseartured("#2f374c", "#ffffff");
	
	private String backgroundHex;
	private String textHex;
	
	private ModernColor(String backgroundHex, String textHex) {
		this.backgroundHex = backgroundHex;
		this.textHex = textHex;
	}
	
	public String getId() {
		return name();
	}
	
	public String getBackgroundHex() {
		return backgroundHex;
	}
	
	public String getTextHex() {
		return textHex;
	}
}
