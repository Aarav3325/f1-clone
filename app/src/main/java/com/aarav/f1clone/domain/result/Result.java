package com.aarav.f1clone.domain.result;

import com.aarav.f1clone.domain.constructor.Constructor;
import com.aarav.f1clone.domain.driver.Driver;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @Expose
    public String number;
    @Expose
    public String position;
    @Expose
    public String points;
    @SerializedName("Driver")
    @Expose
    public Driver driver;
    @Expose
    @SerializedName("Constructor")
    public Constructor constructor;
    @Expose
    public String grid;
    @Expose
    public String laps;
    @Expose
    public String status;
    @SerializedName("Time")
    @Expose
    public Time time;
    @SerializedName("FastestLap")
    @Expose
    public FastestLap fastestLap;

    public Result() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public String getLaps() {
        return laps;
    }

    public void setLaps(String laps) {
        this.laps = laps;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public FastestLap getFastestLap() {
        return fastestLap;
    }

    public void setFastestLap(FastestLap fastestLap) {
        this.fastestLap = fastestLap;
    }
}
