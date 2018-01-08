package com.example.anuja.reall;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Loading extends AppCompatActivity {
    Intent i;
    VideoView videoView;
    SharedPreferences pref;
    static String ID="";
    MediaPlayer mp;
    int start=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        videoView = (VideoView) findViewById(R.id.videoView);
        Uri uri=Uri.parse("android.resource://com.example.anuja.reall/raw/creating_life");
        videoView.setVideoURI(uri);
        videoView.start();
        request();

        //Intent intent = new Intent(Loading.this, StartLife.class);
        //intent.putExtra("ID",ID);
        //startActivity(intent);
        videoView.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        /*Uri uri=Uri.parse("android.resource://com.example.anuja.reall/raw/creating_life");
        videoView.setVideoURI(uri);
        videoView.start();*/
    }

    private void request() {
        String username;
        pref=getApplication().getSharedPreferences("Options",MODE_PRIVATE);
        username=pref.getString("username","");
        Log.e("username",username);
        String url=Constant.GAMEURL+"createlife/"+username+"/false/false";
        final JSONObject jsonobject_one = new JSONObject();
        try {
            jsonobject_one.put("age","1");
            jsonobject_one.put("sex","F");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestQueue requestQueue= Volley.newRequestQueue(Loading.this);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST, url, jsonobject_one,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                ID=error.toString().split(" ")[3];
                Log.e("ID",ID);
                Intent intent = new Intent(Loading.this, StartLife.class);
                intent.putExtra("ID",ID);
                Log.e("In loading",ID);
                startActivity(intent);
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

    public void tostartlife(View view) {
        Intent intent = new Intent(Loading.this, StartLife.class);
        intent.putExtra("ID",ID);
        Log.e("send to start",ID);
        startActivity(intent);

    }
}

