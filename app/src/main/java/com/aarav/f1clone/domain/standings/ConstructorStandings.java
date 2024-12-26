package com.aarav.f1clone.domain.standings;

import com.aarav.f1clone.domain.constructor.Constructor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConstructorStandings {
    @SerializedName("position")
    @Expose
    public String position;
    @SerializedName("points")
    @Expose
    public String points;
    @SerializedName("wins")
    @Expose
    public String wins;
    @SerializedName("Constructor")
    @Expose
    public Constructor constructor;

    public ConstructorStandings() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }
}
