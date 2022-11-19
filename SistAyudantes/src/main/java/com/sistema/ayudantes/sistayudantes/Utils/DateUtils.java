package com.sistema.ayudantes.sistayudantes.Utils;

import java.util.Date;
import java.util.Calendar;

public class DateUtils {

  public static Date addHoursToJavaUtilDate(Date date, int hours) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.HOUR_OF_DAY, hours);
    return calendar.getTime();
  }

  public static Date addMinutesToJavaUtilDate(Date date, int minutes) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      calendar.add(Calendar.MINUTE, minutes);
      return calendar.getTime();
  }

  public static Date addSecondsToJavaUtilDate(Date date, int seconds) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      calendar.add(Calendar.SECOND, seconds);
      return calendar.getTime();
  }
}
