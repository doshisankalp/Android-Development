package com.example.anuja.reall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.anuja.reall.Adapter.LoadlivesAdapter;
import com.example.anuja.reall.Model.Loadlives;
import com.android.volley.RequestQueue;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Loadlife extends AppCompatActivity {
    private List<Loadlives> livesList = new ArrayList<>();
    private RecyclerView recyclerView;
    String username = null;
    SharedPreferences pref;
    Loadlives selected_life=new Loadlives();
    private LoadlivesAdapter mAdapter;
    String url = Constant.GAMEURL+"getAllSavedGamesInfoList/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Log.e("url1",url);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadlife);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pref = getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        username = pref.getString("username", "");
        Log.e("fromloadlife :", username);
        prepareLoadlifeData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new LoadlivesAdapter(livesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        Button button=(Button)findViewById(R.id.loadlifebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Loadlife.this,StartLife.class);


                selected_life=(mAdapter.get_selected_life());
                System.out.println("selected id : "+selected_life.getReallivesGameId());
                int id=selected_life.getReallivesGameId();
                intent.putExtra("ID",Integer.toString(id));
                startActivity(intent);
//
//
//
//
//                System.out.println("hey from clcikded");
            }
        });


    }

    private void prepareLoadlifeData() {

        url = url.concat(username);
        Log.e("url:", url);

        // mAdapter.notifyDataSetChanged();


        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.e("enterd:", "into onresp");
                            JSONObject jsonObject;
                            String status=null;

                            JSONArray jsonArray = new JSONArray(response);
                            jsonObject = jsonArray.getJSONObject(1);

                            Log.e("jsonobj:", jsonObject.getString("status"));
                            for (int i = 0; i < jsonArray.length(); i++) {
                                jsonObject = jsonArray.getJSONObject(i);
                                status=jsonObject.getString("status");

                                if(status.equals("IN_PROGESS")){
                                    Loadlives life = new Loadlives(jsonObject.getString("name"),jsonObject.getInt("age"),jsonObject.getString("sex"),jsonObject.getString("countryName"),jsonObject.getInt("reallivesGameId"));
                                    livesList.add(life);
                                }



                            }
                            LoadlivesAdapter mAdapter=new LoadlivesAdapter(livesList);
                            recyclerView.setAdapter(mAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
                Log.e("enterd:", "into onresp");
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                headers.put("x-auth-token", "eyJ1c2VyUm9sZUlkIjowLCJ1c2VySWQiOjMsInJvbGVDb2RlIjpudWxsLCJkZXNjIjpudWxsLCJnYW1lU2V0dGluZ3MiOm51bGwsImZ1bGxOYW1lIjpudWxsLCJlbWFpbElkIjpudWxsLCJhY3RpdmUiOnRydWUsImNvdW50cnkiOm51bGwsImNvZGUiOm51bGwsInB1cmNoYXNlRmFsZyI6bnVsbCwiY3VycmVudERhdGUiOm51bGwsImJpcnRoRGF0ZSI6bnVsbCwiZ2VuZGVyIjpudWxsLCJ1c2VybmFtZSI6ImthcnVuYWRhbmRlMTEzIiwiYWNjb3VudEV4cGlyZWQiOmZhbHNlLCJhY2NvdW50TG9ja2VkIjpmYWxzZSwiY3JlZGVudGlhbHNFeHBpcmVkIjpmYWxzZSwiYWNjb3VudERpc2FibGVkIjpmYWxzZSwiYXV0aG9yaXRpZXMiOlt7InVzZXJJZCI6MywiYXV0aG9yaXR5IjoiUk9MRV9HQU1FVVNFUiJ9XSwiZXhwaXJlcyI6MTUxNDg2OTgzODE1MywiZm9yZ2V0UGFzc3dvcmRGbGFnIjpmYWxzZX0=.PeHIzyrcrUm+0IzQHSnf0+IVjhdYavDKXzDptuKBxsE=");
                return headers;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void tomainactivity(View view) {
        Intent intent = new Intent(Loadlife.this, MainActivity.class);
        startActivity(intent);
    }
}

