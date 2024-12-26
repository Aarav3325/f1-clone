package com.aarav.f1clone.domain.standings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RootStandings {
    @SerializedName("MRData")
    @Expose
    public MRStanding MRData;

    public RootStandings() {
    }

    public MRStanding getMRData() {
        return MRData;
    }

    public void setMRData(MRStanding MRData) {
        this.MRData = MRData;
    }
}
