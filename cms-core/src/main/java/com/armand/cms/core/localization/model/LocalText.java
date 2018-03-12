package com.armand.cms.core.localization.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.armand.cms.core.persist.model.DbModel;
import com.armand.cms.core.validation.CmsException;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class LocalText extends DbModel {

  private Map<Language, LocalTextValue> texts = new LinkedHashMap<>();
  private LocalTextType type;

  public LocalText() {
    // default constructor for JSON deserialize
  }

  public LocalText(LocalTextType type) {
    this.type = type;
  }

  @JsonIgnore
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

  @JsonIgnore
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

  public List<LocalTextValue> getTexts() {
    return Arrays.stream(Language.values())
        .map(language -> texts.get(language))
        .collect(Collectors.toList());
  }

  public void setTexts(List<LocalTextValue> texts) {
    texts.forEach(text -> addText(text.getLanguage(), text.getValue()));
  }
}
