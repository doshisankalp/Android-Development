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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ActivityFirstName extends AppCompatActivity {

    public static JSONObject countryObject;
    public static JSONObject cityObject;
    public static JSONObject traitsObject;
    String gender, locale, countryid, firstname;

    EditText nameText;
    ColorStateList colorStateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_name);

        nameText=(EditText)findViewById(R.id.nameText);


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

        /*Log.e("countryinAFN", countryObject.toString());
        Log.e("cityInAFN", cityObject.toString());
        Log.e("traitsinAFN", traitsObject.toString());
        Log.e("genderinAFN", gender);
        Log.e("localeinAFN", locale);*/


        generate();
    }


    void generate() {

        if (gender.equals("M")) {
            String url = Constant.GAMEURL+"characterDesign/maleNameList/" + countryid + "/M/F";
            final RadioButton rb[];
            final RadioGroup ll = new RadioGroup(ActivityFirstName.this);
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

            RequestQueue que = Volley.newRequestQueue(ActivityFirstName.this);
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
                                    final RadioButton rb = new RadioButton(ActivityFirstName.this);
                                    rb.setTextColor(Color.WHITE);
                                    rb.setTextSize(20f);
                                    rb.setButtonTintList(colorStateList);
                                    rb.setText(obj.getString("name"));
                                    ll.addView(rb);

                                    rb.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Log.e("Value", rb.getText().toString());
                                            firstname = rb.getText().toString();
                                            nameText.setText(firstname);
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

        } else if (gender.equals("F")) {

            String url =Constant.GAMEURL+"characterDesign/maleNameList/" + countryid + "/F/F";
            final RadioButton rb[];
            final RadioGroup ll = new RadioGroup(ActivityFirstName.this);
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

            RequestQueue que = Volley.newRequestQueue(ActivityFirstName.this);
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
                                    final RadioButton rb = new RadioButton(ActivityFirstName.this);
                                    rb.setTextColor(Color.WHITE);
                                    rb.setTextSize(20f);
                                    rb.setButtonTintList(colorStateList);
                                    rb.setText(obj.getString("name"));
                                    ll.addView(rb);

                                    rb.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Log.e("Value", rb.getText().toString());
                                            firstname = rb.getText().toString();
                                            nameText.setText(firstname);


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
