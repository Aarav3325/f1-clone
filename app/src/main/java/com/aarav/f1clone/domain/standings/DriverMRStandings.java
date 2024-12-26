package com.aarav.f1clone.domain.standings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverMRStandings {

    @SerializedName("StandingsTable")
    @Expose
    public StandingTable standingsTable;

    public DriverMRStandings() {
    }

    public StandingTable getStandingsTable() {
        return standingsTable;
    }

    public void setStandingsTable(StandingTable standingsTable) {
        this.standingsTable = standingsTable;
    }
}
