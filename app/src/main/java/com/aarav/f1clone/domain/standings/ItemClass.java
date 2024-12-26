package com.aarav.f1clone.domain.standings;

public class ItemClass {
    private int viewType;
    private String position, constructorName, points, winningConstructor, winningPoints;

    public ItemClass(int viewType, String position, String constructorName, String points) {
        this.viewType = viewType;
        this.position = position;
        this.constructorName = constructorName;
        this.points = points;
    }

    public ItemClass(int viewType, String winningConstructor, String winningPoints) {
        this.viewType = viewType;
        this.winningConstructor = winningConstructor;
        this.winningPoints = winningPoints;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getConstructorName() {
        return constructorName;
    }

    public void setConstructorName(String constructorName) {
        this.constructorName = constructorName;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWinningConstructor() {
        return winningConstructor;
    }

    public void setWinningConstructor(String winningConstructor) {
        this.winningConstructor = winningConstructor;
    }

    public String getWinningPoints() {
        return winningPoints;
    }

    public void setWinningPoints(String winningPoints) {
        this.winningPoints = winningPoints;
    }
}
