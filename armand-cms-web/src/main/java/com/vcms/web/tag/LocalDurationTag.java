package com.vcms.web.tag;

import java.util.Date;

import com.vcms.localization.model.Language;
import com.vcms.utils.DateUtils;

public class LocalDurationTag extends AbstractLocalTag {

	private static final long serialVersionUID = 73474696228743778L;

	private Date value;

	@Override
	protected String generateResponseString(Language language) {
		if (value != null) {
			return DateUtils.toDuration(value, language);
		}
		return "";
	}

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

}
