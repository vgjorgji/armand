package com.armand.cms.web.tag;

import java.util.Date;

import com.armand.cms.core.date.Age;
import com.armand.cms.core.date.DateUtils;
import com.armand.cms.core.localization.model.Language;

public class LocalDurationTag extends AbstractLocalTag {

	private static final long serialVersionUID = 73474696228743778L;

	private Date value;

	@Override
	protected String generateResponseString(Language language) {
		if (value != null) {
			Age age = DateUtils.toAge(value, language);
			return age.getDuration();
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
