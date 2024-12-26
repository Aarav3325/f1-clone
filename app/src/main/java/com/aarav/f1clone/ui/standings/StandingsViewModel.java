package com.aarav.f1clone.ui.standings;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.aarav.f1clone.data.Repository;
import com.aarav.f1clone.domain.standings.ConstructorStandings;
import com.aarav.f1clone.domain.standings.DriverStanding;

import java.util.List;

public class StandingsViewModel extends AndroidViewModel {

    private Repository repository;

    public StandingsViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public MutableLiveData<List<ConstructorStandings>> getConstructorStandings(){
        return repository.getConstructorStandingsMTLD();
    }

    public MutableLiveData<List<DriverStanding>> getDriverStandings(){
        return repository.getDriverStandingsMTLD();
    }

}