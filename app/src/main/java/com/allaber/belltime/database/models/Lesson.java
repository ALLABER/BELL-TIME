package com.allaber.belltime.database.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Lesson implements Comparable<Lesson>{

    @PrimaryKey(autoGenerate = true)
    public long id;

    private String lessonName;
    private String roomNumber;
    private String teacherName;
    private String dayOfWeek;
    private long startTime;
    private long endTime;

    public Lesson() {
    }

    public Lesson(String lessonName, String roomNumber, String teacherName, String dayOfWeek, long startTime, long endTime) {
        this.lessonName = lessonName;
        this.roomNumber = roomNumber;
        this.teacherName = teacherName;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Lesson u) {
        Long startTime = getStartTime();
        Long startTimeU = u.getStartTime();
        return startTime.compareTo(startTimeU);
    }
}