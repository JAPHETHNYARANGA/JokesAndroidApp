package com.moringaschool.nyarangajokesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.moringaschool.nyarangajokesapp.Adapters.CategoryAdapter;
import com.moringaschool.nyarangajokesapp.fragments.Main;

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
        categories.add("Any");
        categories.add("Programming");
        categories.add("Misc");
        categories.add("Dark");
        categories.add("Pun");
        categories.add("Spooky");
        categories.add("Chrismas");

        catList = findViewById(R.id.catList);
        adapter = new CategoryAdapter(categories);

        catList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        catList.setAdapter(adapter);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction().replace(R.id.fragment_container, new Main(getResources().getString(R.string.Url)+ "Any?amount=10"));
        transaction.commit();
    }
}