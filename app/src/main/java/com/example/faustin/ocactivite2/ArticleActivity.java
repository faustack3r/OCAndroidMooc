package com.example.faustin.ocactivite2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by faustin on 6/25/17.
 */

public class ArticleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.article_activity);

        String newsTitle = getIntent().getStringExtra("newsTitle");
        String newsHtmlContent = getIntent().getStringExtra("newsHtmlContent");

        setTitle(newsTitle);
        WebView newsPage = (WebView) findViewById(R.id.newsView);

        newsPage.loadData(newsHtmlContent, "text/html; charset=UTF-8", null);

    }
}
