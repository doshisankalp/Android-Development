package com.example.anuja.reall;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
    boolean correct;
    Button button;
    EditText name,password;
    TextView register,forget;
    String username,password1;
    String url=Constant.APIURL+"login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.login);
        name=(EditText)findViewById(R.id.editText4);
        password=(EditText)findViewById(R.id.editText5);
        register=(TextView)findViewById(R.id.register);
        forget=(TextView)findViewById(R.id.textView1);

        username=name.getText().toString();
        password1=password.getText().toString();



        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                username = name.getText().toString();
                password1 = password.getText().toString();
                boolean valid, network;
                network = isNetworkAvailable();
                valid = validate();

                if(network==false)
                {
                    Toast.makeText(login.this,"Please check you Internet Connection",Toast.LENGTH_SHORT).show();
                }
                if (network == true) {
                    if (valid == true) {
                        login();
                    }
                }

            }
        });




        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });


        forget.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(login.this,ForgetPassword.class);
                startActivity(intent);
            }
        });

    }

    public void login() {
        final JSONObject jsonobject_one = new JSONObject();

        try {

            jsonobject_one.put("username",name.getText().toString());
            jsonobject_one.put("password",password.getText().toString());
            Log.e("JSONObject",jsonobject_one.toString());


        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("server",url);
        RequestQueue requestQueue= Volley.newRequestQueue(login.this);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST, url, jsonobject_one,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("hiiiiiiiiiiii", response.toString());


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                if (correct==false)
                {
                    name.setError("please enter valid username or password!");
                    Log.e("ERROR",error.toString());

                }


            }
        }) {

            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "text/plain");
                return headers;
            }

            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {

                Map<String,String> mymap=response.headers;


                for(Map.Entry<String,String> entry:mymap.entrySet())
                {
                    if(entry.getKey().equals("X-AUTH-TOKEN")) {
                        Log.e("key", entry.getKey());
                        Log.e("value", entry.getValue());
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("token",entry.getValue());
                        editor.putString("username",name.getText().toString());
                        editor.commit();
                        correct=true;
                        if(correct==true) {


                            Intent intent = new Intent(login.this, MainActivity.class);
                            startActivity(intent);
                        }




                    }



                }


                return super.parseNetworkResponse(response);



            }
        };


        jsonObjReq.setRetryPolicy(new RetryPolicy() {
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
        requestQueue.add(jsonObjReq);


    }


    public boolean validate(){
        boolean valid=true;
        if (username.isEmpty())
        {
            name.setError("please enter username!");
            valid=false;
        }
        if (password1.isEmpty())
        {
            password.setError("Please enter password!");
            valid=false;
        }
        return valid;
    }
    private boolean isNetworkAvailable()
    {
        ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo=connectivityManager.getActiveNetworkInfo();
        return activeNetInfo!=null && activeNetInfo.isConnected();
    }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(login.this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_quit, null);

        mBuilder.setView(dialogView);


        mBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               finish();
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        Dialog d = mBuilder.create();
        d.setContentView(dialogView);
        d.getWindow().setGravity(Gravity.CENTER);
        d.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(login.this, R.drawable.layout_bgnocorners));

        d.show();
    }


}