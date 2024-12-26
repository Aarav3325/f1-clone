package com.aarav.f1clone.data;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.aarav.f1clone.domain.constructor.Constructor;
import com.aarav.f1clone.domain.constructor.ConstructorRoot;
import com.aarav.f1clone.domain.constructor.ConstructorTable;
import com.aarav.f1clone.domain.driver.Data;
import com.aarav.f1clone.domain.driver.Driver;
import com.aarav.f1clone.domain.driver.DriverTable;
import com.aarav.f1clone.domain.race.Race;
import com.aarav.f1clone.domain.race.RaceMR;
import com.aarav.f1clone.domain.race.RaceRoot;
import com.aarav.f1clone.domain.race.RaceTable;
import com.aarav.f1clone.domain.standings.ConstructorStandings;
import com.aarav.f1clone.domain.standings.DriverMRStandings;
import com.aarav.f1clone.domain.standings.DriverStanding;
import com.aarav.f1clone.domain.standings.DriverStandingList;
import com.aarav.f1clone.domain.standings.MRStanding;
import com.aarav.f1clone.domain.standings.RootDStandings;
import com.aarav.f1clone.domain.standings.RootStandings;
import com.aarav.f1clone.domain.standings.StandingTable;
import com.aarav.f1clone.domain.standings.StandingsLists;
import com.aarav.f1clone.domain.standings.StandingsTable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    Application application;
    MutableLiveData<List<Driver>> mutableLiveData = new MutableLiveData<>();

    MutableLiveData<List<Constructor>> constructorMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<ConstructorStandings>> constructorStandingsMTLD = new MutableLiveData<>();
    MutableLiveData<List<DriverStanding>> driversStandingsMTLD = new MutableLiveData<>();
    MutableLiveData<List<Race>> raceMutableLiveData = new MutableLiveData<>();

    public Repository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Driver>> getDriversList(){
        DriverApiService driverApiService = RetrofitInstance.getService();


        Call<Data> call = driverApiService.getDriversList();

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                Data data = response.body();
                Log.i("MYTAG", "NOT");

                if(data != null && data.getMRData() != null){
                    Log.i("MYTAG", "WORKING");
                    DriverTable driverTable = data.getMRData().getDriverTable();
                    List<Driver> drivers =  driverTable.getDriver();
                    mutableLiveData.postValue(drivers);
                }

            }

            @Override
            public void onFailure(Call<Data> call, Throwable throwable) {

            }
        });

        return mutableLiveData;
    }

    public MutableLiveData<List<Constructor>> getConstructorLists(){
        DriverApiService driverApiService = RetrofitInstance.getService();


        Call<ConstructorRoot> call = driverApiService.getConstructorsList();

        call.enqueue(new Callback<ConstructorRoot>() {
            @Override
            public void onResponse(Call<ConstructorRoot> call, Response<ConstructorRoot> response) {

                ConstructorRoot data = response.body();


                if(data != null && data.getmRData() != null){
                    Log.i("MYTAG", "WORKING");
                    ConstructorTable constructorTable = data.getmRData().getConstructorTable();
                    List<Constructor> constructors =  constructorTable.getConstructors();
                    constructorMutableLiveData.postValue(constructors);

                    for (Constructor constructor : constructors) {
                        Log.i("MYTAG", "Constructor Name: " + constructor.getName());
                    }
                }

            }

            @Override
            public void onFailure(Call<ConstructorRoot> call, Throwable throwable) {

            }
        });

        return constructorMutableLiveData;
    }

    public MutableLiveData<List<ConstructorStandings>> getConstructorStandingsMTLD(){
        DriverApiService driverApiService = RetrofitInstance.getService();

        Call<RootStandings> call = driverApiService.getConstructorStandings();

        call.enqueue(new Callback<RootStandings>() {
            @Override
            public void onResponse(Call<RootStandings> call, Response<RootStandings> response) {
                RootStandings rootStandings = response.body();
                if(rootStandings == null){
                    Log.i("MYTAG", "NOT WORKING");
                }
                else {
                    Log.i("MYTAG", "WORKING");
                }


                if(rootStandings != null && rootStandings.getMRData() != null){
                    MRStanding mrStanding = rootStandings.getMRData();
                    if(mrStanding.getStandingsTable() != null){
                        StandingsTable standingsTable = mrStanding.getStandingsTable();
//                        Log.i("MYTAG", standingsTable.getSeason());
                        ArrayList<StandingsLists> standingsList = standingsTable.getStandingsLists();
//                        if(standingsList.isEmpty()){
//                            Log.i("MYTAG", standingsList.toString());
//                        }
                        List<ConstructorStandings> constructorStandings = standingsList.get(0).getConstructorStandings();
                        constructorStandingsMTLD.postValue(constructorStandings);

                        for (ConstructorStandings constructorStanding : constructorStandings) {
                            Log.i("MYTAG", "Constructor Name: " + constructorStanding.getPosition());
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<RootStandings> call, Throwable throwable) {

            }
        });

        return  constructorStandingsMTLD;
    }

    public MutableLiveData<List<DriverStanding>> getDriverStandingsMTLD(){
        DriverApiService driverApiService = RetrofitInstance.getService();

        Call<RootDStandings> call = driverApiService.getDriverStandings();

        call.enqueue(new Callback<RootDStandings>() {
            @Override
            public void onResponse(Call<RootDStandings> call, Response<RootDStandings> response) {
                RootDStandings rootStandings = response.body();
                if(rootStandings == null){
                    Log.i("MYTAG", "NOT WORKING");
                }
                else {
                    Log.i("MYTAG", "WORKING");
                }


                if(rootStandings != null && rootStandings.getDriverMRStandings() != null){
                    DriverMRStandings mrStanding = rootStandings.getDriverMRStandings();
                    if(mrStanding.getStandingsTable() != null){
                        StandingTable standingsTable = mrStanding.getStandingsTable();
//                        Log.i("MYTAG", standingsTable.getSeason());
                        ArrayList<DriverStandingList> standingsList = standingsTable.getStandingsLists();
//                        if(standingsList.isEmpty()){
//                            Log.i("MYTAG", standingsList.toString());
//                        }
                        List<DriverStanding> driverStandings = standingsList.get(0).getDriverStandings();
                        driversStandingsMTLD.postValue(driverStandings);

                        for (DriverStanding constructorStanding : driverStandings) {
                            Log.i("MYTAG", "Constructor Name: " + constructorStanding.getPoints());
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<RootDStandings> call, Throwable throwable) {

            }
        });

        return driversStandingsMTLD;

    }

    public MutableLiveData<List<Race>> getRaces(){
        DriverApiService driverApiService = RetrofitInstance.getService();

        Call<RaceRoot> call = driverApiService.getRaces();

        call.enqueue(new Callback<RaceRoot>() {
            @Override
            public void onResponse(Call<RaceRoot> call, Response<RaceRoot> response) {
                RaceRoot raceRoot = response.body();

                if(raceRoot != null && raceRoot.getmRData() != null){
                    RaceMR raceMR = raceRoot.getmRData();
                    if(raceMR.getRaceTable() != null){
                        RaceTable raceTable = raceMR.getRaceTable();
                        if(raceTable != null){
                            List<Race> raceList = raceTable.getRaces();
                            raceMutableLiveData.postValue(raceList);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<RaceRoot> call, Throwable throwable) {

            }
        });

        return raceMutableLiveData;
    }


}
