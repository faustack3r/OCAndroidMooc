package com.example.faustin.ocactivite2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Dernières Nouvelles");

        final RecyclerView titleList = (RecyclerView) findViewById(R.id.list);
        titleList.setLayoutManager(new LinearLayoutManager(this));
        titleList.setAdapter(new FakeNewsAdapter());


    }
}
