package com.aarav.f1clone.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aarav.f1clone.R;
import com.aarav.f1clone.domain.standings.ConstructorStandings;
import com.aarav.f1clone.domain.standings.DriverStanding;
import com.aarav.f1clone.ui.details.ConstructorDetailsActivity;
import com.aarav.f1clone.ui.details.DriverDetailsActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DriverStandingAdapter extends RecyclerView.Adapter<DriverStandingAdapter.MyViewHolder>{
    private Context context;
    private static ArrayList<DriverStanding> driverStandingsList;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

    public DriverStandingAdapter(Context context, ArrayList<DriverStanding> driverStandingsList) {
        this.context = context;
        this.driverStandingsList = driverStandingsList;
        this.firebaseDatabase = FirebaseDatabase.getInstance();
        this.databaseReference = firebaseDatabase.getReference().child("drivers");
    }


    @NonNull
    @Override
    public DriverStandingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.driver_standing_card, parent, false);

        return new DriverStandingAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverStandingAdapter.MyViewHolder holder, int position) {

        DriverStanding driverStanding = driverStandingsList.get(position);


        holder.position.setText(String.valueOf(driverStanding.getPosition()));
        holder.driverName.setText("" + driverStanding.getDriver().getFullName());
        holder.points.setText("" + driverStanding.getPoints());

        databaseReference.child("" + driverStanding.getDriver().getPermanentNumber()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                holder.line.setBackgroundColor(Color.parseColor("#" + snapshot.child("team_color").getValue(String.class)));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return driverStandingsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView position, driverName, driver1, driver2, points, line;
        CardView root;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            position = itemView.findViewById(R.id.position);
            driverName = itemView.findViewById(R.id.driverName);
            points = itemView.findViewById(R.id.points);
            line = itemView.findViewById(R.id.line);

            root = itemView.findViewById(R.id.root);

            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    DriverStanding driverStanding = driverStandingsList.get(position);
                    Intent intent = new Intent(v.getContext(), DriverDetailsActivity.class);
                    intent.putExtra("driverNumber", driverStanding.getDriver().getPermanentNumber());
                    intent.putExtra("wins", driverStanding.getWins());
                    intent.putExtra("points", driverStanding.getPoints());
                    intent.putExtra("position", driverStanding.getPosition());
                    intent.putExtra("driverFirstName", driverStanding.getDriver().getGivenName());
                    intent.putExtra("driverLastName", driverStanding.getDriver().getFamilyName());
                    intent.putExtra("code", driverStanding.getDriver().getCode());
                    intent.putExtra("dob", driverStanding.getDriver().getDateOfBirth().toString());
                    intent.putExtra("driverId", driverStanding.getDriver().getDriverId());
                    intent.putExtra("nationality", driverStanding.getDriver().getNationality());
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
}
