package com.moringaschool.nyarangajokesapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moringaschool.nyarangajokesapp.R;

import static android.content.ContentValues.TAG;


public class Main extends Fragment {
    String jokeApiUrl;

    public Main(String url){
        this.jokeApiUrl = url;
        Log.d(TAG,"Main:" + jokeApiUrl);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}