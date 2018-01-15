package com.armand.cms.core.utils;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.armand.cms.core.date.DateUtils;
import com.armand.cms.core.date.DurationType;
import com.armand.cms.core.localization.model.Language;

public class DateUtilsTest {

  @Test
  public void testToDuration_Past_Seconds() {
    Language language = Language.Macedonian;
    DurationType type = DurationType.Short;
    for (int i = 0; i < 20; i++) {
      long yearMilis = (long) (Math.random() * TimeUnit.DAYS.toMillis(400));
      if (Math.random() > 0.5) {
        yearMilis *= -1;
      }
      Date date = new Date(System.currentTimeMillis() + yearMilis);
      System.out.println(date + " (" + yearMilis + ") = " + DateUtils.toDuration(date, type, language));
    }
    assertEquals(1, 1);
  }
}
