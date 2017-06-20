package com.example.anuja.reall;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.anuja.reall.Adapter.LoadlivesAdapter;
import com.example.anuja.reall.Model.Loadlives;

import java.util.ArrayList;
import java.util.List;

public class Loadlife extends AppCompatActivity {
    private List<Loadlives> livesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LoadlivesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadlife);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        prepareLoadlifeData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new LoadlivesAdapter(livesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



    }

    private void prepareLoadlifeData() {

        Loadlives life1 = new Loadlives("lissy", "Age 20",".female",".Nigeria");
        livesList.add(life1);

        Loadlives life2 = new Loadlives("li", "Age 20",".male",".Eeria");
        livesList.add(life2);

        Loadlives life = new Loadlives("hayley", "Age 10",".female",".Qatar");
        livesList.add(life);
        life = new Loadlives("jossy", "Age 5",".female",".peru");
        livesList.add(life);
        life = new Loadlives("ian", "Age 15",".male",".Eeria");
        livesList.add(life);
        life = new Loadlives("nina", "Age 28",".female",".Eeria");
        livesList.add(life);
        life = new Loadlives("david", "Age 60",".male",".Eeria");
        livesList.add(life);
        life = new Loadlives("john", "Age 56",".male",".Eeria");
        livesList.add(life);
        life = new Loadlives("edward", "Age 36",".male",".qatar");
        livesList.add(life);
        life = new Loadlives("john", "Age 96",".male",".Eeria");
        livesList.add(life);
        life = new Loadlives("john", "Age 56",".male",".Eeria");
        livesList.add(life);
        life = new Loadlives("john", "Age 31",".male",".Eeria");
        livesList.add(life);
        life = new Loadlives("john", "Age 52",".male",".Eeria");
        livesList.add(life);

       // mAdapter.notifyDataSetChanged();
    }








    public void tomainactivity(View view) {
        Intent intent = new Intent(Loadlife.this, MainActivity.class);
        startActivity(intent);
    }
}