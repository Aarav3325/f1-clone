package com.aarav.f1clone.domain.race;

public class DateAndTime {
    String date;
    String time;

    public DateAndTime(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public DateAndTime() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
