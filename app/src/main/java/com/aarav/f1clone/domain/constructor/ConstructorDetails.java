package com.aarav.f1clone.domain.constructor;

public class ConstructorDetails {
    int driver1, driver2, fastest_lap, pole_positions;
    String logo, team_chief, team_color, car_image;

    public ConstructorDetails() {
    }

    public ConstructorDetails(int driver1, int driver2, int fastest_lap, int pole_positions, String logo, String team_chief, String team_color, String car_image) {
        this.driver1 = driver1;
        this.driver2 = driver2;
        this.fastest_lap = fastest_lap;
        this.pole_positions = pole_positions;
        this.logo = logo;
        this.team_chief = team_chief;
        this.team_color = team_color;
        this.car_image = car_image;
    }

    public String getCar_image() {
        return car_image;
    }

    public void setCar_image(String car_image) {
        this.car_image = car_image;
    }

    public int getDriver1() {
        return driver1;
    }

    public void setDriver1(int driver1) {
        this.driver1 = driver1;
    }

    public int getDriver2() {
        return driver2;
    }

    public void setDriver2(int driver2) {
        this.driver2 = driver2;
    }

    public int getFastest_lap() {
        return fastest_lap;
    }

    public void setFastest_lap(int fastest_lap) {
        this.fastest_lap = fastest_lap;
    }

    public int getPole_positions() {
        return pole_positions;
    }

    public void setPole_positions(int pole_positions) {
        this.pole_positions = pole_positions;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTeam_chief() {
        return team_chief;
    }

    public void setTeam_chief(String team_chief) {
        this.team_chief = team_chief;
    }

    public String getTeam_color() {
        return team_color;
    }

    public void setTeam_color(String team_color) {
        this.team_color = team_color;
    }
}
