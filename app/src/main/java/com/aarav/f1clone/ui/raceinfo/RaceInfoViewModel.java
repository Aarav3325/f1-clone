package com.aarav.f1clone.ui.raceinfo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.aarav.f1clone.data.Repository;
import com.aarav.f1clone.domain.standings.ConstructorStandings;

import java.util.List;

public class RaceInfoViewModel extends AndroidViewModel {

    private Repository repository;

    public RaceInfoViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }
    // TODO: Implement the ViewModel

    public MutableLiveData<List<ConstructorStandings>> getConstructorStandings(){
        return repository.getConstructorStandingsMTLD();
    }
}