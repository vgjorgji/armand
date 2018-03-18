package com.armand.cms.core.utils;

import java.util.Date;

import com.armand.cms.core.design.model.Page;
import com.armand.cms.core.localization.model.LocalTextType;
import com.armand.cms.core.persist.model.HistoryModel;

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

  public static <T extends Page> T createPageReadMore(T page) {
    page.setTitle(TextUtils.createLocalText(LocalTextType.Normal, "Read More", "Прочитај Повеќе"));
    page.setUrl("/");
    return page;
  }

}
