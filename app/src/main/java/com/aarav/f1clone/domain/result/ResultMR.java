package com.aarav.f1clone.domain.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultMR{
    @SerializedName("RaceTable")
    @Expose
    public RaceResultTable raceResultTable;

    public ResultMR() {
    }

    public RaceResultTable getRaceResultTable() {
        return raceResultTable;
    }

    public void setRaceResultTable(RaceResultTable raceResultTable) {
        this.raceResultTable = raceResultTable;
    }
}
