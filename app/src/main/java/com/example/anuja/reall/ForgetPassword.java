package com.example.anuja.reall;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgetPassword extends AppCompatActivity {

    EditText emailid;
    String email;
    Button button;
    ProgressBar load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        emailid=(EditText)findViewById(R.id.emailID);
        load=(ProgressBar)findViewById(R.id.progressbar);
        load.setVisibility(View.GONE);

        button=(Button)findViewById(R.id.mybutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!isNetworkAvailable())
                {
                    Toast.makeText(ForgetPassword.this,"Please check you Internet Connection",Toast.LENGTH_SHORT).show();
                }
                else {


                    forgotPassword();
                }

            }
        });


    }


    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }




    public void forgotPassword() {
        email=emailid.getText().toString();
        if(emailid.getText().toString().isEmpty())
        {
            emailid.setError("Please Enter email id");
            return;

        }

        if(!isEmailValid(email)) {
            Toast.makeText(ForgetPassword.this, "Enter Vaild email id eg. abc@xyz.com", Toast.LENGTH_SHORT).show();
            return;
        }

        load.setVisibility(View.VISIBLE);


        String url = "http://192.168.1.124:9090/rlg/api/forgetPassword";
        RequestQueue que = Volley.newRequestQueue(ForgetPassword.this);

        JSONObject obj = new JSONObject();
        try {
            obj.put("to", "rohitraju3010@gmail.com");
            obj.put("subject", "Here is your temporary password for RealLives");
            obj.put("body", "This is your Password:");
            //obj.put("username","Roshni");
            // obj.put("password","Rohit");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {

                    Log.e("Status:",response.getString("status"));
                    Toast.makeText(ForgetPassword.this,"E-mail has been sent to you id", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(ForgetPassword.this,login.class);
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        })


        {
            /*
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("to","admin@gmail.com");
                params.put("subject","Here is your temporary password for RealLives");
                params.put( "body", "This is your Password:");
                return params;


            }*/

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };

        request.setRetryPolicy(new RetryPolicy() {
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

        que.add(request);


    }


    private boolean isNetworkAvailable()
    {
        ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo=connectivityManager.getActiveNetworkInfo();
        return activeNetInfo!=null && activeNetInfo.isConnected();
    }


}
