package com.vcms.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.vcms.localization.model.Language;
import com.vcms.user.service.UserSettingsProvider;

public abstract class AbstractLocalTag extends TagSupport {

	private static final long serialVersionUID = 6901427202646867498L;

	@Override
	public int doStartTag() throws JspException {
		try {
			// user settings language
			Language language = UserSettingsProvider.getCurrentUser().getLanguage();
			if (language == null) {
				language = Language.English;
			}

			// context writer
			JspWriter out = pageContext.getOut();
			out.print(generateResponseString(language));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	protected abstract String generateResponseString(Language language);

}
