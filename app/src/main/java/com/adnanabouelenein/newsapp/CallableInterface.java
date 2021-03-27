package com.adnanabouelenein.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CallableInterface {

    @GET("/v2/top-headlines?country=us&apiKey=d0b1856fbc6749e9a449e760803a8048")
    Call<NewsModel> getData(@Query("category") String category);
}
