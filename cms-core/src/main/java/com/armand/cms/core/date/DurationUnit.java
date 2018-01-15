package com.armand.cms.core.date;

import java.util.concurrent.TimeUnit;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DurationUnit {
  Year(TimeUnit.DAYS.toMillis(365)),
  Month(TimeUnit.DAYS.toMillis(30)),
  Day(TimeUnit.DAYS.toMillis(1)),
  Hour(TimeUnit.HOURS.toMillis(1)),
  Minute(TimeUnit.MINUTES.toMillis(1)),
  Second(TimeUnit.SECONDS.toMillis(1));

  private long millis;

}
