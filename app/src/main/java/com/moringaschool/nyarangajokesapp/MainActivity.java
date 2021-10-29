package com.moringaschool.nyarangajokesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.moringaschool.nyarangajokesapp.Adapters.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView catList;
    List<String> categories;
    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categories = new ArrayList<>();

        //insert cat names
        categories.add("category 1");
        categories.add("category 2");
        categories.add("cat 3");

        catList = findViewById(R.id.catList);
        adapter = new CategoryAdapter(categories);

        catList.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false));
        catList.setAdapter(adapter);
    }
}