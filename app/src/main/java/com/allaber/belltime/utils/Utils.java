package com.allaber.belltime.utils;

import java.sql.Timestamp;

public class Utils {

    public static String getDayOfWeekByIndex(int value) {
        String dayOfWeek = "MONDAY";
        switch (value) {
            case 0:
                dayOfWeek = "MONDAY";
                break;
            case 1:
                dayOfWeek = "TUESDAY";
                break;
            case 2:
                dayOfWeek = "WEDNESDAY";
                break;
            case 3:
                dayOfWeek = "THURSDAY";
                break;
            case 4:
                dayOfWeek = "FRIDAY";
                break;
            case 5:
                dayOfWeek = "SATURDAY";
                break;
            case 6:
                dayOfWeek = "SUNDAY";
                break;
        }
        return dayOfWeek;
    }

    public static long convertTimeToLong(String time) {
        String formatter = "1998-12-03 " + time + ":00";
        Timestamp timestamp = Timestamp.valueOf(formatter);
        return timestamp.getTime();
    }

    public static String convertLongToTime(long time) {
        Timestamp timestamp = new Timestamp(time);
        String fullTime = timestamp.toString();
        String timeStr = fullTime.substring(11, 16);
        return timeStr;
    }
}
