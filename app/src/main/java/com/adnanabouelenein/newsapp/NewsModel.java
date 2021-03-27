package com.adnanabouelenein.newsapp;

import java.util.ArrayList;

public class NewsModel {
    private ArrayList<Articles> articles;

    public ArrayList<Articles> getArticles() {
        return articles;
    }
}

class Articles {
    private String author;
    private String title;
    private String urlToImage;
    private String content;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getContent() {
        return content;
    }
}