package com.aarav.f1clone.domain.driver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Driver {
    @SerializedName("permanentNumber")
    @Expose
    public int permanentNumber;
    @SerializedName("givenName")
    @Expose
    public String givenName;
    @SerializedName("familyName")
    @Expose
    public String familyName;
    @SerializedName("dateOfBirth")
    @Expose
    public Date dateOfBirth;
    @SerializedName("nationality")
    @Expose
    public String nationality;
    @SerializedName("driverId")
    @Expose
    public String driverId;
    @SerializedName("code")
    @Expose
    public String code;

    public String fullName;

    public Driver() {
    }

    public String getFullName() {
        return givenName + " " + familyName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPermanentNumber() {
        return permanentNumber;
    }

    public void setPermanentNumber(int permanentNumber) {
        this.permanentNumber = permanentNumber;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
