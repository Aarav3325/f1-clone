package com.aarav.f1clone.domain.standings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RootDStandings {
    @SerializedName("MRData")
    @Expose
    public DriverMRStandings driverMRStandings;

    public RootDStandings() {
    }

    public DriverMRStandings getDriverMRStandings() {
        return driverMRStandings;
    }

    public void setDriverMRStandings(DriverMRStandings driverMRStandings) {
        this.driverMRStandings = driverMRStandings;
    }
}
