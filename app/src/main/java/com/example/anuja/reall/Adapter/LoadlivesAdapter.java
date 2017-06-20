package com.example.anuja.reall.Adapter;

/**
 * Created by ANUJA on 07/Jun/2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.anuja.reall.Model.Loadlives;
import com.example.anuja.reall.R;

import java.util.List;



public class LoadlivesAdapter extends RecyclerView.Adapter<LoadlivesAdapter.MyViewHolder> {

    private List<Loadlives> livesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, age, gender, country;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            age = (TextView) view.findViewById(R.id.age);
            gender = (TextView) view.findViewById(R.id.gender);
            country = (TextView) view.findViewById(R.id.country);

        }
    }

    public LoadlivesAdapter(List<Loadlives> livesList) {
        this.livesList = livesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.loadlife, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Loadlives movie =livesList.get(position);
        holder.name.setText(movie.getName());
        holder.age.setText(movie.getAge());
        holder.gender.setText(movie.getGender());
        holder.country.setText(movie.getCountry());
    }

    @Override
    public int getItemCount() {
        return this.livesList.size();
    }

}