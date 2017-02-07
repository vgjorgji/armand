package com.vcms.utils;

import com.vcms.localization.model.Language;
import com.vcms.localization.model.LocalText;
import com.vcms.localization.model.LocalTextType;

public final class TextUtils {
	
	private TextUtils() {
		// utility class
	}
	
	public static LocalText createLocalTextSmall(String enText, String mkText) {
		return createLocalText(LocalTextType.Small, enText, mkText);
	}
	
	public static LocalText createLocalText(LocalTextType type, String enText, String mkText) {
		LocalText localText = new LocalText(type);
		localText.addText(Language.English, enText);
		localText.addText(Language.Macedonian, mkText);
		return localText;
	}
	
}
