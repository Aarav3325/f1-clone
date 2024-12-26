package com.aarav.f1clone.ui.standings;

import android.content.Intent;
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

import com.aarav.f1clone.data.ConstructorStandingAdapter;
import com.aarav.f1clone.databinding.FragmentConstructorsStandingBinding;
import com.aarav.f1clone.domain.standings.ConstructorStandings;
import com.aarav.f1clone.ui.details.ConstructorDetailsActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ConstructorsStandingFragment extends Fragment {

    FragmentConstructorsStandingBinding binding;
    ArrayList<ConstructorStandings> constructorStandingsList;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    public ConstructorsStandingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentConstructorsStandingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        StandingsViewModel viewModel = new ViewModelProvider(this).get(StandingsViewModel.class);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);

        firebaseDatabase = FirebaseDatabase.getInstance();

//
//        binding.first.setVisibility(View.GONE);

        constructorStandingsList = new ArrayList<>();
        viewModel.getConstructorStandings().observe(getViewLifecycleOwner(), new Observer<List<ConstructorStandings>>() {
            @Override
            public void onChanged(List<ConstructorStandings> constructorStandings) {
                constructorStandingsList = (ArrayList<ConstructorStandings>) constructorStandings;

                String constructorId = constructorStandingsList.get(0).getConstructor().getConstructorId();
                String wins = constructorStandingsList.get(0).getWins();
                String points = constructorStandingsList.get(0).getPoints();
                String position = constructorStandingsList.get(0).getPosition();
                String constructorName = constructorStandingsList.get(0).getConstructor().getName();
                String nationality = constructorStandingsList.get(0).getConstructor().getNationality();

                if(constructorStandingsList.isEmpty()){
                    binding.linearLayout.setVisibility(View.GONE);
                }
                else {
                    binding.winningConstructor.setText(constructorStandingsList.get(0).getConstructor().getName());
                    binding.winningPoints.setText(constructorStandingsList.get(0).getPoints());

                    binding.first.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(), ConstructorDetailsActivity.class);
                            Log.i("FERRARI", constructorStandings.get(0).getConstructor().getConstructorId());
                            intent.putExtra("constructorId", constructorId);
                            intent.putExtra("wins", wins);
                            intent.putExtra("points", points);
                            intent.putExtra("position", position);
                            intent.putExtra("constructorName", constructorName);
                            intent.putExtra("nationality", nationality);
                            intent.putExtra("flag", true);
                            startActivity(intent);
                        }
                    });

//                    binding.first.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Intent intent = new Intent(getContext(), ConstructorDetailsActivity.class);
//                            intent.putExtra("constructorId", constructorStandingsList.get(0).getConstructor().getConstructorId());
//                            intent.putExtra("wins", constructorStandingsList.get(0).getWins());
//                            intent.putExtra("points", constructorStandingsList.get(0).getPoints());
//                            intent.putExtra("position", constructorStandingsList.get(0).getPosition());
//                            intent.putExtra("constructorName", constructorStandingsList.get(0).getConstructor().getName());
//                            intent.putExtra("nationality", constructorStandingsList.get(0).getConstructor().getNationality());
//                            startActivity(intent);
//                        }
//                    });
                     binding.loader.setVisibility(View.GONE);
                     binding.linearLayout.setVisibility(View.VISIBLE);
                }

                constructorStandingsList.remove(0);



                ConstructorStandingAdapter constructorStandingAdapter = new ConstructorStandingAdapter(getActivity().getApplicationContext(), constructorStandingsList);
                binding.recyclerView.setAdapter(constructorStandingAdapter);
                constructorStandingAdapter.notifyDataSetChanged();

            }
        });


        return root;
    }
}