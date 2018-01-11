package com.example.anuja.reall;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.anuja.reall.R.drawable.glob;


public class register extends AppCompatActivity {
    private EditText et_fname,et_lname,et_country,et_email,et_mobile_number,et_username,et_password,et_conf_password;
    private String fname,lname,country,email,mobile_number,username,password,conf_password,fullname;
    Button button1;
    Spinner spinner;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    String countryname;
    HashMap<String, String> id1=new HashMap<String, String>();

   private ArrayList<String>mEntries=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.drawable.glob);
        setContentView(R.layout.activity_register);
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        et_fname = (EditText) findViewById(R.id.fname);
        et_lname = (EditText) findViewById(R.id.lname);
        // et_country = (EditText) findViewById(R.id.country1);
        et_mobile_number = (EditText) findViewById(R.id.mobile_number);
        et_email = (EditText) findViewById(R.id.email);
        et_username = (EditText) findViewById(R.id.username);
        et_password = (EditText) findViewById(R.id.password);
        et_conf_password = (EditText) findViewById(R.id.conf_password);

        spinner=(Spinner)findViewById(R.id.spinner);

        fetch();

        button1 = (Button) findViewById(R.id.button123);

        button1.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                register();


            }
        });

    }

    private void fetch() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest request = new JsonArrayRequest("http://192.168.1.124:9090/rlg/api/countryIsoCode",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {


                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                mEntries.add(jsonObject.getString("country"));
                                Log.e("DATA",mEntries.get(i));
                            } catch (JSONException e) {
                                mEntries.add("Error: " + e.getLocalizedMessage());
                            }
                        }

                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(register.this,
                                android.R.layout.simple_spinner_dropdown_item, mEntries);
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(arrayAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(register.this, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(request);

    }

    public void register()
    {
        initialize();
        if(!validate())
        {
            Toast.makeText(this,"Sign up has failed!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            onSignupSuccess();


        }
    }
    public void onSignupSuccess()
    {
        String url=Constant.APIURL+"register";
        RequestQueue requestQueue = Volley.newRequestQueue(register.this);
        JSONObject obj=new JSONObject();
        try {
            fullname=fname+" "+lname;
            int selectedId = radioGroup.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selectedId);
            obj.put("gender",radioButton.getText());
            obj.put("username",username);
            obj.put("password",password);
            obj.put("fullName",fullname);
            obj.put("emailId",email);
            obj.put("phoneNo",mobile_number);
            countryname=spinner.getSelectedItem().toString();
            Log.e("Country",countryname);
            obj.put("country",countryname);
            obj.put("code",id1.get(countryname));
            Log.e("Country code",id1.get(countryname));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url,obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    if(response.getString("status").equals("ok"))
                    {
                        AlertDialog.Builder mBuilder = new AlertDialog.Builder(register.this);
                        View dialogView = getLayoutInflater().inflate(R.layout.dialog_quit, null);

                        mBuilder.setMessage("Registered successfully !!!")
                                .setCancelable(true);


                        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i=new Intent(register.this,MainActivity.class);
                                startActivity(i);
                            }
                        });


                        Dialog d = mBuilder.create();
                        d.setContentView(dialogView);
                        d.getWindow().setGravity(Gravity.CENTER);
                        d.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(register.this, R.drawable.layout_bgnocorners));

                        d.show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            }
        , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(register.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_quit, null);

                mBuilder.setMessage("Registered failed !!!")
                        .setCancelable(true);


                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });


                Dialog d = mBuilder.create();
                d.setContentView(dialogView);
                d.getWindow().setGravity(Gravity.CENTER);
                d.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(register.this, R.drawable.layout_bgnocorners));

                d.show();
                error.printStackTrace();
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/json");
                return params;
            }
        };
        requestQueue.add(request);
    }

    public boolean validate()
    {
        boolean valid=true;
        if(fname.isEmpty()||fname.length()>32)
        {
            et_fname.setError("Please enter valid first name");
            valid=false;
        }
        if(lname.isEmpty()||lname.length()>32)
        {
            et_lname.setError("Please enter valid last name");
            valid=false;
        }
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(email.isEmpty() || !email.matches(emailPattern))
        {
            et_email.setError("Please enter valid email address");
            valid=false;
        }
        if(username.isEmpty())
        {
            et_username.setError("Please enter valid username");
            valid=false;
        }
        if(password.isEmpty())
        {
            et_password.setError("Please enter valid password");
            valid=false;
        }
        if(conf_password.isEmpty())
        {
            et_conf_password.setError("Please enter valid confirm password");
            valid=false;
        }
        if(!(password.equals(conf_password)))
        {
            et_conf_password.setError("Confirm password does not match");
            valid=false;
        }
        return valid;
    }
    public void initialize()
    {
        fname=et_fname.getText().toString().trim();
        lname=et_lname.getText().toString().trim();
        email=et_email.getText().toString().trim();
        mobile_number=et_mobile_number.getText().toString().trim();
        username=et_username.getText().toString().trim();
        password=et_password.getText().toString().trim();
        conf_password=et_conf_password.getText().toString().trim();
    }
}