package com.vcms.web.tag;

import com.vcms.localization.model.Language;
import com.vcms.localization.model.LocalText;

public class LocalTextTag extends AbstractLocalTag {

	private static final long serialVersionUID = -565416232726029825L;

	private LocalText value;

	@Override
	protected String generateResponseString(Language language) {
		if (value != null && value.hasText(language)) {
			return value.getText(language);
		}
		return "";
	}

	public LocalText getValue() {
		return value;
	}

	public void setValue(LocalText value) {
		this.value = value;
	}

}
