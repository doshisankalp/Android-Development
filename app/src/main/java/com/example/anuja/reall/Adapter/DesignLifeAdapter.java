package com.example.anuja.reall.Adapter;

/**
 * Created by ANUJA on 07/Jun/2017.
 */
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.anuja.reall.ActivityFirstName;
import com.example.anuja.reall.DesignALife;
import com.example.anuja.reall.Model.DesignLifeModel;
import com.example.anuja.reall.Model.FirstName;
import com.example.anuja.reall.R;

import java.util.List;



public class DesignLifeAdapter extends RecyclerView.Adapter<DesignLifeAdapter.MyViewHolder> {

    public int mSelectedItem = -1;
    static DesignLifeModel selected_country=new DesignLifeModel();
    private List<DesignLifeModel> countryList;

    public class MyViewHolder extends RecyclerView.ViewHolder {//implements View.OnClickListener {
        public TextView countryName;
        public RadioButton mRadio;



        public MyViewHolder(View view) {
            super(view);
            countryName = (TextView) view.findViewById(R.id.name);
            mRadio=(RadioButton) view.findViewById(R.id.radioButtonId);
            mRadio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSelectedItem=getAdapterPosition();
                    selected_country=(countryList.get(getAdapterPosition()));
                    //Log.e("nameinfna",selected_firstname.getFname());
                    DesignALife xz=new DesignALife();
                    xz.setCount(selected_country.getCountry());
                    notifyDataSetChanged();

                }
            });

        }


    }


    public DesignLifeAdapter(List<DesignLifeModel> countryList) {
        this.countryList = countryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.firstname, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        System.out.println("bind");
        final DesignLifeModel movie =countryList.get(position);
        holder.countryName.setText(movie.getCountry());
        holder.mRadio.setChecked(position == mSelectedItem);


    }

    @Override
    public int getItemCount() {
        return this.countryList.size();
    }


}