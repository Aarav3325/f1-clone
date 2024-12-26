package com.aarav.f1clone.domain.constructor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConstructorRoot {

    @SerializedName("MRData")
    @Expose
    public ConstructorMR mRData;

    public ConstructorMR getmRData() {
        return mRData;
    }

    public void setmRData(ConstructorMR mRData) {
        this.mRData = mRData;
    }
}
