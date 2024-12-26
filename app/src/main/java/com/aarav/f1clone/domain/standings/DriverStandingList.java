package com.aarav.f1clone.domain.standings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DriverStandingList {
    @SerializedName("season")
    @Expose
    public String season;
    @SerializedName("round")
    @Expose
    public String round;
    @SerializedName("DriverStandings")
    @Expose
    public ArrayList<DriverStanding> driverStandings;

    public DriverStandingList() {
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public ArrayList<DriverStanding> getDriverStandings() {
        return driverStandings;
    }

    public void setDriverStandings(ArrayList<DriverStanding> driverStandings) {
        this.driverStandings = driverStandings;
    }
}

