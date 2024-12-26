package com.aarav.f1clone.domain.driver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MRData {

    @SerializedName("DriverTable")
    @Expose
    public com.aarav.f1clone.domain.driver.DriverTable DriverTable;

    public MRData() {
    }

    public com.aarav.f1clone.domain.driver.DriverTable getDriverTable() {
        return DriverTable;
    }

    public void setDriverTable(com.aarav.f1clone.domain.driver.DriverTable driverTable) {
        DriverTable = driverTable;
    }
}
