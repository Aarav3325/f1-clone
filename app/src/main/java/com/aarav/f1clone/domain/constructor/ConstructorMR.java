package com.aarav.f1clone.domain.constructor;

import com.google.gson.annotations.SerializedName;

public class ConstructorMR {
    @SerializedName("ConstructorTable")
    public com.aarav.f1clone.domain.constructor.ConstructorTable ConstructorTable;

    public com.aarav.f1clone.domain.constructor.ConstructorTable getConstructorTable() {
        return ConstructorTable;
    }

    public void setConstructorTable(com.aarav.f1clone.domain.constructor.ConstructorTable constructorTable) {
        ConstructorTable = constructorTable;
    }
}
