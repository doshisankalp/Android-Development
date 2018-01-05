package com.example.anuja.reall;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StartLife extends AppCompatActivity {
    Intent i;
    JSONObject responce_object=new JSONObject();
    SharedPreferences pref;
    Button start_life;
    static String ID="";
    String url;
    TextView name,gender,location,language,religion,capital,currency,primary_school,primary_enrol,population,unemployment_rate,sex_ratio,birth_rate,death_rate,health_per_capita,access_elect,goiter,corruption,hdi,happiness_index,gini,sdg,ppp,agri,services,industry;
    TextView reg_capital,reg_currency,reg_primary_school,reg_primary_enrol,reg_population,reg_unemployment_rate,reg_sex_ratio,reg_birth_rate,reg_death_rate,reg_health_per_capita,reg_access_elect,reg_goiter,reg_corruption,reg_hdi,reg_happiness_index,reg_gini,reg_sdg,reg_ppp,reg_agri,reg_services,reg_industry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_life);

        i =getIntent();
        ID= i.getStringExtra("ID");
        Log.e("In start:", String.valueOf(ID));
        url=Constant.GAMEURL+"get_person/"+ID;
        start_life=(Button)findViewById(R.id.start_life);
        name=(TextView)findViewById(R.id.Name);
        gender=(TextView)findViewById(R.id.start_life_gender);
        location=(TextView)findViewById(R.id.start_life_location);
        language=(TextView)findViewById(R.id.start_life_language);
        capital=(TextView)findViewById(R.id.capital);
        religion=(TextView)findViewById(R.id.start_life_religion);
        currency=(TextView)findViewById(R.id.currency);
        primary_school=(TextView)findViewById(R.id.primary_school);
        population=(TextView)findViewById(R.id.population);
        unemployment_rate=(TextView)findViewById(R.id.unemployment_rate);
        sex_ratio=(TextView)findViewById(R.id.sex_ratio);
        birth_rate=(TextView)findViewById(R.id.birth_rate);
        death_rate=(TextView)findViewById(R.id.death_rate);
        health_per_capita=(TextView)findViewById(R.id.health_per_capita);
        access_elect=(TextView)findViewById(R.id.access_elect);
        goiter=(TextView)findViewById(R.id.goitre);
        corruption=(TextView)findViewById(R.id.corruption);
        hdi=(TextView)findViewById(R.id.hdi);
        happiness_index=(TextView)findViewById(R.id.happiness_index);
        gini=(TextView)findViewById(R.id.gini);
        sdg=(TextView)findViewById(R.id.sdg);
        ppp=(TextView)findViewById(R.id.ppp);
        agri=(TextView)findViewById(R.id.agri);
        services=(TextView)findViewById(R.id.services);
        industry=(TextView)findViewById(R.id.industry);
        primary_enrol=(TextView)findViewById(R.id.primary_school_enr);
        reg_primary_enrol=(TextView)findViewById(R.id.reg_primary_school_enr);

        reg_capital=(TextView)findViewById(R.id.capital1);
        reg_currency=(TextView)findViewById(R.id.currency1);
        reg_primary_school=(TextView)findViewById(R.id.primary_school1);
        reg_population=(TextView)findViewById(R.id.population1);
        reg_unemployment_rate=(TextView)findViewById(R.id.unemployment_rate1);
        reg_sex_ratio=(TextView)findViewById(R.id.sex_ratio1);
        reg_birth_rate=(TextView)findViewById(R.id.birth_rate1);
        reg_death_rate=(TextView)findViewById(R.id.death_rate1);
        reg_health_per_capita=(TextView)findViewById(R.id.health_per_capita1);
        reg_access_elect=(TextView)findViewById(R.id.access_elect1);
        reg_goiter=(TextView)findViewById(R.id.goitre1);
        reg_corruption=(TextView)findViewById(R.id.corruption1);
        reg_hdi=(TextView)findViewById(R.id.hdi1);
        reg_happiness_index=(TextView)findViewById(R.id.happiness_index1);
        reg_gini=(TextView)findViewById(R.id.gini1);
        reg_sdg=(TextView)findViewById(R.id.sdg1);
        reg_ppp=(TextView)findViewById(R.id.ppp1);
        reg_agri=(TextView)findViewById(R.id.agri1);
        reg_services=(TextView)findViewById(R.id.services1);
        reg_industry=(TextView)findViewById(R.id.industry1);
        get_life_info();
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(StartLife.this);

        builder.setTitle("Start Life");
        builder.setMessage("Do you want to go back?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i=new Intent(StartLife.this,MainActivity.class);
                startActivity(i);
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();
    }



    private void get_life_info() {
        final JSONObject jsonobject_one = new JSONObject();
        final JSONObject jsonObject=new JSONObject();
        RequestQueue requestQueue= Volley.newRequestQueue(StartLife.this);
        Log.e("url",url);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(


                Request.Method.GET,url, jsonobject_one,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            responce_object=response;
                            JSONObject object = response.getJSONObject("SELF");
                            name.setText(object.getString("fullName"));
                            gender.setText( object.getString("sex"));
                            JSONObject object5=object.getJSONObject("traits");
                            happiness_index.setText(object5.getString("happiness"));
                            JSONObject object1=object.getJSONObject("country");
                            primary_enrol.setText(object1.getString("primaryStudents"));
                            primary_school.setText(object1.getString("primarySchool"));
                            industry.setText(object1.getString("industry"));
                            services.setText(object1.getString("services"));
                            agri.setText(object1.getString("agriculture"));
                            health_per_capita.setText(object1.getString("wealthPerCapita"));
                            access_elect.setText(object1.getString("eletricityConsumption"));
                            happiness_index.setText(object1.getString("happinessScore"));
                            ppp.setText(object1.getString("ppp"));
                            sdg.setText(object1.getString("sdgiScore"));
                            gini.setText(object1.getString("gini"));
                            currency.setText(object1.getString("currencyName"));
                            goiter.setText(object1.getString("goitre"));
                            hdi.setText(object1.getString("hdi"));
                            corruption.setText(object1.getString("corruption"));
                            sex_ratio.setText(object1.getString("sexRatio"));
                            birth_rate.setText(object1.getString("birthRate"));
                            death_rate.setText(object1.getString("deathRate"));
                            unemployment_rate.setText(object1.getString("unEmploymentRate"));
                            population.setText(object1.getString("population"));
                            JSONObject object2=object.getJSONObject("region");
                            location.setText(object2.getString("regionName")+","+object1.getString("countryName"));
                            JSONObject object3=object.getJSONObject("language");
                            language.setText("language:"+object3.getString("languageName"));
                            capital.setText(object1.getString("capital"));
                            JSONObject object4=object.getJSONObject("religion");
                            religion.setText(object4.getString("religionName"));


                            JSONObject object_r = response.getJSONObject("SELF");
                            JSONObject object_r5=object_r.getJSONObject("traits");
                            reg_happiness_index.setText(object_r5.getString("happiness"));
                            JSONObject object_r1=object_r.getJSONObject("registerCoutry");
                            reg_primary_enrol.setText(object_r1.getString("primaryStudents"));
                            reg_primary_school.setText(object_r1.getString("primarySchool"));
                            reg_industry.setText(object_r1.getString("industry"));
                            reg_services.setText(object_r1.getString("services"));
                            reg_agri.setText(object_r1.getString("agriculture"));
                            reg_health_per_capita.setText(object_r1.getString("wealthPerCapita"));
                            reg_access_elect.setText(object_r1.getString("eletricityConsumption"));
                            reg_happiness_index.setText(object_r1.getString("happinessScore"));
                            reg_ppp.setText(object_r1.getString("ppp"));
                            reg_sdg.setText(object_r1.getString("sdgiScore"));
                            reg_gini.setText(object_r1.getString("gini"));
                            reg_currency.setText(object_r1.getString("currencyName"));
                            reg_goiter.setText(object_r1.getString("goitre"));
                            reg_hdi.setText(object_r1.getString("hdi"));
                            reg_corruption.setText(object_r1.getString("corruption"));
                            reg_sex_ratio.setText(object_r1.getString("sexRatio"));
                            reg_birth_rate.setText(object_r1.getString("birthRate"));
                            reg_death_rate.setText(object_r1.getString("deathRate"));
                            reg_unemployment_rate.setText(object_r1.getString("unEmploymentRate"));
                            reg_population.setText(object_r1.getString("population"));
                            reg_capital.setText(object_r1.getString("capital"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Log.e("DATA",response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                pref=getApplication().getSharedPreferences("Options",MODE_PRIVATE);
                String token=pref.getString("token","");
                Log.e("token in start",token);
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("x-auth-token",token);
                return headers;
            }

        };

        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return  100000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 100000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }

        });

        requestQueue.add(jsonObjReq);


    }


    public void tolivealife(View view)
    {
        Intent intent = new Intent(StartLife.this, LiveALife.class);
        intent.putExtra("responce_object", String.valueOf(responce_object));
        Log.e("Send object to livelife", String.valueOf(responce_object));
        startActivity(intent);
    }
}
