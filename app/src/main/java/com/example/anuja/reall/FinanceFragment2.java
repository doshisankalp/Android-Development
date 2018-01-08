package com.example.anuja.reall;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ANUJA on 12/Jun/2017.
 */

public class FinanceFragment2 extends Fragment {
    Button mbutton;

    public FinanceFragment2() {
// Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_finance2, container, false);
        mbutton= (Button) v.findViewById(R.id.geta_loan);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = (Context) v.getContext();
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                View dialogView = getLayoutInflater(savedInstanceState).inflate(R.layout.select_a_loan, null);




                mBuilder.setView(dialogView);
                Dialog d = new Dialog(context,R.style.Theme_Dialog);


//                Window window = d.getWindow();
//                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                d.setContentView(dialogView);
                d.getWindow().setGravity(Gravity.BOTTOM);
                d.show();
            }
        });

        return  v;
    }

}

