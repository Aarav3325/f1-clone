package com.aarav.f1clone.domain.constructor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ConstructorTable {
//    public String season;
    @SerializedName("Constructors")
    @Expose
    public ArrayList<Constructor> Constructors;

    public ArrayList<Constructor> getConstructors() {
        return Constructors;
    }

    public void setConstructors(ArrayList<Constructor> constructors) {
        Constructors = constructors;
    }
}
