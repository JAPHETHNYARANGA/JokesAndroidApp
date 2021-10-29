package com.moringaschool.nyarangajokesapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.nyarangajokesapp.R;

import org.w3c.dom.Text;

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
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view, parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryAdapter.ViewHolder holder, int position) {
        holder.catName.setText(cats.get(position));
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    //reference the text view
    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView catName;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            catName = itemView.findViewById(R.id.catName);
        }
    }
}
