package com.aarav.f1clone.domain.race;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Race {
    @SerializedName("raceName")
    @Expose
    public String raceName;
    @SerializedName("Circuit")
    @Expose
    public Circuit circuit;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("time")
    @Expose
    public String time;

    @SerializedName("round")
    @Expose
    public String round;

    @SerializedName("FirstPractice")
    @Expose
    public DateAndTime firstPractice;

    @SerializedName("SecondPractice")
    @Expose
    public DateAndTime secondPractice;

    @SerializedName("ThirdPractice")
    @Expose
    public DateAndTime ThirdPractice;

    @SerializedName("Qualifying")
    @Expose
    public DateAndTime qualifying;

    public Race() {
    }

    public DateAndTime getFirstPractice() {
        return firstPractice;
    }

    public void setFirstPractice(DateAndTime firstPractice) {
        this.firstPractice = firstPractice;
    }

    public DateAndTime getSecondPractice() {
        return secondPractice;
    }

    public void setSecondPractice(DateAndTime secondPractice) {
        this.secondPractice = secondPractice;
    }

    public DateAndTime getThirdPractice() {
        return ThirdPractice;
    }

    public void setThirdPractice(DateAndTime thirdPractice) {
        ThirdPractice = thirdPractice;
    }

    public DateAndTime getQualifying() {
        return qualifying;
    }

    public void setQualifying(DateAndTime qualifying) {
        this.qualifying = qualifying;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
