package com.moringaschool.nyarangajokesapp.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//this adapter extends recycler view adapter since its an adapter for the recycler view
//view holder is the paremeter , since its where we are going to reference to our customLayout
//<CtegoryAdapter.View holder> - is because the view holder is inside the category Adapter
//implements methods
//the category adapter will be referenced in the main activity, so that we are able to display the api in the recyclerview
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    //to receive the data for our categories
    List<String> cats;

    public CategoryAdapter(List<String> cats){
        this.cats = cats;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
        }
    }
}
