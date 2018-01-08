package com.example.anuja.reall;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

/**
 * Created by ANUJA on 09/Jun/2017.
 */

public class ActionLeisureFragment extends Fragment {
CheckBox arts;
    private ViewPager viewPager;
    public ActionLeisureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.actionfragment_leisure,container,false);
       arts=(CheckBox)v.findViewById(R.id.CB1);

        // Inflate the layout for this fragment
        arts.setChecked(true);
        return v;




    }
}
