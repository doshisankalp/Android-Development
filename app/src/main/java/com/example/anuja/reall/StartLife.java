package com.example.anuja.reall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StartLife extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_life);
    }


    public void tolivealife(View view)
    {
        Intent intent = new Intent(StartLife.this, LiveALife.class);
        startActivity(intent);
        finish();
    }
}
