package com.aarav.f1clone.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aarav.f1clone.data.NewsAdapter;
import com.aarav.f1clone.domain.constructor.Constructor;
import com.aarav.f1clone.domain.driver.Driver;
import com.aarav.f1clone.data.MyAdapter;
import com.aarav.f1clone.databinding.FragmentHomeBinding;
import com.aarav.f1clone.domain.news.NewsDataModel;
import com.aarav.f1clone.domain.standings.DriverStanding;
import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ImageView topImage;
    private TextView topHeadline;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private ArrayList<Driver> driverArrayList;
    private ArrayList<Constructor> constructorArrayList;
    private ArrayList<DriverStanding> driverStandings;
    private ArrayList<NewsDataModel> newsArrayList;
    private LinearLayout linearLayout;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference, topStoriesReference;
    private NewsAdapter newsAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        binding.recyclerView.setLayoutManager(layoutManager);



        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("news");
        newsArrayList = new ArrayList<>();



        topStoriesReference = firebaseDatabase.getReference().child("top_stories");

        topStoriesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                NewsDataModel topStories = snapshot.getValue(NewsDataModel.class);
                Log.i("MYTAG", topStories.getHeadlines());
                binding.topHeadline.setText(topStories.getHeadlines());
                Glide.with(getActivity().getApplicationContext()).load(topStories.getNewsCoverImage()).into(binding.topImage);

                binding.linearLayout2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), NewsActivity.class);
                        intent.putExtra("topStoriesUrl", topStories.getUrl());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                newsArrayList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    NewsDataModel newsDataModel = dataSnapshot.getValue(NewsDataModel.class);
                    newsArrayList.add(newsDataModel);
                }

                newsAdapter = new NewsAdapter(newsArrayList, getContext());
                binding.recyclerView.setAdapter(newsAdapter);

                newsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        binding.recyclerView.setLayoutManager(layoutManager);


//        binding.webView.getSettings().setJavaScriptEnabled(true);
//        binding.webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                binding.webView.loadUrl("javascript:(function() { " +
//                        "document.getElementsByTagName('header')[0].style.display='none';" +
//                        "document.getElementsByTagName('footer')[0].style.display='none';" +
//                        "document.getElementsByClassName('message type-modal')[0].style.display='none';" +
//                        "})()");
//            }
//    });
//

//
//        binding.webView.loadUrl("https://www.formula1.com/en/latest/article/leclerc-singles-out-highlight-of-the-season-for-ferrari-as-he-hails-good-job.29IkDmospYVYW2diUyIlGL");


        //try {
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

//        try {
//           homeViewModel.getDriverStandings().observe(getViewLifecycleOwner(), new Observer<List<DriverStanding>>() {
//               @Override
//               public void onChanged(List<DriverStanding> driverStandingList) {
//                   driverStandings = (ArrayList<DriverStanding>) driverStandingList;
//                   for (DriverStanding driverStanding : driverStandings) {
//                       Log.i("STANDINGS_D_CALL", driverStanding.getDriver().getGivenName());
//                   }
//               }
//           });
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}