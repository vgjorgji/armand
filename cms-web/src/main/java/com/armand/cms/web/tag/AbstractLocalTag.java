package com.armand.cms.web.tag;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.user.service.UserSettingsProvider;

public abstract class AbstractLocalTag extends TagSupport {

	private static final long serialVersionUID = 6901427202646867498L;

	@Override
	public int doStartTag() {
		try {
			// user settings language
			Language language = UserSettingsProvider.getCurrentUser().getLanguage();

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
