package com.vcms.utils;

import java.util.Date;

import com.vcms.design.model.CmsPage;
import com.vcms.localization.model.LocalTextType;
import com.vcms.persist.model.HistoryModel;

public final class StubUtils {
	
	private StubUtils() {
		// utility class
	}
	
	public static <T extends HistoryModel> T createStubDbModel(T dbModel, long id) {
		dbModel.setId(id);
		dbModel.setCreatedBy("ROOT");
		dbModel.setCreatedDate(new Date());
		dbModel.setChangedBy(dbModel.getCreatedBy());
		dbModel.setChangedDate(dbModel.getCreatedDate());
		return dbModel;
	}
	
	public static <T extends CmsPage> T createPageReadMore(T page) {
		page.setTitle(TextUtils.createLocalText(LocalTextType.Normal, "Read More", "Прочитај Повеќе"));
		page.setUrl("/");
		return page;
	}

}
