package com.aarav.f1clone.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.aarav.f1clone.domain.constructor.Constructor;
import com.aarav.f1clone.domain.driver.Driver;
import com.aarav.f1clone.data.Repository;
import com.aarav.f1clone.domain.standings.DriverStanding;

import java.io.IOException;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    Repository repository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public MutableLiveData<List<Driver>> getDriversList() throws IOException {
        return repository.getDriversList();
    }

    public MutableLiveData<List<Constructor>> getConstructorLists() throws IOException {
        return repository.getConstructorLists();
    }

    public MutableLiveData<List<DriverStanding>> getDriverStandings() throws IOException {
        return repository.getDriverStandingsMTLD();

    }

}