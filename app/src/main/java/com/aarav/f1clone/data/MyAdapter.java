package com.aarav.f1clone.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aarav.f1clone.R;
import com.aarav.f1clone.domain.driver.Driver;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Driver> models;
    private Context context;

    public MyAdapter(ArrayList<Driver> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Driver model = models.get(position);

        holder.givenName.setText(model.getGivenName());
        holder.familyName.setText(model.getFamilyName());
        holder.permanentNumber.setText("" + model.getPermanentNumber());

        //Glide.with(context).load(model.getHeadshot_url()).into(holder.headshot_url);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView givenName, familyName, permanentNumber, nationality, date;
        ImageView headshot_url;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.givenName = itemView.findViewById(R.id.givenName);
            this.familyName = itemView.findViewById(R.id.familyName);
            this.permanentNumber = itemView.findViewById(R.id.permanentNumber);
            this.headshot_url = itemView.findViewById(R.id.headshot_url);
        }
    }
}
