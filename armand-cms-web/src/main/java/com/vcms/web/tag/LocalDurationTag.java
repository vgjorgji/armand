package com.vcms.web.tag;

import java.util.Date;

import com.vcms.date.Age;
import com.vcms.date.DateUtils;
import com.vcms.localization.model.Language;

public class LocalDurationTag extends AbstractLocalTag {

	private static final long serialVersionUID = 73474696228743778L;

	private Date value;

	@Override
	protected String generateResponseString(Language language) {
		if (value != null) {
			Age age = DateUtils.toAge(value, language);
			return age.getDuration().getTextShort();
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
