package com.armand.cms.core.localization.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.armand.cms.core.persist.model.DbModel;
import com.armand.cms.core.validation.CmsException;

public class LocalText extends DbModel {

  private LocalTextType type;
  private Map<Language, LocalTextValue> texts = new HashMap<Language, LocalTextValue>();

  public LocalText(LocalTextType type) {
    this.type = type;
  }

  public LocalTextType getType() {
    return type;
  }

  public void addText(Language language, String text) {
    LocalTextValue localTextValue = new LocalTextValue();
    localTextValue.setLanguage(language);
    localTextValue.setValue(text);
    addText(localTextValue);
  }

  public void addText(LocalTextValue localTextValue) {
    if (StringUtils.hasLength(localTextValue.getValue()) && localTextValue.getValue().length() > type.getSize()) {
      throw new CmsException(
          "Text has more characters then defined for " + type + " text. Allowed size is " + type.getSize());
    }
    // TODO check tags presence
    texts.put(localTextValue.getLanguage(), localTextValue);
  }

  public boolean isEmpty() {
    return texts.isEmpty();
  }

  public boolean hasText(Language language) {
    return texts.get(language) != null;
  }

  public String getText(Language language) {
    if (hasText(language)) {
      return texts.get(language).getValue();
    }
    return null;
  }

}
