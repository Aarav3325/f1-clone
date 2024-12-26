package com.aarav.f1clone.domain.driver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DriverTable {
    @SerializedName("Drivers")
    @Expose
    public List<Driver> Drivers;

    public DriverTable() {
    }


    public List<Driver> getDriver() {
        return Drivers;
    }

    public void setDriver(List<Driver> driver) {
        Drivers = driver;
    }


}
