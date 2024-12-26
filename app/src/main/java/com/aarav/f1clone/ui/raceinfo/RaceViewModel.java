package com.aarav.f1clone.ui.raceinfo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aarav.f1clone.data.Repository;
import com.aarav.f1clone.domain.race.Race;

import java.util.List;

public class RaceViewModel extends AndroidViewModel {

    private Repository repository;

    public RaceViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public MutableLiveData<List<Race>> getRaces(){
        return repository.getRaces();
    }
}