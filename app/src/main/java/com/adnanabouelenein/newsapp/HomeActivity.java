package com.adnanabouelenein.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void openGeneralNews(View view) {
        openCategory("general");
    }

    public void openSportNews(View view) {
        openCategory("sports");
    }

    public void openEntertainmentNews(View view) {
        openCategory("entertainment");
    }

    public void openHealthNews(View view) {
        openCategory("health");
    }

    public void openScienceNews(View view) {
        openCategory("science");
    }

    public void openTechnologyNews(View view) {
        openCategory("technology");
    }

    public void openBusinessNews(View view) {
        openCategory("business");
    }

    private void openCategory(String category){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        exit();
    }

    private void exit(){
        ExitDialog exitDialog = new ExitDialog();
        exitDialog.setCancelable(false);
        exitDialog.show(getSupportFragmentManager(),"exit");
    }
}