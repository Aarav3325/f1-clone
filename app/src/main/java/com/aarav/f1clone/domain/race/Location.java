package com.aarav.f1clone.domain.race;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("locality")
    @Expose
    public String locality;
    @SerializedName("country")
    @Expose
    public String country;


    public Location() {
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
