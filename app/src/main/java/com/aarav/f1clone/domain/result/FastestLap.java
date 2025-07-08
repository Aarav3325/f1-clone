package com.aarav.f1clone.domain.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FastestLap {
    @Expose
    public String rank;
    @Expose
    public String lap;
    @SerializedName("Time")
    @Expose
    public Time time;
    @SerializedName("AverageSpeed")
    @Expose
    public AverageSpeed averageSpeed;

    public FastestLap(String rank, String lap, Time time, AverageSpeed averageSpeed){
        this.rank = rank;
        this.lap = lap;
        this.time = time;
        this.averageSpeed = averageSpeed;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getLap() {
        return lap;
    }

    public void setLap(String lap) {
        this.lap = lap;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public AverageSpeed getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(AverageSpeed averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
}
