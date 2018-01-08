package com.example.anuja.reall.Adapter;

/**
 * Created by Anshi on 07/Jun/2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.anuja.reall.Model.Completedlives;
import com.example.anuja.reall.Model.Loadlives;
import com.example.anuja.reall.R;

import java.util.List;



public class CompletedlivesAdapter extends RecyclerView.Adapter<CompletedlivesAdapter.MyViewHolder> {

    public int mSelectedItem = -1;
    static Completedlives selected_complete_Life=new Completedlives();
    private List<Completedlives> completeList;

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
                    selected_complete_Life=(completeList.get(getAdapterPosition()));
                    System.out.println("life : "+selected_complete_Life.getReallivesGameId());
                    notifyDataSetChanged();
                }
            });

        }


    }


    public CompletedlivesAdapter(List<Completedlives> completeList) {
        this.completeList = completeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.completelife, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        System.out.println("bind");
        final Completedlives movie =completeList.get(position);
        holder.name.setText(movie.getName());
        holder.age.setText(String.valueOf("Age "+movie.getAge())+"   - ");
        if(movie.getGender().equals("M"))
        {
            holder.gender.setText("Male   - ");
        }
        else
        {
            holder.gender.setText("Female   - ");
        }

        holder.country.setText(movie.getCountry());
        holder.mRadio.setChecked(position == mSelectedItem);


    }

    @Override
    public int getItemCount() {
        return this.completeList.size();
    }

    public Completedlives get_selected_life(){
        System.out.println("from get : "+selected_complete_Life.getReallivesGameId());
        return this.selected_complete_Life;
    }

}