package com.armand.cms.core.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.armand.cms.core.localization.model.Language;

public final class DateUtils {

  private static final Map<Boolean, String> DurationMomentEnglish = new HashMap<>();
  private static final Map<Boolean, String> DurationMomentMacedonian = new HashMap<>();
  private static final Map<Language, Map<Boolean, String>> DurationMoment = new HashMap<>();

  private static final Map<Boolean, String> DurationPrefixEnglish = new HashMap<>();
  private static final Map<Boolean, String> DurationPrefixMacedonian = new HashMap<>();
  private static final Map<Language, Map<Boolean, String>> DurationPrefix = new HashMap<>();

  private static final Map<Boolean, String> DurationPostfixEnglish = new HashMap<>();
  private static final Map<Boolean, String> DurationPostfixMacedonian = new HashMap<>();
  private static final Map<Language, Map<Boolean, String>> DurationPostfix = new HashMap<>();

  private static final Map<DurationUnit, String> DurationTypeEnglish = new HashMap<>();
  private static final Map<DurationUnit, String> DurationTypeMacedonian = new HashMap<>();
  private static final Map<Language, Map<DurationUnit, String>> DurationTypeAll = new HashMap<>();

  static {
    DurationMoment.put(Language.English, DurationMomentEnglish);
    DurationMoment.put(Language.Macedonian, DurationMomentMacedonian);
    DurationPrefix.put(Language.English, DurationPrefixEnglish);
    DurationPrefix.put(Language.Macedonian, DurationPrefixMacedonian);
    DurationPostfix.put(Language.English, DurationPostfixEnglish);
    DurationPostfix.put(Language.Macedonian, DurationPostfixMacedonian);
    DurationTypeAll.put(Language.English, DurationTypeEnglish);
    DurationTypeAll.put(Language.Macedonian, DurationTypeMacedonian);

    DurationMomentEnglish.put(Boolean.TRUE, "a moment ago");
    DurationMomentEnglish.put(Boolean.FALSE, "now");
    DurationMomentMacedonian.put(Boolean.TRUE, "сега");
    DurationMomentMacedonian.put(Boolean.FALSE, "сега");

    DurationPrefixEnglish.put(Boolean.TRUE, "");
    DurationPrefixEnglish.put(Boolean.FALSE, "");
    DurationPrefixMacedonian.put(Boolean.TRUE, "пред ");
    DurationPrefixMacedonian.put(Boolean.FALSE, "уште ");

    DurationPostfixEnglish.put(Boolean.TRUE, "ago");
    DurationPostfixEnglish.put(Boolean.FALSE, "remaining");
    DurationPostfixMacedonian.put(Boolean.TRUE, "");
    DurationPostfixMacedonian.put(Boolean.FALSE, "");

    DurationTypeEnglish.put(DurationUnit.Year, "years");
    DurationTypeEnglish.put(DurationUnit.Month, "months");
    DurationTypeEnglish.put(DurationUnit.Day, "days");
    DurationTypeEnglish.put(DurationUnit.Hour, "hours");
    DurationTypeEnglish.put(DurationUnit.Minute, "minutes");
    DurationTypeEnglish.put(DurationUnit.Second, "seconds");

    DurationTypeMacedonian.put(DurationUnit.Year, "години");
    DurationTypeMacedonian.put(DurationUnit.Month, "месеци");
    DurationTypeMacedonian.put(DurationUnit.Day, "денови");
    DurationTypeMacedonian.put(DurationUnit.Hour, "часа");
    DurationTypeMacedonian.put(DurationUnit.Minute, "минути");
    DurationTypeMacedonian.put(DurationUnit.Second, "секунди");
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
    countdown.setDuration(toDuration(date, DurationType.Long, language));

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
    age.setDuration(toDuration(date, DurationType.Short, language));

    // result
    return age;
  }

  public static String toDuration(Date date, DurationType type, Language language) {
    // time
    long time = System.currentTimeMillis() - date.getTime();
    boolean positive = time >= 0;

    // text
    StringBuilder duration = new StringBuilder();

    // calculate
    DurationUnit[] units = DurationUnit.values();
    for (int i = 0; i < units.length; i++) {
      DurationUnit unit = units[i];

      long value = time / unit.getMillis();
      if (value != 0) {

        if (type.isDurationUnitSupported(unit)) {
          duration.append(Math.abs(value));
          duration.append(" ");
          duration.append(DurationTypeAll.get(language).get(unit));
          duration.append(" ");

          if (DurationType.Short == type) {
            break;
          } else if (DurationType.Long == type) {
            // continue
          }
        }

        // decrees time
        if (DurationType.Long == type) {
          time = time - (value * units[i].getMillis());
        }
      }
    }

    // empty duration case
    StringBuilder durationFinal = new StringBuilder();
    if (duration.length() > 0) {
      durationFinal.append(DurationPrefix.get(language).get(positive));
      durationFinal.append(duration.toString());
      durationFinal.append(DurationPostfix.get(language).get(positive));
    } else {
      durationFinal.append(DurationMoment.get(language).get(positive));
    }

    // result
    return durationFinal.toString();
  }

}
