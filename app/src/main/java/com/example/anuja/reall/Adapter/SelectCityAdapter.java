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
import com.example.anuja.reall.Model.SelectCityModel;
import com.example.anuja.reall.R;
import com.example.anuja.reall.Selectcity;

import java.util.List;



public class SelectCityAdapter extends RecyclerView.Adapter<SelectCityAdapter.MyViewHolder> {

    public int mSelectedItem = -1;
    static SelectCityModel selected_city=new SelectCityModel();
    private List<SelectCityModel> cityList;

    public class MyViewHolder extends RecyclerView.ViewHolder {//implements View.OnClickListener {
        public TextView cityName;
        public RadioButton mRadio;



        public MyViewHolder(View view) {
            super(view);
            cityName = (TextView) view.findViewById(R.id.name);
            mRadio=(RadioButton) view.findViewById(R.id.radioButtonId);
            mRadio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSelectedItem=getAdapterPosition();
                    selected_city=(cityList.get(getAdapterPosition()));
                    //Log.e("nameinfna",selected_firstname.getFname());
                    Selectcity xz=new Selectcity();
                    xz.getCityName(selected_city.getCity());
                    notifyDataSetChanged();

                }
            });

        }


    }


    public SelectCityAdapter(List<SelectCityModel> cityList) {
        this.cityList = cityList;
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
        final SelectCityModel movie =cityList.get(position);
        holder.cityName.setText(movie.getCity());
        holder.mRadio.setChecked(position == mSelectedItem);


    }

    @Override
    public int getItemCount() {
        return this.cityList.size();
    }


}