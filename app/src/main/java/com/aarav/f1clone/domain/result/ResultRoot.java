package com.aarav.f1clone.domain.result;

import com.aarav.f1clone.domain.race.RaceMR;
import com.google.gson.annotations.SerializedName;

public class ResultRoot {
        @SerializedName("MRData")
        public ResultMR mRData;

        public ResultRoot() {
        }

    public ResultMR getmRData() {
        return mRData;
    }

    public void setmRData(ResultMR mRData) {
        this.mRData = mRData;
    }
}
