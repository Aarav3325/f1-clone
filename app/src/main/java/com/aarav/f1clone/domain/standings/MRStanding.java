package com.aarav.f1clone.domain.standings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MRStanding {

        @SerializedName("StandingsTable")
        @Expose
        public StandingsTable StandingsTable;

    public MRStanding() {

    }

    public StandingsTable getStandingsTable() {
        return StandingsTable;
    }

    public void setStandingsTable(StandingsTable StandingsTable) {
        this.StandingsTable = StandingsTable;
    }
}
