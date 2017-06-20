package com.example.anuja.reall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DesignALife extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designalife);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void tomainactivity(View view) {
        Intent intent = new Intent(DesignALife.this, MainActivity.class);
        startActivity(intent);
    }

    public void goto_selectcity(View view) {
        Intent intent = new Intent(DesignALife.this, Selectcity.class);
        startActivity(intent);
    }
}
