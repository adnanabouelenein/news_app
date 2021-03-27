package com.adnanabouelenein.newsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Activity activity;
    private ArrayList<Articles> articles;
    private OnNewsListener onNewsListener;

    public NewsAdapter(Activity activity, ArrayList<Articles> articles, OnNewsListener onNewsListener) {
        this.activity = activity;
        this.articles = articles;
        this.onNewsListener = onNewsListener;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.news_list_item, parent, false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(v, onNewsListener);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.newsTitle.setText(articles.get(position).getTitle());
        String imageLink = articles.get(position).getUrlToImage();

        Picasso
                .get()
                .load(imageLink)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView newsTitle;
        OnNewsListener onNewsListener;
        public NewsViewHolder(@NonNull View itemView, OnNewsListener onNewsListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.news_image);
            newsTitle = itemView.findViewById(R.id.news_title);
            this.onNewsListener = onNewsListener;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            onNewsListener.onNewsClick(getAdapterPosition(), articles);
        }
    }

    public interface OnNewsListener{
        void onNewsClick(int position, ArrayList<Articles> articles);
    }
}
