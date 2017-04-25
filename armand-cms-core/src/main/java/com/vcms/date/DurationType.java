package com.vcms.date;

import java.util.concurrent.TimeUnit;

public enum DurationType {
	Year(TimeUnit.DAYS.toMillis(365), true),
	Month(TimeUnit.DAYS.toMillis(30), true),
	Day(TimeUnit.DAYS.toMillis(1), true),
	Hour(TimeUnit.HOURS.toMillis(1), false),
	Minute(TimeUnit.MINUTES.toMillis(1), false),
	Second(TimeUnit.SECONDS.toMillis(1), false);

	private long millis;
	private boolean partOfLongText;
	
	private DurationType(long millis, boolean partOfLongText) {
		this.millis = millis;
		this.partOfLongText = partOfLongText;
	}

	public long getMillis() {
		return millis;
	}

	public boolean isPartOfLongText() {
		return partOfLongText;
	}
	
}
