package com.armand.cms.web.formatter;

import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.user.service.UserSettingsProvider;

public abstract class AbstractLocalTag { // extends TagSupport {

  private static final long serialVersionUID = 6901427202646867498L;

  public int doStartTag() {
    // user settings language
    Language language = UserSettingsProvider.getCurrentUser().getLanguage();

    // context writer
//			JspWriter out = pageContext.getOut();
//			out.print(generateResponseString(language));
    return 0;
  }

  protected abstract String generateResponseString(Language language);

}
