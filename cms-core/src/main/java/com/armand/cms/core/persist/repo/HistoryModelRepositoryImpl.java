package com.armand.cms.core.persist.repo;

import java.util.Date;

import com.armand.cms.core.persist.model.HistoryModel;
import com.armand.cms.core.persist.model.HistoryModelRepository;
import com.armand.cms.core.user.model.UserSettings;
import com.armand.cms.core.user.service.UserSettingsProvider;

public abstract class HistoryModelRepositoryImpl<T extends HistoryModel>
    extends DbModelRepositoryImpl<T>
    implements HistoryModelRepository<T> {

  @Override
  protected void interceptBeforeInsertModel(T model) {
    UserSettings userSettings = UserSettingsProvider.getCurrentUserRelax();
    model.setCreatedBy(userSettings != null ? userSettings.toStringUser() : "unknown");
    model.setCreatedDate(new Date());
    model.setChangedBy(model.getCreatedBy());
    model.setChangedDate(model.getCreatedDate());
    model.setVersion(0);
  }

  @Override
  protected void interceptBeforeUpdateModel(T current, T model) {
    UserSettings userSettings = UserSettingsProvider.getCurrentUserRelax();
    model.setChangedBy(userSettings != null ? userSettings.toStringUser() : "unknown");
    model.setChangedDate(new Date());
    model.setVersion(model.getVersion() + 1);
  }

  @Override
  protected void merge(T current, T model) {
    model.setCreatedBy(current.getCreatedBy());
    model.setCreatedDate(current.getCreatedDate());
    model.setVersion(current.getVersion());
  }

}
