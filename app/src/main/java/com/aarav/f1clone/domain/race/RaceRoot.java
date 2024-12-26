package com.aarav.f1clone.domain.race;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RaceRoot {
    @SerializedName("MRData")
    @Expose
    public RaceMR mRData;

    public RaceRoot() {
    }

    public RaceMR getmRData() {
        return mRData;
    }

    public void setmRData(RaceMR mRData) {
        this.mRData = mRData;
    }
}
