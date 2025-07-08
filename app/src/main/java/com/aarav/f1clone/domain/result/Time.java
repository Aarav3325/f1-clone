package com.aarav.f1clone.domain.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Time{
    @SerializedName("millis")
    @Expose
    public String millis;
    @SerializedName("time")
    @Expose
    public String time;

    public Time() {
    }

    public Time(String millis, String time) {
        this.millis = millis;
        this.time = time;
    }

    public String getMillis() {
        return millis;
    }

    public void setMillis(String millis) {
        this.millis = millis;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
