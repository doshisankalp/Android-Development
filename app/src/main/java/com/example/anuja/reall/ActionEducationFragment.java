package com.example.anuja.reall;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by ANUJA on 08/Jun/2017.
 */


public class ActionEducationFragment extends Fragment {

Button mbutton;
    Button enroll;
    public ActionEducationFragment() {
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
        View v= inflater.inflate(R.layout.actionfragment_education, container, false);
        enroll = (Button) v.findViewById(R.id.college_enroll);
        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = (Context) v.getContext();
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                View dialogView = getLayoutInflater(savedInstanceState).inflate(R.layout.select_study_field, null);

                mBuilder.setView(dialogView);
                Dialog d = new Dialog(context,R.style.Theme_Dialog);


//                Window window = d.getWindow();
//                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                d.setContentView(dialogView);
                d.getWindow().setGravity(Gravity.BOTTOM);
                d.show();

            }
        });
        mbutton= (Button) v.findViewById(R.id.button_quitschool);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = (Context) v.getContext();
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                View dialogView = getLayoutInflater(savedInstanceState).inflate(R.layout.dialog_quitschool, null);

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
