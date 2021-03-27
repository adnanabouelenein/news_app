package com.adnanabouelenein.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements NewsAdapter.OnNewsListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = findViewById(R.id.progress_bar);
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CallableInterface callable = retrofit.create(CallableInterface.class);
        Call<NewsModel> newsModelCall = callable.getData(getIntent().getStringExtra("category"));

        newsModelCall.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                progressBar.setVisibility(View.GONE);
                NewsModel newsModel = response.body();
                showData(newsModel.getArticles());

            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

            }
        });
    }

    private void showData(ArrayList<Articles> articles) {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        NewsAdapter newsAdapter = new NewsAdapter(this, articles,this);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onNewsClick(int position, ArrayList<Articles> articles) {
        String title = articles.get(position).getTitle();
        String content = articles.get(position).getContent();
        String image = articles.get(position).getUrlToImage();
        Intent intent = new Intent(MainActivity.this, NewsContentActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        intent.putExtra("image", image);
        startActivity(intent);
    }
}