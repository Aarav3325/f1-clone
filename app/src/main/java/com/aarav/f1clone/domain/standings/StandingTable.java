package com.aarav.f1clone.domain.standings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StandingTable {
    @SerializedName("season")
    @Expose
    public String season;
    @SerializedName("round")
    @Expose
    public String round;

    @SerializedName("StandingsLists")
    @Expose
    public ArrayList<DriverStandingList> standingsLists;


    public StandingTable() {
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

    public ArrayList<DriverStandingList> getStandingsLists() {
        return standingsLists;
    }

    public void setStandingsLists(ArrayList<DriverStandingList> standingsLists) {
        this.standingsLists = standingsLists;
    }
}
