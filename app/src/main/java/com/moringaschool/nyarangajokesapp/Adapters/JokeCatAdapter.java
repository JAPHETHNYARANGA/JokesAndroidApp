package com.moringaschool.nyarangajokesapp.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.nyarangajokesapp.R;
import com.moringaschool.nyarangajokesapp.fragments.Jokes;

import java.util.List;

//this adapter extends recycler view adapter since its an adapter for the recycler view
//view holder is the paremeter , since its where we are going to reference to our customLayout
//<CategoryAdapter.View holder> - is because the view holder is inside the category Adapter
//implements methods
//the category adapter will be referenced in the main activity, so that we are able to display the api in the recyclerview
public class JokeCatAdapter extends RecyclerView.Adapter<JokeCatAdapter.ViewHolder> {
    List<String> categories;
    int selected_position = 0;

    public JokeCatAdapter(List<String> cats){
        this.categories = cats;
    }

    @NonNull
    @Override
    public JokeCatAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  JokeCatAdapter.ViewHolder holder, int position) {
        holder.catName.setText(categories.get(position));

        holder.card.setBackgroundColor(selected_position == position ? Color.RED:Color.WHITE);
        holder.card.setRadius(10);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView catName;
        CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            catName = itemView.findViewById(R.id.catName);
            card = itemView.findViewById(R.id.mCardView);
        }


        @Override
        public void onClick(View v) {
            // Below line is just like a safety check, because sometimes holder could be null,
            // in that case, getAdapterPosition() will return RecyclerView.NO_POSITION
            if (getAdapterPosition() == RecyclerView.NO_POSITION) return;

            // Updating old as well as new positions
            notifyItemChanged(selected_position);
            selected_position = getAdapterPosition();
            notifyItemChanged(selected_position);

            // Do your another stuff for your onClick
            if(categories.get(selected_position) == "Any"){
                loadFragment(new Jokes(v.getResources().getString(R.string.Url)+"Any?amount=20"),v);
                //Log.d("TAG", "onClick: "+v.getResources().getString(R.string.url)+"Any?amount=10");
            }
            if(categories.get(selected_position) == "Programming"){
                loadFragment(new Jokes(v.getResources().getString(R.string.Url)+"Programming?amount=20"),v);
            }
            if(categories.get(selected_position) == "Dark"){
                loadFragment(new Jokes(v.getResources().getString(R.string.Url)+"Dark?amount=20"),v);
            }

            if(categories.get(selected_position) == "Spooky"){
                loadFragment(new Jokes(v.getResources().getString(R.string.Url)+"Spooky?amount=20"),v);
            }

            if(categories.get(selected_position) == "Misc"){
                loadFragment(new Jokes(v.getResources().getString(R.string.Url)+"Misc?amount=20"),v);
            }

            if(categories.get(selected_position) == "Pun"){
                loadFragment(new Jokes(v.getResources().getString(R.string.Url)+"Programming?amount=20"),v);
            }

            if(categories.get(selected_position) == "Christmas"){
                loadFragment(new Jokes(v.getResources().getString(R.string.Url)+"Christmas?amount=20"),v);
            }

        }
    }

    public void loadFragment(Fragment fragment,View v){
        AppCompatActivity activity = (AppCompatActivity) v.getContext();
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction().replace(R.id.fragment_frame,fragment);
        transaction.commit();
    }

}