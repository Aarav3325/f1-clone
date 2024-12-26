package com.aarav.f1clone.ui.standings;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aarav.f1clone.data.DriverStandingAdapter;
import com.aarav.f1clone.databinding.FragmentDriversStandingBinding;
import com.aarav.f1clone.domain.standings.DriverStanding;
import com.aarav.f1clone.ui.details.ConstructorDetailsActivity;
import com.aarav.f1clone.ui.details.DriverDetailsActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DriversStandingFragment extends Fragment {

   FragmentDriversStandingBinding binding;
   ArrayList<DriverStanding> driverStandings;

    public DriversStandingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentDriversStandingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);

        StandingsViewModel viewModel = new ViewModelProvider(this).get(StandingsViewModel.class);

        binding.first.setVisibility(View.GONE);

        //binding.line.setBackgroundColor(Color.parseColor("#"+"000000"));

        viewModel.getDriverStandings().observe(getViewLifecycleOwner(), new Observer<List<DriverStanding>>() {
            @Override
            public void onChanged(List<DriverStanding> driverStandingList) {
                driverStandings = (ArrayList<DriverStanding>) driverStandingList;
                for (DriverStanding driverStanding : driverStandings) {
                    Log.i("STANDINGS_D_CALL", driverStanding.getDriver().getGivenName());
                }

                int permanentNumber = driverStandings.get(0).getDriver().getPermanentNumber();
                String driverFirstName = driverStandings.get(0).getDriver().getGivenName();
                String driverLastName = driverStandings.get(0).getDriver().getFamilyName();
                String driverId = driverStandings.get(0).getDriver().getDriverId();
                String dob = driverStandings.get(0).getDriver().getDateOfBirth().toString();
                String code = driverStandings.get(0).getDriver().getCode();
                Log.i("MYTAG", "" + permanentNumber);
                String wins = driverStandings.get(0).getWins();
                String points = driverStandings.get(0).getPoints();
                String position = driverStandings.get(0).getPosition();
                String nationality = driverStandings.get(0).getDriver().getNationality();


                if(driverStandings.isEmpty()){
                    binding.first.setVisibility(View.GONE);
                }
                else {
                    binding.winningConstructor.setText(driverStandings.get(0).getDriver().getFullName());
                    binding.winningPoints.setText(driverStandings.get(0).getPoints());


                    binding.first.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(v.getContext(), DriverDetailsActivity.class);
                            intent.putExtra("flag", true);
                            intent.putExtra("driverNumber", 1);
                            intent.putExtra("wins", wins);
                            intent.putExtra("points", points);
                            intent.putExtra("position", position);
                            intent.putExtra("driverFirstName", driverFirstName);
                            intent.putExtra("driverLastName", driverLastName);
                            intent.putExtra("code", code);
                            intent.putExtra("dob", dob);
                            intent.putExtra("driverId", driverId);
                            intent.putExtra("nationality", nationality);
                            startActivity(intent);
                        }
                    });

                    driverStandings.remove(0);
                    binding.first.setVisibility(View.VISIBLE);

                }





                DriverStandingAdapter adapter = new DriverStandingAdapter(getActivity().getApplicationContext(), driverStandings);
                binding.recyclerView.setAdapter(adapter);
            }
        });

        return root;
    }
}