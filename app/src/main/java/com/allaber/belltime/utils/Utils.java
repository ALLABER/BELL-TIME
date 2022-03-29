package com.allaber.belltime.utils;

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
}
