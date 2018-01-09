package com.example.anuja.reall;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by ANUJA on 12/Jun/2017.
 */

public class FinanceFragemnt1 extends Fragment {

   public FinanceFragemnt1() {
// Required empty public constructor
}
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
View v= inflater.inflate(R.layout.fragment_finance1, container, false);

        initalizefirstspinner(v);
        initalizesecondspinner(v);
        initializethirdspinner(v);
        initializeforthspinner(v);
        return v;

}

    private void initalizefirstspinner(View v) {
        String [] values =
                {"Starvation:0","Survival:8.56","Meager:17.11","Minimal:42.78","Adequate:85.56","Optimal:171.12","Lavish:342.24","Gourmand:684.48"};
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
    }


    private void initalizesecondspinner(View v) {
        String [] values =
                {"Homeless:0","Temporary:2.57","Simplest Shared:42.78","Simplest:256.68","Modest:598.92","Moderate:1,026.73","Ample:1,711.21","Luxurious:3,422.42"};
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
    }


    private void initializethirdspinner(View v) {
        String [] values =
                {"Nothing:0","Token:120.71","Respectable:289.71","Substantial:724.29","Saintly:1,448.57"};
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
    }

    private void initializeforthspinner(View v) {
        String [] values =
                {"Miserly:4.28","Careful Shopper:21.39","Like Other in the Community:85.56","Enthusiastic Shopper:427.8","Spend Thrift:1,283.41"};
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
    }
}
