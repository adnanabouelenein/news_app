package com.adnanabouelenein.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class NewsContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        Intent intent = getIntent();
        String contentText = intent.getStringExtra("content");
        String imageUrl = intent.getStringExtra("image");
        String titleText = intent.getStringExtra("title");

        TextView textView = findViewById(R.id.content_text);
        TextView title = findViewById(R.id.title_text);
        ImageView imageView = findViewById(R.id.news_image_content_activity);

        textView.setText(contentText);
        title.setText(titleText);
        Picasso
                .get()
                .load(imageUrl)
                .into(imageView);
    }
}