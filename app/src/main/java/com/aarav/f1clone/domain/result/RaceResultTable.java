package com.aarav.f1clone.domain.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RaceResultTable {
    @SerializedName("season")
    @Expose
    public String season;
    @SerializedName("Races")
    @Expose
    public ArrayList<RaceResult> races;

    public RaceResultTable() {
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public ArrayList<RaceResult> getRaces() {
        return races;
    }

    public void setRaces(ArrayList<RaceResult> races) {
        this.races = races;
    }
}
