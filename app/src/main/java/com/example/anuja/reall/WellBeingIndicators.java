package com.example.anuja.reall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class WellBeingIndicators extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.well_being_indicators);

        List<Entry> entries = new ArrayList<Entry>();




        LineDataSet dataSet = new LineDataSet(entries, "Label");



    }
}
