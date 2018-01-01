package com.example.anuja.reall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class YourFamily extends AppCompatActivity {
    ImageButton btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_family);

        ImageButton btn_back = (ImageButton) findViewById(R.id.Backbutton);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YourFamily.this, LiveALife.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
