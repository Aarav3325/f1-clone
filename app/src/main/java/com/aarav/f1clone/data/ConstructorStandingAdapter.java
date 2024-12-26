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

import com.aarav.f1clone.ui.details.ConstructorDetailsActivity;
import com.aarav.f1clone.R;
import com.aarav.f1clone.domain.standings.ConstructorStandings;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ConstructorStandingAdapter extends RecyclerView.Adapter<ConstructorStandingAdapter.MyViewHolder> {

    private Context context;
    private static ArrayList<ConstructorStandings> constructorStandingsList;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public ConstructorStandingAdapter(Context context, ArrayList<ConstructorStandings> constructorStandingsList) {
        this.context = context;
        this.constructorStandingsList = constructorStandingsList;
        this.firebaseDatabase = FirebaseDatabase.getInstance();
        this.databaseReference = firebaseDatabase.getReference().child("constructors");
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.standings_card, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ConstructorStandings constructorStanding = constructorStandingsList.get(position);


        holder.position.setText(String.valueOf(constructorStanding.getPosition()));
        holder.constructorName.setText(constructorStanding.getConstructor().getName());
        holder.points.setText(constructorStanding.getPoints());

        databaseReference.child(constructorStanding.getConstructor().getConstructorId()).addValueEventListener(new ValueEventListener() {
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
        return constructorStandingsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView position, constructorName, driver1, driver2, points, line;
        CardView root;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            position = itemView.findViewById(R.id.position);
            constructorName = itemView.findViewById(R.id.constructorName);
            points = itemView.findViewById(R.id.points);
            line = itemView.findViewById(R.id.line);

            root = itemView.findViewById(R.id.root);

            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    ConstructorStandings constructorStanding = constructorStandingsList.get(position);
                    Intent intent = new Intent(v.getContext(), ConstructorDetailsActivity.class);
                    intent.putExtra("constructorId", constructorStanding.getConstructor().getConstructorId());
                    intent.putExtra("wins", constructorStanding.getWins());
                    intent.putExtra("points", constructorStanding.getPoints());
                    intent.putExtra("position", constructorStanding.getPosition());
                    intent.putExtra("constructorName", constructorStanding.getConstructor().getName());
                    intent.putExtra("nationality", constructorStanding.getConstructor().getNationality());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
