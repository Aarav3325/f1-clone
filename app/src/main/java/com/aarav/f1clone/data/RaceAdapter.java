package com.aarav.f1clone.data;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import java.text.ParseException;
import java.util.Date;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aarav.f1clone.R;
import com.aarav.f1clone.domain.race.Race;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RaceAdapter extends RecyclerView.Adapter<RaceAdapter.MyViewHolder> {

    private ArrayList<Race> raceArrayList;
    private Context context;

    public RaceAdapter(ArrayList<Race> raceArrayList, Context context) {
        this.raceArrayList = raceArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.race_card, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Race race = raceArrayList.get(position);


        //holder.month.setText(race.getMonth());
        holder.round.setText("ROUND" + " " + race.getRound());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(race.getDate());
            String date1 = new SimpleDateFormat("dd").format(date);
            holder.date.setText("" + date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            Date date = simpleDateFormat.parse(race.getDate());
            String month = new SimpleDateFormat("MMM").format(date);
            holder.month.setText(month);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Log.i("MYTAG", simpleDateFormat.toString());


        holder.location.setText(race.getCircuit().getLocation().getCountry());
        holder.circuit.setText(race.getCircuit().getCircuitName());

    }

    @Override
    public int getItemCount() {
        return raceArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView date, month, round, location, circuit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            month = itemView.findViewById(R.id.month);
            round = itemView.findViewById(R.id.round);
            location = itemView.findViewById(R.id.location);
            circuit = itemView.findViewById(R.id.circuit);
        }
    }
}
