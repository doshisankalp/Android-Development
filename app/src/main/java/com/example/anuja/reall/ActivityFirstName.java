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
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.anuja.reall.Adapter.FirstNameAdapter;
import com.example.anuja.reall.Adapter.LoadlivesAdapter;
import com.example.anuja.reall.Model.FirstName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityFirstName extends AppCompatActivity {


    public static JSONObject countryObject;
    public static JSONObject cityObject;
    public static JSONObject traitsObject;
    String gender, locale, countryid, firstname;

    static String fname;

   public static FirstName selected_name=new FirstName();
    private FirstNameAdapter fnadapter;

    public List<FirstName> nameList=new ArrayList<>();
    private RecyclerView recyclerView;

    static EditText nameText;
    ColorStateList colorStateList;


    public void setName(String name)
    {
        fname=name;
        System.out.println("name in"+fname);
        nameText.setText(name);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_name);

        nameText=(EditText)findViewById(R.id.nameText);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_firstname);


        Intent i = getIntent();
        try {
            countryObject = new JSONObject(i.getStringExtra("countryObject"));
            cityObject = new JSONObject(i.getStringExtra("cityObject"));
            traitsObject = new JSONObject(i.getStringExtra("traitsObject"));
            gender = i.getStringExtra("gender");
            locale = i.getStringExtra("locale");
            countryid = countryObject.getString("countryid").toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(ActivityFirstName.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        generate();



    }


    void generate() {

        if (gender.equals("M")) {
            String url = Constant.GAMEURL+"characterDesign/maleNameList/" + countryid + "/M/F";


            RequestQueue que = Volley.newRequestQueue(ActivityFirstName.this);
            JsonArrayRequest req = new JsonArrayRequest(url,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            int length = response.length();
                            JSONObject obj = null;


                            for (int i = 0; i < response.length(); i++) {
                                try {


                                    obj = (JSONObject) response.get(i);
                                    Log.e("DATA", obj.getString("name"));

                                    FirstName name=new FirstName(obj.getString("name"));
                                    nameList.add(name);



                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }

                            FirstNameAdapter fnadapter=new FirstNameAdapter(nameList);
                            recyclerView.setAdapter(fnadapter);

                        }


                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {


                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    String token = pref.getString("token", null);
                    Log.e("x-auth-token", token);

                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/json");
                    headers.put("x-auth-token", token);
                    return headers;
                }


            };

            que.add(req);

        } else if (gender.equals("F")) {

            String url = Constant.GAMEURL+"characterDesign/maleNameList/" + countryid + "/F/F";
            RequestQueue que = Volley.newRequestQueue(ActivityFirstName.this);
            JsonArrayRequest req = new JsonArrayRequest(url,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            int length = response.length();
                            JSONObject obj = null;


                            for (int i = 0; i < response.length(); i++) {
                                try {


                                    obj = (JSONObject) response.get(i);
                                    Log.e("DATA", obj.getString("name"));

                                    FirstName name=new FirstName(obj.getString("name"));
                                    nameList.add(name);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }

                            FirstNameAdapter fnadapter=new FirstNameAdapter(nameList);
                            recyclerView.setAdapter(fnadapter);

                        }


                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {


                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    String token = pref.getString("token", null);
                    Log.e("x-auth-token", token);

                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/json");
                    headers.put("x-auth-token", token);
                    return headers;
                }


            };

            que.add(req);
        }
    }


    public void toSelectLastName(View view)
    {
        firstname=nameText.getText().toString();

        Intent intent=new Intent(ActivityFirstName.this,ActivitySurname.class);
        intent.putExtra("countryObject",countryObject.toString());
        intent.putExtra("cityObject",cityObject.toString());
        intent.putExtra("gender",gender);
        intent.putExtra("locale",locale);
        intent.putExtra("traitsObject",traitsObject.toString());
        intent.putExtra("firstName",firstname);

        startActivity(intent);



    }

    public void toselectcity(View v)
    {
        Intent intent=new Intent(ActivityFirstName.this,Selectcity.class);
        startActivity(intent);
    }
}
