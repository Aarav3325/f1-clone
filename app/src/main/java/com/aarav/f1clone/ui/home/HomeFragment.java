package com.aarav.f1clone.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aarav.f1clone.domain.constructor.Constructor;
import com.aarav.f1clone.domain.driver.Driver;
import com.aarav.f1clone.data.MyAdapter;
import com.aarav.f1clone.databinding.FragmentHomeBinding;
import com.aarav.f1clone.domain.standings.DriverStanding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private ArrayList<Driver> driverArrayList;
    private ArrayList<Constructor> constructorArrayList;
    private ArrayList<DriverStanding> driverStandings;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);


//        try {
//
//            homeViewModel.getDriversList().observe(getViewLifecycleOwner(), new Observer<List<Driver>>() {
//
//                @Override
//                public void onChanged(List<Driver> drivers) {
//
//                    //driverArrayList.clear();
//                    Log.i("MYTAG", "WORK");
//                    driverArrayList = (ArrayList<Driver>) drivers;
//                    for (Driver driver : driverArrayList) {
//                        Log.i("MYTAG", driver.getDriverId());
//                    }
//
//                    myAdapter = new MyAdapter(driverArrayList, getContext());
//                    binding.recyclerView.setAdapter(myAdapter);
//                }
//            });
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            homeViewModel.getConstructorLists().observe(getViewLifecycleOwner(), new Observer<List<Constructor>>() {
//
//                @Override
//                public void onChanged(List<Constructor> constructors) {
////                    Log.i("MYTAG", "WORK");
////                    constructorArrayList.clear();
//                    constructorArrayList = (ArrayList<Constructor>) constructors;
//                    for (Constructor c : constructorArrayList) {
//                        Log.i("MYTAG", c.getName());
//                    }
//
////                    myAdapter = new MyAdapter(driverArrayList, getContext());
////                    binding.recyclerView.setAdapter(myAdapter);
//                }
//            });
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try {
           homeViewModel.getDriverStandings().observe(getViewLifecycleOwner(), new Observer<List<DriverStanding>>() {
               @Override
               public void onChanged(List<DriverStanding> driverStandingList) {
                   driverStandings = (ArrayList<DriverStanding>) driverStandingList;
                   for (DriverStanding driverStanding : driverStandings) {
                       Log.i("STANDINGS_D_CALL", driverStanding.getDriver().getGivenName());
                   }
               }
           });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}