package com.vcms.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.vcms.localization.model.Language;

public final class Utils {
	
	private static final List<Long> TIMES = Arrays.asList(
			TimeUnit.DAYS.toMillis(365), 
			TimeUnit.DAYS.toMillis(30),
			TimeUnit.DAYS.toMillis(1), 
			TimeUnit.HOURS.toMillis(1), 
			TimeUnit.MINUTES.toMillis(1),
			TimeUnit.SECONDS.toMillis(1));
	private static final Map<Language, List<String>> TIMES_LOCAL_MAP = new HashMap<>();
	static {
		TIMES_LOCAL_MAP.put(Language.English,
				Arrays.asList("year", "month", "day", "hour", "minute", "second", "moment"));
		TIMES_LOCAL_MAP.put(Language.Macedonian,
				Arrays.asList("year", "month", "day", "hour", "minute", "second", "moment"));
	}
	
	private Utils() {
		// utility class
	}
	
	public static Date getDateFromString(String dateString) {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		try {
			return format.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date getDateTimeFromString(String dateString) {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		try {
			return format.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Set<T> asSet(T... objects) {
		Set<T> set = new HashSet<>();
		for (int i = 0; i < objects.length; i++) {
			set.add(objects[i]);
		}
		return set;
	}
	
	public static String toDuration(Date date, Language language) {
		long duration = System.currentTimeMillis() - date.getTime();
		List<String> localList = TIMES_LOCAL_MAP.get(language);
		
		// calculate
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < TIMES.size(); i++) {
			Long current = TIMES.get(i);
			long temp = duration / current;
			if (temp > 0) {
				result.append(temp);
				result.append(" ");
				result.append(localList.get(i));
				result.append(temp > 1 ? "s" : "");
				break;
			}
		}
		
		// moment ago
		if (result.length() == 0) {
			result.append(localList.get(localList.size() - 1));
		}
		result.append(" ago");
		
		// result
		return result.toString();
	}
	
}
