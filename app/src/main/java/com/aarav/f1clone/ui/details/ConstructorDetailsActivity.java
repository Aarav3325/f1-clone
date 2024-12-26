package com.aarav.f1clone.ui.details;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.aarav.f1clone.R;
import com.aarav.f1clone.databinding.ActivityConstructorDetailsBinding;
import com.aarav.f1clone.domain.constructor.ConstructorDetails;
import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.droidsonroids.gif.GifImageView;

public class ConstructorDetailsActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference, driver1Reference, driver2Reference;
    Drawable drawable;
    private ImageView logo, car_image, driver1, driver2;

    int driver1_key, driver2_key;
    int wd1, wd2;
    private View pointBg;
    LinearLayout linearLayout, stats;
    GifImageView loader;
    TextView driver2Name, driver1Name, poles, laps, position, points, wins, constructorName, hashtag, line, nationalityConstructor, team_chief;

    private ActivityConstructorDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_constructor_details);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        );


        firebaseDatabase = FirebaseDatabase.getInstance();

        nationalityConstructor = findViewById(R.id.nationality);
        team_chief = findViewById(R.id.team_chief);

        pointBg = findViewById(R.id.pointsBg);
        linearLayout = findViewById(R.id.linearLayout);
        stats = findViewById(R.id.stats);
        loader = findViewById(R.id.loader);

        linearLayout.setVisibility(View.GONE);
        stats.setVisibility(View.GONE);
        loader.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loader.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                stats.setVisibility(View.VISIBLE);
            }
        }, 500);

        driver1Name = findViewById(R.id.driver1Name);
        driver2Name = findViewById(R.id.driver2Name);

        car_image = findViewById(R.id.car_image);


         logo = findViewById(R.id.logo);
         line = findViewById(R.id.line);
         poles = findViewById(R.id.poles);
         laps = findViewById(R.id.fastest_lap);
         position = findViewById(R.id.position);
         points = findViewById(R.id.points);
         wins = findViewById(R.id.wins);
         constructorName = findViewById(R.id.constructorName);
         hashtag = findViewById(R.id.hashtag);

         driver1 = findViewById(R.id.driver1);
         driver2 = findViewById(R.id.driver2);

        String id = getIntent().getStringExtra("constructorId");
        String constructorWins = getIntent().getStringExtra("wins");
        String constructorPoints = getIntent().getStringExtra("points");
        String constructorPosition = getIntent().getStringExtra("position");
        String name = getIntent().getStringExtra("constructorName");
        String nationality = getIntent().getStringExtra("nationality");

        String firstId, winningConstructorWins, winningConstructorPoints, winningConstructorPosition, winningConstructorName, winningConstructorNationality;

        if(getIntent().getBooleanExtra("flag", true)){
             firstId = getIntent().getStringExtra("constructorId");
             Log.i("MYTAG", "ConstructorId: " + firstId);
             winningConstructorWins = getIntent().getStringExtra("wins");
             winningConstructorPoints = getIntent().getStringExtra("points");
             winningConstructorPosition = getIntent().getStringExtra("position");
             winningConstructorName = getIntent().getStringExtra("constructorName");
             winningConstructorNationality = getIntent().getStringExtra("nationality");

            position.setText(winningConstructorPosition);
            points.setText(winningConstructorPoints + " " + "PTS");
            wins.setText(winningConstructorWins);
            constructorName.setText(winningConstructorName);
            hashtag.setText("#" + winningConstructorName);


            databaseReference = firebaseDatabase.getReference().child("constructors").child(firstId);

             databaseReference.addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(@NonNull DataSnapshot snapshot) {


                     Glide.with(getApplicationContext()).load(snapshot.child("car_image").getValue(String.class)).into(car_image);

                     wd1 = snapshot.child("driver_1").getValue(Integer.class);
//
                     driver1Reference = firebaseDatabase.getReference().child("drivers").child("" + wd1);

                     driver1Reference.addValueEventListener(new ValueEventListener() {
                         @Override
                         public void onDataChange(@NonNull DataSnapshot snapshot) {
                             String first = snapshot.child("givenName").getValue(String.class);
                             String last = snapshot.child("familyName").getValue(String.class);
                             driver1Name.setText(first + " " + last);
                             Log.i("MYTAG", "Driver1: " + snapshot.child("driverImage").getValue(String.class));
                             Glide.with(getApplicationContext()).load(snapshot.child("driverImage").getValue(String.class)).into(driver1);
                         }

                         @Override
                         public void onCancelled(@NonNull DatabaseError error) {

                         }
                     });




                     wd2 = snapshot.child("driver_2").getValue(Integer.class);
                     Log.i("MYTAG", "" + wd1);
                     driver2Reference = firebaseDatabase.getReference().child("drivers").child("" + wd2);

                     driver2Reference.addValueEventListener(new ValueEventListener() {
                         @Override
                         public void onDataChange(@NonNull DataSnapshot snapshot) {

                             String first = snapshot.child("givenName").getValue(String.class);
                             String last = snapshot.child("familyName").getValue(String.class);
                             driver2Name.setText(first + " " + last);
                               Glide.with(getApplicationContext()).load(snapshot.child("driverImage").getValue(String.class)).into(driver2);
                         }

                         @Override
                         public void onCancelled(@NonNull DatabaseError error) {

                         }
                     });

                     line.setBackgroundColor(Color.parseColor("#"+ snapshot.child("team_color").getValue(String.class)));

                     Glide.with(getApplicationContext()).load(snapshot.child("logo").getValue(String.class)).into(logo);

                 }

                 @Override
                 public void onCancelled(@NonNull DatabaseError error) {

                 }
             });



        }

