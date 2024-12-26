package com.aarav.f1clone.ui.raceinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.aarav.f1clone.data.FragmentAdapter;
import com.aarav.f1clone.databinding.FragmentNotificationsBinding;
import com.aarav.f1clone.domain.standings.ConstructorStandings;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class RaceInfoFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    private ArrayList<ConstructorStandings> constructorStandingsList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RaceInfoViewModel notificationsViewModel =
                new ViewModelProvider(this).get(RaceInfoViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getActivity().getSupportFragmentManager(), getLifecycle());

        fragmentAdapter.addFragment(new RaceFragment());
        fragmentAdapter.addFragment(new SprintFragment());

        binding.viewPager.setAdapter(fragmentAdapter);
        binding.viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0){
                    tab.setText("Race");

                }else{
                    tab.setText("Sprint");
                }
            }
        }).attach();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}