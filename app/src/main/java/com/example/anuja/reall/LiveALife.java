package com.example.anuja.reall;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class LiveALife extends AppCompatActivity {

    Intent i;
   static JSONObject responce_object;
    int position=0;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    Button btn_education;
    Button btn_career;
    Button btn_finance;
    Button btn_relation;
    Button btn_leisure;
    Button btn_residence;
    Button yes;
    TextView name,age_gender,countryname,familymember;

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
        name=(TextView)findViewById(R.id.name);
        age_gender=(TextView)findViewById(R.id.age_gender);
        countryname=(TextView)findViewById(R.id.countryname);
        familymember=(TextView)findViewById(R.id.familymembers);
        yes=(Button)findViewById(R.id.parents_dialog_moveout);




        i =getIntent();
        final String responce_string= i.getStringExtra("responce_object");
        SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("whole_object",responce_string);
        editor.commit();
        //Log.e("responce string:", responce_string);
        try {
            responce_object=new JSONObject(responce_string);
            //Log.d("responce object", String.valueOf(responce_object));
            JSONObject self=responce_object.optJSONObject("SELF");
            name.setText(self.getString("fullName"));
            JSONObject country=self.getJSONObject("country");
            countryname.setText(country.getString("countryName"));
            if(self.getString("sex").equals("M")) {
                age_gender.setText(self.getString("age") + ", Male");
            }else
            {
                age_gender.setText(self.getString("age") + ", Female");
            }
            int family_member=responce_object.length();
            int Male=0;
            int Female=0;
            if(self.getString("sex").equals("M"))
            {
                Male++;
            }
            else
            {
                Female++;
            }
            int count=responce_object.length()-3;
            for(int i=1;i<=count;i++)
            {
                String self_sibling= String.format("SELF_SIBLING_%d", i);
                JSONObject sibling=responce_object.getJSONObject(self_sibling);
                if(sibling.getString("sex").equals("M"))
                {
                    Male++;
                }
                else {
                    Female++;
                }
            }
            JSONObject father=responce_object.getJSONObject("SELF_FATHER");
            if(father.getString("sex").equals("M"))
            {
                Male++;
            }
            else {
                Female++;
            }

            JSONObject mother=responce_object.getJSONObject("SELF_MOTHER");
            if(mother.getString("sex").equals("F"))
            {
                Female++;
            }
            else {
                Male++;
            }
            familymember.setText(String.format("%d Members,%d M,%d F",family_member,Male,Female));
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


    public void onBackPressed() {
        /*AlertDialog.Builder builder=new AlertDialog.Builder(LiveALife.this);

        builder.setTitle("Live A Life");
        builder.setMessage("Do you want to quit playing current life?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i=new Intent(LiveALife.this,MainActivity.class);
                startActivity(i);
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();*/



        AlertDialog.Builder mBuilder = new AlertDialog.Builder(LiveALife.this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_quit, null);

        mBuilder.setView(dialogView);


        mBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i=new Intent(LiveALife.this,MainActivity.class);
                startActivity(i);
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        Dialog d = mBuilder.create();
        d.setContentView(dialogView);
        d.getWindow().setGravity(Gravity.CENTER);
        d.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(LiveALife.this, R.drawable.layout_bgnocorners));

        d.show();
    }


    public void goto_utility(View view) {
        Intent intent = new Intent(LiveALife.this, Utilities.class);
        intent.putExtra("utility_object",String.valueOf(responce_object));
        startActivity(intent);

    }
    public void tomainactivity(View view) {
        Intent intent = new Intent(LiveALife.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void your_family(View view) {
        Intent intent = new Intent(LiveALife.this, YourFamily.class);
        intent.putExtra("responce_object", String.valueOf(responce_object));
        //Log.e("Send object to your_life", String.valueOf(responce_object));
        startActivity(intent);

    }
    public void goto_scrolltabs(View view) {
        Intent intent = new Intent(LiveALife.this, ActionActivity.class);
        intent.putExtra("default",position);
        startActivity(intent);
    }
    public void quit(View view){
        Intent i=new Intent(LiveALife.this,MainActivity.class);
        startActivity(i);
    }

}
