package com.aarav.f1clone.ui.details;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aarav.f1clone.R;
import com.aarav.f1clone.domain.driver.Driver;
import com.aarav.f1clone.ui.home.HomeViewModel;
import com.aarav.f1clone.ui.standings.StandingsViewModel;
import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class DriverDetailsActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ArrayList<Driver> driverArrayList;
    LinearLayout linearLayout, stats;
    GifImageView loader;
    ImageView driverImage, car_image;

    Boolean flag;

    TextView firstName, lastName, constructorName, line, position, wins, podiums, fastest_lap, constructor, driverNumber, birth, country, points, poles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_driver_details);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        );

        linearLayout = findViewById(R.id.linearLayout);
        stats = findViewById(R.id.stats);
        loader = findViewById(R.id.loader);

        firstName = findViewById(R.id.firstName);
        poles = findViewById(R.id.poles);
        lastName = findViewById(R.id.lastName);
        driverImage = findViewById(R.id.driverImage);
        constructorName = findViewById(R.id.constructorName);
        line = findViewById(R.id.line);
        points = findViewById(R.id.points);
        position = findViewById(R.id.position);
        wins = findViewById(R.id.wins);
        podiums = findViewById(R.id.podiums);
        fastest_lap = findViewById(R.id.fastest_lap);
        constructor = findViewById(R.id.constructor);
        driverNumber = findViewById(R.id.permanentNumber);
        car_image = findViewById(R.id.carImage);
        birth = findViewById(R.id.dob);
        country = findViewById(R.id.country);

        flag = true;


        firebaseDatabase = FirebaseDatabase.getInstance();

        HomeViewModel viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        driverArrayList = new ArrayList<>();

        if(flag){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    loader.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.VISIBLE);
                    stats.setVisibility(View.VISIBLE);
                    flag = false;
                }
            }, 500);
        }

        int number;
        String id, driverFirstName, driverLastName, codeName, date, driverWins, driverPoints, driverPosition, nation;

        if(getIntent().getBooleanExtra("flag", true)){
             id = getIntent().getStringExtra("driverId");
             number = getIntent().getIntExtra("driverNumber", 0);
             nation = getIntent().getStringExtra("nationality");
             driverFirstName = getIntent().getStringExtra("driverFirstName");
            driverLastName = getIntent().getStringExtra("driverLastName");
             codeName = getIntent().getStringExtra("code");
             date = getIntent().getStringExtra("dob");
             driverWins = getIntent().getStringExtra("wins");
             driverPoints = getIntent().getStringExtra("points");
             driverPosition = getIntent().getStringExtra("position");

             birth.setText(date);
             driverNumber.setText("" + number);
             points.setText(driverPoints + ""  + "PTS");

             firstName.setText(driverFirstName);
             lastName.setText(driverLastName);
             position.setText(driverPosition);
             wins.setText(driverWins);
             country.setText(nation);

             databaseReference = firebaseDatabase.getReference().child("drivers").child("" + number);

            Log.i("MYTAG", "" + number);
             databaseReference.addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(@NonNull DataSnapshot snapshot) {
                     int pod = snapshot.child("podiums").getValue(Integer.class);
                     podiums.setText("" + pod);
                     fastest_lap.setText(snapshot.child("fastestLap").getValue(Integer.class).toString());
                     constructorName.setText(snapshot.child("teamName").getValue(String.class));
                     constructor.setText(snapshot.child("teamName").getValue(String.class));
                     poles.setText(snapshot.child("poles").getValue(Integer.class).toString());

                     line.setBackgroundColor(Color.parseColor("#"+ snapshot.child("team_color").getValue(String.class)));

                     Glide.with(getApplicationContext()).load(snapshot.child("carImage").getValue(String.class)).into(car_image);
                     Glide.with(getApplicationContext()).load(snapshot.child("driverImage").getValue(String.class)).into(driverImage);

                 }

                 @Override
                 public void onCancelled(@NonNull DatabaseError error) {

                 }
             });



        }

        String driverId = getIntent().getStringExtra("driverId");
        int num = getIntent().getIntExtra("driverNumber", 0);
        String driverFirst = getIntent().getStringExtra("driverFirstName");
        String driverLast = getIntent().getStringExtra("driverLastName");
        String code = getIntent().getStringExtra("code");
        String nationality = getIntent().getStringExtra("nationality");
        String dob = getIntent().getStringExtra("dob");
        String dWins = getIntent().getStringExtra("wins");
        String dPoints = getIntent().getStringExtra("points");
        String dPosition = getIntent().getStringExtra("position");



        firstName.setText(driverFirst);
        lastName.setText(driverLast);
        position.setText(dPosition);
        //birth.setText(dob);
        points.setText(dPoints + " " + "PTS");
        wins.setText(dWins);
        driverNumber.setText("" + num);
        country.setText(nationality);


        databaseReference = firebaseDatabase.getReference().child("drivers").child("" + num);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                podiums.setText(snapshot.child("podiums").getValue(Integer.class).toString());
                fastest_lap.setText(snapshot.child("fastestLap").getValue(Integer.class).toString());
                constructorName.setText(snapshot.child("teamName").getValue(String.class));
                constructor.setText(snapshot.child("teamName").getValue(String.class));
                poles.setText(snapshot.child("poles").getValue(Integer.class).toString());

                line.setBackgroundColor(Color.parseColor("#"+ snapshot.child("team_color").getValue(String.class)));

                Glide.with(getApplicationContext()).load(snapshot.child("carImage").getValue(String.class)).into(car_image);
                Glide.with(getApplicationContext()).load(snapshot.child("driverImage").getValue(String.class)).into(driverImage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}