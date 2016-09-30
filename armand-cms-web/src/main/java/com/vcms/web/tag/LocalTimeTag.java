package com.vcms.web.tag;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.vcms.localization.model.Language;

public class LocalTimeTag extends AbstractLocalTag {
	
	private static final long serialVersionUID = 6628008416042868526L;
	
	private Date value;
	
	@Override
	protected String generateResponseString(Language language) {
		if (value != null) {
			return DateFormatUtils.format(value, "HH:mm", language.getLocale());
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
