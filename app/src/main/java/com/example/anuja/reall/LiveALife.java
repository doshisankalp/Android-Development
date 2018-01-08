package com.example.anuja.reall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.json.JSONException;
import org.json.JSONObject;

public class LiveALife extends AppCompatActivity {

    Intent i;
    JSONObject responce_object;
    int position=0;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    Button btn_education;
    Button btn_career;
    Button btn_finance;
    Button btn_relation;
    Button btn_leisure;
    Button btn_residence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_alife);
        btn_education= (Button) findViewById(R.id.btn_education);
        btn_career= (Button) findViewById(R.id.btn_career);
        btn_finance= (Button) findViewById(R.id.btn_finance);
        btn_relation= (Button) findViewById(R.id.btn_relations);
        btn_leisure= (Button) findViewById(R.id.btn_leisure);
        btn_residence= (Button) findViewById(R.id.btn_residence);

        i =getIntent();
        String responce_string= i.getStringExtra("responce_object");
        Log.e("responce string:", responce_string);
        try {
            responce_object=new JSONObject(responce_string);
            Log.d("responce object", String.valueOf(responce_object));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        relativeLayout = (RelativeLayout) findViewById(R.id.rightRL);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiveALife.this, YourCountry.class);
                intent.putExtra("responce_object", String.valueOf(responce_object));
                Log.e("Send  yourcountry", String.valueOf(responce_object));
                startActivity(intent);
                finish();
            }
        });

        linearLayout = (LinearLayout) findViewById(R.id.horizontalbottom);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiveALife.this, WellBeingIndicators.class);
                startActivity(intent);
                finish();
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        btn_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position=0;
                goto_scrolltabs(v);
            }
        });

        btn_career.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position=1;
                goto_scrolltabs(v);
            }
        });

        btn_finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position=2;
                goto_scrolltabs(v);

            }
        });

        btn_relation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 3;
                goto_scrolltabs(v);
            }
        });
        btn_residence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position=4;
                goto_scrolltabs(v);
            }
        });

        btn_leisure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position=5;
                goto_scrolltabs(v);
            }
        });



    }

    public void goto_utility(View view) {
        Intent intent = new Intent(LiveALife.this, Utilities.class);
        intent.putExtra("utility_object", String.valueOf(responce_object));
        Log.e("utility_object", String.valueOf(responce_object));
        startActivity(intent);

    }
    public void tomainactivity(View view) {
        Intent intent = new Intent(LiveALife.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void your_family(View view) {
        Intent intent = new Intent(LiveALife.this, YourFamily.class);
        startActivity(intent);
        finish();
    }
    public void goto_scrolltabs(View view) {
        Intent intent = new Intent(LiveALife.this, ActionActivity.class);
        intent.putExtra("default",position);
        startActivity(intent);
    }

}
