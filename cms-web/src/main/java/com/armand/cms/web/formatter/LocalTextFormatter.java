package com.armand.cms.web.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.user.service.UserSettingsProvider;

@Component
public class LocalTextFormatter implements Formatter<LocalText> {

  @Override
  public LocalText parse(String s, Locale locale) throws ParseException {
    // not needed
    return null;
  }

  @Override
  public String print(LocalText localText, Locale locale) {
    String result = "";
    if (localText != null) {
      Language language = UserSettingsProvider.getCurrentUser().getLanguage();
      if (localText.hasText(language)) {
        result = localText.getText(language);
      }
    }
    return result;
  }
}
