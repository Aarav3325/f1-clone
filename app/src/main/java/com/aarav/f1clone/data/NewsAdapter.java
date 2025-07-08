package com.aarav.f1clone.data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aarav.f1clone.R;
import com.aarav.f1clone.domain.news.NewsDataModel;
import com.aarav.f1clone.ui.home.NewsActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private static ArrayList<NewsDataModel> newsArrayList;
    private Context context;

    public NewsAdapter(ArrayList<NewsDataModel> newsArrayList, Context context) {
        this.newsArrayList = newsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NewsDataModel newsDataModel = newsArrayList.get(position);

        holder.tagName.setText(newsDataModel.getTagName());
        holder.headlines.setText(newsDataModel.getHeadlines());
        Glide.with(context).load(newsDataModel.getNewsCoverImage()).into(holder.newsCover);


    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView newsCover;
        TextView tagName, headlines;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            newsCover = itemView.findViewById(R.id.newsCover);
            tagName = itemView.findViewById(R.id.tagName);
            headlines = itemView.findViewById(R.id.headlines);
            linearLayout = itemView.findViewById(R.id.linearLayout3);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    NewsDataModel newsDataModel = newsArrayList.get(position);
                    Intent intent = new Intent(v.getContext(), NewsActivity.class);
                    intent.putExtra("url", newsDataModel.getUrl());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
