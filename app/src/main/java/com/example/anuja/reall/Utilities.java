package com.example.anuja.reall;

import android.app.job.JobInfo;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Utilities extends AppCompatActivity {
Intent i;
   static JSONObject utility_object=new JSONObject();
   static JSONObject selfObject=new JSONObject();
    static JSONObject dietObject=new JSONObject();
    static JSONObject expenseObject=new JSONObject();
    static JSONObject shelterObject=new JSONObject();
    static JSONObject amenitiesObject = new JSONObject();
String Diet,shelter,safewater,medical,sanitation,refrigerators,computers,internet,cellphones,cars,telephones,radios,television;

TextView diet,shelterText,safewaterText,MedicalText,sanitationText,refrigeratorText,computerText,internetText,cellphonetext,carstext,telephonesText,radioText,televisionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilities);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        diet=(TextView)findViewById(R.id.dietText);
        shelterText=(TextView)findViewById(R.id.shelterText);
        safewaterText=(TextView)findViewById(R.id.water);
        MedicalText=(TextView)findViewById(R.id.medicalcaretext);
        sanitationText=(TextView)findViewById(R.id.sanitation);
        refrigeratorText=(TextView)findViewById(R.id.refrigerator);
        computerText=(TextView)findViewById(R.id.computers);
        internetText=(TextView)findViewById(R.id.internettext);
        cellphonetext=(TextView)findViewById(R.id.cellphonetext);
        carstext=(TextView)findViewById(R.id.carstext);
        telephonesText=(TextView)findViewById(R.id.telephonestext) ;
        radioText=(TextView)findViewById(R.id.radios);
        televisionText=(TextView)findViewById(R.id.television);


        diet();
        shelter();
        safewater();








    }

    public void tolivealife(View view) {
        Intent intent = new Intent(Utilities.this, LiveALife.class);
        startActivity(intent);
        finish();
    }

    public void diet()
    {
        try {
            i =getIntent();
            String responce_string= i.getStringExtra("utility_object");
            try {
                utility_object=new JSONObject(responce_string);
                Log.d("utility object", String.valueOf(utility_object));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            selfObject=utility_object.getJSONObject("SELF");

            expenseObject=selfObject.getJSONObject("expense");
            Log.e("dietindex", String.valueOf(expenseObject));
            dietObject=expenseObject.getJSONObject("diet");
            Log.e("dietindex2", String.valueOf(dietObject));
            Diet=dietObject.getString("dietIndex");
            Log.e("dietindex3",Diet);

            if(Diet.equals("1"))
            {
                diet.setText("Startvation");
            }
            if(Diet.equals("2"))
            {
                diet.setText("Survival");
            }
            if(Diet.equals("3"))
            {
                diet.setText("Meager");
            }
            if(Diet.equals("4"))
            {
                diet.setText("Minimal");
            }
            if(Diet.equals("5"))
            {
                diet.setText("Adequate");
            }
            if(Diet.equals("6"))
            {
                diet.setText("Optimal");
            }
            if(Diet.equals("7"))
            {
                diet.setText("Lavish");
            }
            if(Diet.equals("8"))
            {
                diet.setText("Gourmand");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void shelter()
    {
        try {


            shelterObject=expenseObject.getJSONObject("shelter");
            Log.e("shelter", String.valueOf(shelterObject));
            shelter=shelterObject.getString("shelterIndex");
            Log.e("shelter3",shelter);

            if(shelter.equals("1"))
            {
                shelterText.setText("Homeless");
            }
            if(shelter.equals("2"))
            {
                shelterText.setText("Temporary");
            }
            if(shelter.equals("3"))
            {
                shelterText.setText("Simplest Shared");
            }
            if(shelter.equals("4"))
            {
                shelterText.setText("Simplest");
            }
            if(shelter.equals("5"))
            {
                shelterText.setText("Modest");
            }
            if(shelter.equals("6"))
            {
                shelterText.setText("Moderate");
            }
            if(shelter.equals("7"))
            {
                shelterText.setText("Ample");
            }
            if(shelter.equals("8"))
            {
                shelterText.setText("Luxurious");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void safewater(){
        try
        {
        amenitiesObject=selfObject.getJSONObject("amenities");
        Log.e("shelter", String.valueOf(amenitiesObject));
        safewater=amenitiesObject.getString("safeWater");
        Log.e("safe",safewater);
        medical=amenitiesObject.getString("healthServices");
        Log.e("medical",medical);
        sanitation=amenitiesObject.getString("basicSanitation");
        Log.e("sanitation",sanitation);
        refrigerators=amenitiesObject.getString("refrigerators");
        Log.e("refri",refrigerators);
        computers=amenitiesObject.getString("computers");
        Log.e("comp",computers);
        internet=amenitiesObject.getString("internet");
        Log.e("internet",internet);
        cellphones=amenitiesObject.getString("mobiles");
        Log.e("mobiles",cellphones);
            cars=amenitiesObject.getString("vehicles");
            Log.e("cars",cars);
            telephones=amenitiesObject.getString("telephones");
            Log.e("telephone",telephones);
            radios=amenitiesObject.getString("radios");
            Log.e("radio",radios);
            television=amenitiesObject.getString("televisions");
            Log.e("television",television );


        if(safewater.equals("true"))
        {
            safewaterText.setText("Yes");
        }
        if(medical.equals("true")){
            MedicalText.setText("Yes");
        }
        if(sanitation.equals("true")){
            sanitationText.setText("Yes");
        }
        if(internet.equals("true")){
            internetText.setText("Yes");
        }

        refrigeratorText.setText(refrigerators);
        computerText.setText(computers);
        cellphonetext.setText(cellphones);
        carstext.setText(cars);
        telephonesText.setText(telephones);
        radioText.setText(radios);
        televisionText.setText(television);




    } catch (JSONException e) {
        e.printStackTrace();
    }


    }

}
