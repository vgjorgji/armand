package com.armand.cms.core.website.model;

import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.armand.cms.core.conf.CmsPackage;
import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.persist.model.HistoryModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Website extends HistoryModel {

  private long companyId;
  private String name;
  private String baseUrl;
  private CmsPackage cmsPackage;
  private List<Language> languages;
  private WebsiteStatus status;
  private Date expiryDate;

  public Language getPrimaryLanguage() {
    if (!CollectionUtils.isEmpty(languages)) {
      return languages.get(0);
    }
    return null;
  }

  @JsonFormat(shape = Shape.STRING, pattern = "dd.MM.yyyy")
  public Date getExpiryDate() {
    return expiryDate;
  }

}
