package com.vcms.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.vcms.localization.model.Language;

public final class DateUtils {
	
	private static final Map<Boolean, String> DurationPrefixMacedonian = new HashMap<>();
	private static final Map<Boolean, String> DurationPrefixEnglish = new HashMap<>();
	private static final Map<Language, Map<Boolean, String>> DurationPrefix = new HashMap<>();
	
	private static final Map<Boolean, String> DurationPostfixMacedonian = new HashMap<>();
	private static final Map<Boolean, String> DurationPostfixEnglish = new HashMap<>();
	private static final Map<Language, Map<Boolean, String>> DurationPostfix = new HashMap<>();
	
	private static final Map<DurationType, String> DurationTypeMacedonian = new HashMap<>();
	private static final Map<DurationType, String> DurationTypeEnglish = new HashMap<>();
	private static final Map<Language, Map<DurationType, String>> DurationTypeAll = new HashMap<>();
	
	static {
		DurationPrefix.put(Language.English, DurationPrefixEnglish);
		DurationPrefix.put(Language.Macedonian, DurationPrefixMacedonian);
		DurationPostfix.put(Language.English, DurationPostfixEnglish);
		DurationPostfix.put(Language.Macedonian, DurationPostfixMacedonian);
		DurationTypeAll.put(Language.English, DurationTypeEnglish);
		DurationTypeAll.put(Language.Macedonian, DurationTypeMacedonian);
		
		DurationPrefixEnglish.put(Boolean.TRUE, "");
		DurationPrefixEnglish.put(Boolean.FALSE, "");
		DurationPrefixMacedonian.put(Boolean.TRUE, "пред ");
		DurationPrefixMacedonian.put(Boolean.FALSE, "уште ");
		
		DurationPostfixEnglish.put(Boolean.TRUE, "ago");
		DurationPostfixEnglish.put(Boolean.FALSE, "remaining");
		DurationPostfixMacedonian.put(Boolean.TRUE, "");
		DurationPostfixMacedonian.put(Boolean.FALSE, "");
		
		DurationTypeEnglish.put(DurationType.Year, "years");
		DurationTypeEnglish.put(DurationType.Month, "months");
		DurationTypeEnglish.put(DurationType.Day, "days");
		DurationTypeEnglish.put(DurationType.Hour, "hours");
		DurationTypeEnglish.put(DurationType.Minute, "minutes");
		DurationTypeEnglish.put(DurationType.Second, "seconds");
		
		DurationTypeMacedonian.put(DurationType.Year, "години");
		DurationTypeMacedonian.put(DurationType.Month, "месеци");
		DurationTypeMacedonian.put(DurationType.Day, "денови");
		DurationTypeMacedonian.put(DurationType.Hour, "часа");
		DurationTypeMacedonian.put(DurationType.Minute, "минути");
		DurationTypeMacedonian.put(DurationType.Second, "секунди");
	}
	
	private DateUtils() {
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
	
	public static Countdown toCountdown(Date date, Language language) {
		Countdown countdown = new Countdown();
		
		// duration
		countdown.setDuration(toDuration(date, language));
		
		// time
		long time = date.getTime() - System.currentTimeMillis();
		long days = time / TimeUnit.DAYS.toMillis(1);
		
		// calculate
		CountdownType[] countdowns = CountdownType.values();
		for (int i = 0; i < countdowns.length; i++) {
			if (days <= countdowns[i].getThreshold()) {
				countdown.setType(countdowns[i]);
				break;
			}
		}
		
		// result
		return countdown;
	}
	
	public static Age toAge(Date date, Language language) {
		Age age = new Age();
		
		// duration
		age.setDuration(toDuration(date, language));
		
		// result
		return age;
	}
	
	public static Duration toDuration(Date date, Language language) {
		// time
		long time = System.currentTimeMillis() - date.getTime();
		boolean positive = time >= 0;
		
		// prefix
		StringBuilder textShort = new StringBuilder(DurationPrefix.get(language).get(positive));
		StringBuilder textLong = new StringBuilder(DurationPrefix.get(language).get(positive));
		boolean shortPass = false;
		
		// calculate
		DurationType[] durations = DurationType.values();
		for (int i = 0; i < durations.length; i++) {
			
			long value = time / durations[i].getMillis();
			if (value != 0) {
				String textPart = Math.abs(value) + " " + DurationTypeAll.get(language).get(durations[i]) + " ";
				
				if (!shortPass) {
					textShort.append(textPart);
					shortPass = true;
				}
				
				if (!shortPass || durations[i].isPartOfLongText()) {
					textLong.append(textPart);
				} else {
					break;
				}
				
				// decrees time
				time = time - (value * durations[i].getMillis());
			}
		}
		
		// postfix
		textShort.append(DurationPostfix.get(language).get(positive));
		textLong.append(DurationPostfix.get(language).get(positive));
		
		// create
		Duration duration = new Duration();
		duration.setTextShort(textShort.toString());
		duration.setTextLong(textLong.toString());
		
		// result
		return duration;
	}
	
}
