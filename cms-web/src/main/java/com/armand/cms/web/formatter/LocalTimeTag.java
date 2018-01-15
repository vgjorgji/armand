package com.armand.cms.web.formatter;

import java.util.Date;

import com.armand.cms.core.localization.model.Language;

public class LocalTimeTag extends AbstractLocalTag {

  private static final long serialVersionUID = 6628008416042868526L;

  private Date value;

  @Override
  protected String generateResponseString(Language language) {
    if (value != null) {
      return "HH:mm";  //DateFormatUtils.format(value, "HH:mm", language.getLocale());
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
