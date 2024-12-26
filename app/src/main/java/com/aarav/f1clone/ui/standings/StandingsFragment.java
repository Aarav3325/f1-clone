package com.aarav.f1clone.ui.standings;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aarav.f1clone.R;
import com.aarav.f1clone.domain.standings.ConstructorStandings;

import java.util.ArrayList;

public class StandingsFragment extends Fragment {

    private StandingsViewModel mViewModel;
    private ArrayList<ConstructorStandings> constructorStandingsList;

    public static StandingsFragment newInstance() {
        return new StandingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_standings, container, false);

        CardView driver = view.findViewById(R.id.driver_standings);
        CardView constructor = view.findViewById(R.id.constructor_standings);

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_standings_to_driversStandingFragment);
            }
        });

        constructor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_standings_to_constructorsStandingFragment);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(StandingsViewModel.class);
        // TODO: Use the ViewModel
    }

}