//        Log.i("MYTAG", "ConstructorId: " + constructorId);

       //binding.position.setBackgroundResource(R.drawable.detail_card);


        position.setText(constructorPosition);
        points.setText(constructorPoints + " " + "PTS");
        wins.setText(constructorWins);
        constructorName.setText(name);
        hashtag.setText("#" + name);
        nationalityConstructor.setText(nationality);


        databaseReference = firebaseDatabase.getReference().child("constructors").child(id);

        drawable = ContextCompat.getDrawable(this, R.drawable.points_bg);
        drawable = DrawableCompat.wrap(drawable);




        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    ConstructorDetails constructorDetails = dataSnapshot.getValue(ConstructorDetails.class);
//                    if (constructorDetails != null){


                Glide.with(getApplicationContext()).load(snapshot.child("car_image").getValue(String.class)).into(car_image);

                driver1_key = snapshot.child("driver_1").getValue(Integer.class);
//
                driver1Reference = firebaseDatabase.getReference().child("drivers").child("" + driver1_key);

                driver1Reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Log.i("MYTAG", "Driver1: " + snapshot.child("driverImage").getValue(String.class));
                        Glide.with(getApplicationContext()).load(snapshot.child("driverImage").getValue(String.class)).into(driver1);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




                driver2_key = snapshot.child("driver_2").getValue(Integer.class);
                Log.i("MYTAG", "" + wd1);
                driver2Reference = firebaseDatabase.getReference().child("drivers").child("" + driver2_key);

                driver2Reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Glide.with(getApplicationContext()).load(snapshot.child("driverImage").getValue(String.class)).into(driver2);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                        //binding.nationality.setText(nationality);
//                Log.i("MYTAG", snapshot.child("pole_positions").getValue(Integer.class).toString());
                        poles.setText("" + snapshot.child("pole_positions").getValue(Integer.class));
                        laps.setText("" + snapshot.child("fastest_laps").getValue(Integer.class));
                        team_chief.setText("" + snapshot.child("team_chief").getValue(String.class));

                        //drawable.setTint(Color.parseColor("#"+ snapshot.child("team_color").getValue(String.class)));


                        line.setBackgroundColor(Color.parseColor("#"+ snapshot.child("team_color").getValue(String.class)));

                        Glide.with(getApplicationContext()).load(snapshot.child("logo").getValue(String.class)).into(logo);
                    //}
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}