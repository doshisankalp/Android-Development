package com.example.anuja.reall.Adapter;

/**
 * Created by ANUJA on 07/Jun/2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.anuja.reall.Model.Loadlives;
import com.example.anuja.reall.R;

import java.util.List;



public class LoadlivesAdapter extends RecyclerView.Adapter<LoadlivesAdapter.MyViewHolder> {

    public int mSelectedItem = -1;
    static Loadlives selected_loadLife=new Loadlives();
    private List<Loadlives> livesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {//implements View.OnClickListener {
        public TextView name, age, gender, country;
        public RadioButton mRadio;



        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            age = (TextView) view.findViewById(R.id.age);
            gender = (TextView) view.findViewById(R.id.gender);
            country = (TextView) view.findViewById(R.id.country);
            mRadio=(RadioButton) view.findViewById(R.id.radioButtonId);
            mRadio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSelectedItem=getAdapterPosition();
                    selected_loadLife=(livesList.get(getAdapterPosition()));
                    System.out.println("life : "+selected_loadLife.getReallivesGameId());
                    notifyDataSetChanged();
                }
            });

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
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        System.out.println("bind");
        final Loadlives movie =livesList.get(position);
        holder.name.setText(movie.getName());
        holder.age.setText(String.valueOf(movie.getAge()));
        holder.gender.setText(movie.getGender());
        holder.country.setText(movie.getCountry());
        holder.mRadio.setChecked(position == mSelectedItem);


    }

    @Override
    public int getItemCount() {
        return this.livesList.size();
    }

    public Loadlives get_selected_life(){
        System.out.println("from get : "+selected_loadLife.getReallivesGameId());
        return this.selected_loadLife;
    }

}