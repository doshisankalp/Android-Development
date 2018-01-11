package com.example.anuja.reall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.anuja.reall.Adapter.DesignLifeAdapter;
import com.example.anuja.reall.Adapter.SelectCityAdapter;
import com.example.anuja.reall.Model.DesignLifeModel;
import com.example.anuja.reall.Model.SelectCityModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Selectcity extends AppCompatActivity {

    ArrayList<RadioButton> rba=new ArrayList<RadioButton>();
    static int length;
    static JSONObject countryObject;
    public static JSONObject retobj;
    public static String cityname;
    public static JSONObject cityObject[]=new JSONObject[350];
    ColorStateList colorStateList = null;


     List<SelectCityModel> myarray=new ArrayList<>();

    public List<SelectCityModel> temparray=new ArrayList<>();

    public static SelectCityModel selected_city=new SelectCityModel();
    private SelectCityAdapter scadapter;
    private RecyclerView recyclerView;

    private static SearchView searchCity;

    String url=Constant.GAMEURL+"characterDesign/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectcity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchCity=(SearchView)findViewById(R.id.searchtext);
        searchCity.setQueryHint("Search");
        Intent i=getIntent();
        try {
            countryObject=new JSONObject(i.getStringExtra("countryObject"));
            Log.e("CountryObject",countryObject.toString());
            url+=String.valueOf(countryObject.getString("countryid"));

        } catch (JSONException e) {
            e.printStackTrace();
        }



        recyclerView = (RecyclerView) findViewById(R.id.recycler_selectcity);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Selectcity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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


        if (cityname == null) {
            Toast.makeText(this, "Select one city", Toast.LENGTH_SHORT).show();
        } else {


            for (int i = 0; i < length; i++) {
                try {
                    if (cityObject[i].getString("cityName").equals(cityname)) {
                        retobj = cityObject[i];
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Intent intent = new Intent(Selectcity.this, AttributesActivity.class);
            intent.putExtra("countryObject", countryObject.toString());
            intent.putExtra("cityObject", retobj.toString());
            startActivity(intent);
        }

    }


    public void getCityName(String s)
    {
        cityname=s;
        System.out.println("citynameinselectcity"+cityname);

    }


    void getCities()
    {

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
                                //myarray.add(((JSONObject) response.get(i)).getString("countryName"));

                                obj=(JSONObject) response.get(i);
                                cityObject[i]=obj;
                                Log.e("DATA",obj.getString("cityName"));

                                SelectCityModel cityName=new SelectCityModel(obj.getString("cityName"));
                                myarray.add(cityName);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }

                        SelectCityAdapter scadapter=new SelectCityAdapter(myarray);
                        recyclerView.setAdapter(scadapter);


                        searchCity.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String query) {

                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(String newText) {

                                Log.e("character2",newText);
                                temparray.clear();
                                for(int i=0;i<myarray.size();i++)
                                {
                                    if(myarray.get(i).getCity().toLowerCase().contains(newText.toLowerCase()))
                                    {
                                        temparray.add(myarray.get(i));
                                    }
                                }

                                SelectCityAdapter scadapter2=new SelectCityAdapter(temparray);
                                recyclerView.setAdapter(scadapter2);
                                return false;
                            }
                        });


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


