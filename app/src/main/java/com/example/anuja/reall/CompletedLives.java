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
import com.example.anuja.reall.Adapter.CompletedlivesAdapter;
import com.example.anuja.reall.Adapter.LoadlivesAdapter;
import com.example.anuja.reall.Model.Completedlives;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CompletedLives extends AppCompatActivity {
    private List<Completedlives> completeList = new ArrayList<>();
    private RecyclerView recyclerView;
    String username = null;
    SharedPreferences pref;
    Completedlives selected_life=new Completedlives();
    private CompletedlivesAdapter mAdapter;
    String url = "http://192.168.1.124:9090/rlg/game/getAllSavedGamesInfoList/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Log.e("url1",url);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_lives);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pref = getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        username = pref.getString("username", "");
        Log.e("fromcompletedlife :", username);
        prepareCompletedLifeData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new CompletedlivesAdapter(completeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        Button button=(Button)findViewById(R.id.completedlifebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CompletedLives.this,StartLife.class);

                selected_life=(mAdapter.get_selected_life());
                System.out.println("selected id : "+selected_life.getReallivesGameId());
                int id=0;

                id=selected_life.getReallivesGameId();
                if(id==0)
                {
                    Toast.makeText(CompletedLives.this,"Please select from above!!!",Toast.LENGTH_LONG).show();
                }
                else {
                    intent.putExtra("ID", Integer.toString(id));
                    startActivity(intent);
                }
//
//
//
//
//                System.out.println("hey from clcikded");
            }
        });


    }

    private void prepareCompletedLifeData() {

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

                                if(status.equals("END_GAME")){
                                    Completedlives life = new Completedlives(jsonObject.getString("name"),jsonObject.getInt("age"),jsonObject.getString("sex"),jsonObject.getString("countryName"),jsonObject.getInt("reallivesGameId"));
                                    completeList.add(life);
                                }



                            }
                            CompletedlivesAdapter mAdapter=new CompletedlivesAdapter(completeList);
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
                pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
                String token=pref.getString("token","");
                Log.e("token",token);
                headers.put("Content-Type", "application/json");
                headers.put("x-auth-token",token);
                return headers;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void tomainactivity(View view) {
        Intent intent = new Intent(CompletedLives.this, MainActivity.class);
        startActivity(intent);
    }
}

