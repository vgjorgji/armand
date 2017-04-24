package com.vcms.persist.repo;

import java.util.Date;

import com.vcms.persist.model.HistoryModel;
import com.vcms.persist.model.HistoryModelRepository;
import com.vcms.user.model.UserSettings;
import com.vcms.user.service.UserSettingsProvider;

public abstract class HistoryModelRepositoryImpl<T extends HistoryModel> 
		extends DbModelRepositoryImpl<T>
		implements HistoryModelRepository<T> {

	@Override
	protected void interceptBeforeInsertModel(T model) {
		UserSettings userSettings = UserSettingsProvider.getCurrentUserRelax();
		model.setCreatedBy(userSettings != null ? userSettings.toStringUser() : "none");
		model.setCreatedDate(new Date());
		model.setChangedBy(model.getCreatedBy());
		model.setChangedDate(model.getCreatedDate());
		model.setVersion(0);
	}

	@Override
	protected void interceptBeforeUpdateModel(T current, T model) {
		UserSettings userSettings = UserSettingsProvider.getCurrentUserRelax();
		model.setChangedBy(userSettings != null ? userSettings.toStringUser() : "none");
		model.setChangedDate(new Date());
		model.setVersion(model.getVersion() + 1);
	}

}
