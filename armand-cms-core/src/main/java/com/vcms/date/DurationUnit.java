package com.vcms.date;

import java.util.concurrent.TimeUnit;

public enum DurationUnit {
	Year(TimeUnit.DAYS.toMillis(365)),
	Month(TimeUnit.DAYS.toMillis(30)),
	Day(TimeUnit.DAYS.toMillis(1)),
	Hour(TimeUnit.HOURS.toMillis(1)),
	Minute(TimeUnit.MINUTES.toMillis(1)),
	Second(TimeUnit.SECONDS.toMillis(1));

	private long millis;
	
	private DurationUnit(long millis) {
		this.millis = millis;
	}

	public long getMillis() {
		return millis;
	}

}
