package com.aarav.f1clone.domain.standings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StandingsLists {
    public String season;
    public String round;
    @SerializedName("ConstructorStandings")
    @Expose
    public ArrayList<ConstructorStandings> ConstructorStandings;

    public StandingsLists() {
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

    public ArrayList<ConstructorStandings> getConstructorStandings() {
        return ConstructorStandings;
    }

    public void setConstructorStandings(ArrayList<ConstructorStandings> ConstructorStandings) {
        this.ConstructorStandings = ConstructorStandings;
    }
}
