package com.aarav.f1clone.domain.result;

import com.google.gson.annotations.Expose;

public class AverageSpeed{
    @Expose
    public String units;
    @Expose
    public String speed;

    public AverageSpeed(String units, String speed){
        this.units = units;
        this.speed = speed;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
