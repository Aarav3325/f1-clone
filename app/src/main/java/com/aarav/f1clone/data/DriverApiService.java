package com.aarav.f1clone.data;

import com.aarav.f1clone.domain.constructor.ConstructorRoot;
import com.aarav.f1clone.domain.driver.Data;
import com.aarav.f1clone.domain.race.RaceRoot;
import com.aarav.f1clone.domain.standings.RootDStandings;
import com.aarav.f1clone.domain.standings.RootStandings;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DriverApiService {

    @GET("ergast/f1/2024/drivers/?format=json")
    Call<Data> getDriversList();

    @GET("ergast/f1/2024/constructors/?format=json")
    Call<ConstructorRoot> getConstructorsList();

    @GET("ergast/f1/2024/constructorstandings/?format=json")
    Call<RootStandings> getConstructorStandings();

    @GET("ergast/f1/2024/driverstandings/?format=json")
    Call<RootDStandings> getDriverStandings();

    @GET("ergast/f1/2024/races/?format=json")
    Call<RaceRoot> getRaces();
}
