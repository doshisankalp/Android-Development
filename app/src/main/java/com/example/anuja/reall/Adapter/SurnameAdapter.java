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
import com.example.anuja.reall.ActivitySurname;
import com.example.anuja.reall.Model.FirstName;
import com.example.anuja.reall.Model.SurnameModel;
import com.example.anuja.reall.R;

import java.util.List;



public class SurnameAdapter extends RecyclerView.Adapter<SurnameAdapter.MyViewHolder> {

    public int mSelectedItem = -1;
    static SurnameModel selected_lastname=new SurnameModel();
    private List<SurnameModel> lastNameList;

    public class MyViewHolder extends RecyclerView.ViewHolder {//implements View.OnClickListener {
        public TextView surname;
        public RadioButton mRadio;



        public MyViewHolder(View view) {
            super(view);
            surname = (TextView) view.findViewById(R.id.name);
            mRadio=(RadioButton) view.findViewById(R.id.radioButtonId);
            mRadio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSelectedItem=getAdapterPosition();
                    selected_lastname=(lastNameList.get(getAdapterPosition()));
                    //Log.e("nameinfna",selected_firstname.getFname());
                    ActivitySurname xz=new ActivitySurname();
                    xz.setName(selected_lastname.getSname());
                    notifyDataSetChanged();

                }
            });

        }


    }


    public SurnameAdapter(List<SurnameModel> lastNameList) {
        this.lastNameList = lastNameList;
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
        final SurnameModel movie =lastNameList.get(position);
        holder.surname.setText(movie.getSname());
        holder.mRadio.setChecked(position == mSelectedItem);


    }

    @Override
    public int getItemCount() {
        return this.lastNameList.size();
    }


}