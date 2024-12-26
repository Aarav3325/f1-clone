package com.aarav.f1clone.ui.raceinfo;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aarav.f1clone.R;
import com.aarav.f1clone.data.RaceAdapter;
import com.aarav.f1clone.databinding.FragmentRaceBinding;
import com.aarav.f1clone.domain.race.Race;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class RaceFragment extends Fragment {

    private RaceViewModel mViewModel;
    private FragmentRaceBinding binding;
    private ArrayList<Race> raceArrayList;
    private RaceAdapter raceAdapter;
    private GifImageView loader;

    public static RaceFragment newInstance() {
        return new RaceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentRaceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel = new ViewModelProvider(this).get(RaceViewModel.class);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);


        mViewModel.getRaces().observe(getViewLifecycleOwner(), new Observer<List<Race>>() {
            @Override
            public void onChanged(List<Race> races) {
                raceArrayList = (ArrayList<Race>) races;


                if(!raceArrayList.isEmpty()){
                    binding.loader.setVisibility(View.GONE);
                    binding.recyclerView.setVisibility(View.VISIBLE);

                }

                ArrayList<Race> reversed = new ArrayList<>();

                for(int i = raceArrayList.size()-1; i >= 0; i--){
                    reversed.add(raceArrayList.get(i));
                }


                raceAdapter = new RaceAdapter(reversed, getActivity().getApplicationContext());
                binding.recyclerView.setAdapter(raceAdapter);
            }
        });



        return root;
    }


}