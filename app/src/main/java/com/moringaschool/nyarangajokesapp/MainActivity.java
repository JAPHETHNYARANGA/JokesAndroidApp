package com.moringaschool.nyarangajokesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.moringaschool.nyarangajokesapp.Adapters.JokeCatAdapter;
import com.moringaschool.nyarangajokesapp.fragments.Jokes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView jokeCatList,jokeList;
    JokeCatAdapter catAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> cats = new ArrayList<>();
        cats.add("Any");
        cats.add("Programming");
        cats.add("Dark");
        cats.add("Spooky");
        cats.add("Misc");
        cats.add("Pun");
        cats.add("Christmas");

        jokeCatList = findViewById(R.id.jokeCatList);

        jokeCatList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        catAdapter = new JokeCatAdapter(cats);
        jokeCatList.setAdapter(catAdapter);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction().replace(R.id.fragment_frame,new Jokes("https://v2.jokeapi.dev/joke/Any?amount=10"));
        transaction.commit();


    }



}