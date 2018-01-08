package com.example.anuja.reall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Selectcity extends AppCompatActivity {

    ArrayList<RadioButton> rba=new ArrayList<RadioButton>();
    static int length;
    static JSONObject countryObject;
    public static JSONObject retobj;
    public static String cityname;
    public static JSONObject cityObject[]=new JSONObject[350];
    ColorStateList colorStateList = null;

    String url=Constant.GAMEURL+"characterDesign/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectcity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent i=getIntent();
        try {
            countryObject=new JSONObject(i.getStringExtra("countryObject"));
            //Log.e("CountryObject",countryObject.toString());
            url+=String.valueOf(countryObject.getString("countryid"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


        getCities();


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
        for(int i=0;i<length;i++)
        {
            try {
                if(cityObject[i].getString("cityName").equals(cityname))
                {
                    retobj=cityObject[i];
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(Selectcity.this,AttributesActivity.class);
        intent.putExtra("countryObject",countryObject.toString());
        intent.putExtra("cityObject",retobj.toString());
        startActivity(intent);
    }


    void getCities()
    {


        final ArrayList<String> myarray=new ArrayList<String>();
        final RadioButton rb[];
        final RadioGroup ll = new RadioGroup(Selectcity.this);
        ll.setOrientation(LinearLayout.VERTICAL);


        if(Build.VERSION.SDK_INT>=21)
        {

            colorStateList = new ColorStateList(
                    new int[][]{

                            new int[]{-android.R.attr.state_enabled}, //disabled
                            new int[]{android.R.attr.state_enabled} //enabled
                    },
                    new int[] {

                            Color.BLACK //disabled
                            , Color.CYAN //enabled

                    }
            );



        }

        RequestQueue que= Volley.newRequestQueue(Selectcity.this);
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        length=response.length();
                        JSONObject obj = null;


                        for(int i=0;i<response.length();i++)
                        {
                            try {
                                obj=(JSONObject) response.get(i);
                                cityObject[i]=obj;
                                Log.e("DATA",obj.getString("cityName"));
                                final RadioButton rb=new RadioButton(Selectcity.this);
                                final TextView tv=new TextView(Selectcity.this);
                                rb.setTextColor(Color.WHITE);
                                rb.setTextSize(20f);
                                rb.setButtonTintList(colorStateList);
                                rb.setText(obj.getString("cityName"));
                                ll.addView(tv);
                                ll.addView(rb);
                                rb.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Log.e("Value",rb.getText().toString());
                                        cityname=rb.getText().toString();
                                    }
                                });

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                        ((ViewGroup)findViewById(R.id.choices)).addView(ll);

                    }




                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {


                SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                String token=pref.getString("token",null);
                Log.e("x-auth-token",token);

                HashMap<String,String> headers=new HashMap<>();
                headers.put("Content-Type","application/json");
                headers.put("x-auth-token",token);
                return headers;
            }


        };

        que.add(req);

    }



}


