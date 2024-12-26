package com.aarav.f1clone.domain.constructor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Constructor {
    @SerializedName("constructorId")
    @Expose
    public String constructorId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("nationality")
    @Expose
    public String nationality;

    public String getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}

