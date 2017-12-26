package com.example.anuja.reall;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String url="http://192.168.1.124:9090/rlg/game/createlife/karunadande113/false/false";
        RequestQueue requestQueue= Volley.newRequestQueue(Loading.this);
        StringRequest sr= new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Loading.this,response.trim(),Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("x-auth-token", "eyJ1c2VyUm9sZUlkIjowLCJ1c2VySWQiOjMsInJvbGVDb2RlIjpudWxsLCJkZXNjIjpudWxsLCJnYW1lU2V0dGluZ3MiOm51bGwsImZ1bGxOYW1lIjpudWxsLCJlbWFpbElkIjpudWxsLCJhY3RpdmUiOnRydWUsImNvdW50cnkiOm51bGwsImNvZGUiOm51bGwsInB1cmNoYXNlRmFsZyI6bnVsbCwiY3VycmVudERhdGUiOm51bGwsImJpcnRoRGF0ZSI6bnVsbCwiZ2VuZGVyIjpudWxsLCJ1c2VybmFtZSI6ImthcnVuYWRhbmRlMTEzIiwiYWNjb3VudEV4cGlyZWQiOmZhbHNlLCJhY2NvdW50TG9ja2VkIjpmYWxzZSwiY3JlZGVudGlhbHNFeHBpcmVkIjpmYWxzZSwiYWNjb3VudERpc2FibGVkIjpmYWxzZSwiYXV0aG9yaXRpZXMiOlt7InVzZXJJZCI6MywiYXV0aG9yaXR5IjoiUk9MRV9HQU1FVVNFUiJ9XSwiZXhwaXJlcyI6MTUxNDI2MzUzODI1NywiZm9yZ2V0UGFzc3dvcmRGbGFnIjpmYWxzZX0=.PMCQVtmFssqQB0zeQbcW6h+pUWdGldR/cWWdlHHLyvI=");
                return headers;
            }
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("age", "1");
                params.put("sex", "M");
                return params;
            }

        };

       /* sr.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {

                return 100000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 100000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });*/
        requestQueue.add(sr);

    }



    public void tostartlife(View view) {
      /*  Intent intent = new Intent(Loading.this, StartLife.class);
        startActivity(intent);
        finish();*/

    }
    }

