package com.allaber.belltime.database.models;

public enum DayOfWeek {
    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6);

    private int value;

    private DayOfWeek(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
