package com.aarav.f1clone.domain.standings;

import com.aarav.f1clone.domain.constructor.Constructor;
import com.aarav.f1clone.domain.driver.Driver;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DriverStanding {
    @SerializedName("position")
    @Expose
    public String position;
    @SerializedName("points")
    @Expose
    public String points;
    @SerializedName("wins")
    @Expose
    public String wins;
    @SerializedName("Driver")
    @Expose
    public Driver driver;
    @SerializedName("Constructors")
    @Expose
    public ArrayList<Constructor> constructors;

    public DriverStanding() {
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

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public ArrayList<Constructor> getConstructors() {
        return constructors;
    }

    public void setConstructors(ArrayList<Constructor> constructors) {
        this.constructors = constructors;
    }
}
