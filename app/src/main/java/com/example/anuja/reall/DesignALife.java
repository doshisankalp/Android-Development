package com.example.anuja.reall;

import android.app.Application;
import android.content.Context;
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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DesignALife extends AppCompatActivity {

    ArrayList<RadioButton> rba=new ArrayList<RadioButton>();
    static int length;
    ColorStateList colorStateList = null;
    public static JSONObject countryobj[]=new JSONObject[350];
    public static JSONObject retobj;
    public static String countryname;
    HashMap<String,Integer> details=new HashMap<>();

    String url=Constant.GAMEURL+"actionbar/residence/country";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designalife);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getCountries();




    }
    public void tomainactivity(View view) {
        Intent intent = new Intent(DesignALife.this, MainActivity.class);
        startActivity(intent);
    }

    public void goto_selectcity(View view) {

        for(int i=0;i<length;i++)
        {
            try {
                if(countryobj[i].getString("countryName").equals(countryname))
                {
                    retobj=countryobj[i];
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        //Log.e("JSON Object",retobj);
        Intent intent = new Intent(DesignALife.this, Selectcity.class);
        intent.putExtra("countryObject",retobj.toString());
        startActivity(intent);


    }



    void getCountries()
    {


        final ArrayList<String> myarray=new ArrayList<String>();
        final RadioButton rb[];
        final RadioGroup ll = new RadioGroup(DesignALife.this);
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
                            ,Color.CYAN //enabled

                    }
            );


            //radio.setButtonTintList(colorStateList);//set the color tint list
            //radio.invalidate(); //could not be necessary
        }

        RequestQueue que= Volley.newRequestQueue(DesignALife.this);
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(final JSONArray response) {

                        length=response.length();
                        JSONObject obj = null;



                        for(int i=0;i<response.length();i++)
                        {
                            try {
                                //myarray.add(((JSONObject) response.get(i)).getString("countryName"));

                                obj=(JSONObject) response.get(i);
                                countryobj[i]=obj;
                                Log.e("DATA",obj.getString("countryName"));
                                details.put(obj.getString("countryName"),obj.getInt("countryid"));
                                final RadioButton rb=new RadioButton(DesignALife.this);
                                rb.setTextColor(Color.WHITE);
                                rb.setTextSize(20f);
                                rb.setButtonTintList(colorStateList);
                                rb.setText(obj.getString("countryName"));
                                ll.addView(rb);
                                rb.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Log.e("Value",rb.getText().toString());
                                        countryname=rb.getText().toString();


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

        req.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return  20000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 20000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        que.add(req);

    }



}

