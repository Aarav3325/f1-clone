package com.aarav.f1clone.domain.driver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("MRData")
    @Expose
    private com.aarav.f1clone.domain.driver.MRData MRData;


    public com.aarav.f1clone.domain.driver.MRData getMRData() {
        return MRData;
    }


    public void setMRData(MRData MRData) {
        this.MRData = MRData;
    }
}
