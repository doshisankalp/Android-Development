package com.example.anuja.reall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Selectcity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectcity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void tomainactivity(View view) {
        Intent intent = new Intent(Selectcity.this, MainActivity.class);
        startActivity(intent);
    }
    public void toselectcountry(View view) {
        Intent intent = new Intent(Selectcity.this, DesignALife.class);
        startActivity(intent);
    }
    public void toselectattr(View view) {
        Intent intent = new Intent(Selectcity.this,AttributesActivity.class);
        startActivity(intent);
    }
}
