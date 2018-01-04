package com.example.anuja.reall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.AuthFailureError;
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

import java.util.HashMap;
import java.util.Map;

public class ActivitySurname extends AppCompatActivity {
    public static JSONObject countryObject;
    public static JSONObject cityObject;
    public static JSONObject traitsObject;
    public static  JSONObject finalobj=new JSONObject();
    String gender, locale, countryid, firstname,lastname,ID;
     EditText surnameText;
    ProgressBar load;
    ColorStateList colorStateList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surname);


        load=(ProgressBar)findViewById(R.id.load);
        load.setVisibility(View.GONE);
        Intent i = getIntent();
        try {
            countryObject = new JSONObject(i.getStringExtra("countryObject"));
            cityObject = new JSONObject(i.getStringExtra("cityObject"));
            traitsObject = new JSONObject(i.getStringExtra("traitsObject"));
            gender = i.getStringExtra("gender");
            locale = i.getStringExtra("locale");
            countryid = countryObject.getString("countryid").toString();
            firstname=i.getStringExtra("firstName");
            surnameText=(EditText)findViewById(R.id.nameText);



        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.e("countryinAS", countryObject.toString());
        Log.e("cityInAS", cityObject.toString());
        Log.e("traitsinAS", traitsObject.toString());
        Log.e("genderinAS", gender);
        Log.e("localeinAS", locale);
        Log.e("firstNameinAS",firstname);



        generate();
    }




    void generate() {

            String url =Constant.GAMEURL+"characterDesign/maleNameList/" + countryid + "/N/L";
            final RadioButton rb[];
            final RadioGroup ll = new RadioGroup(ActivitySurname.this);
            ll.setOrientation(LinearLayout.VERTICAL);


            if (Build.VERSION.SDK_INT >= 21) {

                colorStateList = new ColorStateList(
                        new int[][]{

                                new int[]{-android.R.attr.state_enabled}, //disabled
                                new int[]{android.R.attr.state_enabled} //enabled
                        },
                        new int[]{

                                Color.BLACK //disabled
                                , Color.CYAN //enabled

                        }
                );


                //radio.setButtonTintList(colorStateList);//set the color tint list
                //radio.invalidate(); //could not be necessary
            }

            RequestQueue que = Volley.newRequestQueue(ActivitySurname.this);
            JsonArrayRequest req = new JsonArrayRequest(url,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            int length = response.length();
                            JSONObject obj = null;


                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    //myarray.add(((JSONObject) response.get(i)).getString("countryName"));

                                    obj = (JSONObject) response.get(i);
                                    Log.e("DATA", obj.getString("name"));
                                    final RadioButton rb = new RadioButton(ActivitySurname.this);
                                    rb.setTextColor(Color.WHITE);
                                    rb.setTextSize(20f);
                                    rb.setButtonTintList(colorStateList);
                                    rb.setText(obj.getString("name"));
                                    ll.addView(rb);

                                    rb.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Log.e("Value", rb.getText().toString());
                                            lastname = rb.getText().toString();
                                            surnameText.setText(lastname);
                                        }
                                    });


                                    //Log.d("DATA",myarray.get(i));


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                            ((ViewGroup) findViewById(R.id.choices)).addView(ll);

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


        public void tostartlife(View view)
        {
            load.setVisibility(View.VISIBLE);
            lastname=String.valueOf(surnameText.getText());
            Log.e("lastname from editText",lastname);
            createLifeObject();



        }


        public void toSelectFirstName(View view)
        {
            Intent intent=new Intent(ActivitySurname.this,ActivityFirstName.class);
            startActivity(intent);
        }



    public void createLifeObject() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        String username = pref.getString("username", null);
        String url = Constant.GAMEURL+"createlife/" + username + "/true/false";
        Log.e("final url",url);



        try {
            finalobj.put("city", cityObject);
            finalobj.put("country", countryObject);
            finalobj.put("firstName", firstname);
            finalobj.put("lastName", lastname);
            finalobj.put("nameGroupId", 0);
            finalobj.put("onlyCountry", false);
            finalobj.put("sex", gender);
            finalobj.put("traits",traitsObject);
            finalobj.put("urbanRular", locale);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.e("FINAL OBJECT", finalobj.toString());


        RequestQueue requestQueue = Volley.newRequestQueue(ActivitySurname.this);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST, url, finalobj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Response is:", response.toString());


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {



                ID=error.toString().split(" ")[3];
                Log.e("ID",ID);

                Intent intent=new Intent(ActivitySurname.this,StartLife.class);
                intent.putExtra("ID",ID);
                startActivity(intent);



            }
        }) {

            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                String token = pref.getString("token", null);
                //Log.e("x-auth-token", token);

                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                headers.put("x-auth-token", token);
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
}
