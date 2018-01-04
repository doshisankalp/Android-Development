package com.example.anuja.reall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
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

import static android.content.Context.MODE_PRIVATE;
import static com.example.anuja.reall.AttributesActivity.cityObject;
import static com.example.anuja.reall.AttributesActivity.countryObject;
import static com.example.anuja.reall.AttributesActivity.traitsObject;
import static com.example.anuja.reall.AttributesActivity.traitsObject2;

/**
 * Created by ANUJA on 08/Jun/2017.
 */

public class SurnameFragment extends Fragment {

    //RadioButton rb;
    static String countryid,gender,lastname;
    ColorStateList colorStateList;
    JSONObject finalobj=new JSONObject();
    Button playlife;
    public static String ID;
    public SurnameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //rb=new RadioButton(this);


        super.onCreate(savedInstanceState);
    }


    public void createLifeObject() {
        SharedPreferences pref = this.getActivity().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        String url = "http://192.168.1.124:9090/rlg/game/createlife/"+pref.getString("username",null)+"/true/false";
        Log.e("final url",url);


        Log.e("firstname from fnf", pref.getString("firstname", null));
        Log.e("sex from pf", pref.getString("sex", null));
        try {
            finalobj.put("city", cityObject);
            finalobj.put("country", countryObject);
            finalobj.put("firstName", pref.getString("firstname", null));
            finalobj.put("lastName", lastname);
            finalobj.put("nameGroupId", 0);
            finalobj.put("onlyCountry", false);
            finalobj.put("sex", pref.getString("sex", null));
            finalobj.put("traits", traitsObject2);
            finalobj.put("urbanRular", PersonalityFragment.locale);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.e("FINAL OBJECT", finalobj.toString());


        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST, url, finalobj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.e("Response is:", response.toString());


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                ID=error.toString().split(" ")[3];
                Log.e("ID in surname:",ID);

                Intent i=new Intent(getActivity(),StartLife.class);
                i.putExtra("ID",ID);
                startActivity(i);

            }
        }) {

            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences pref = getActivity().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
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

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_surname, container, false);

        playlife = v.findViewById(R.id.playlifebutton);

        //Log.e("traits",traitsObject2.toString());

        try {
            countryid = (countryObject.get("countryid")).toString();

            //gender= (String)traitsObject2.get("sex");
            SharedPreferences pref = getActivity().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            gender = pref.getString("sex", null);
            //Log.e("gender from sp",gender);
            //Log.e("countryid",countryid);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        String url = "http://192.168.1.124:9090/rlg/game/characterDesign/maleNameList/" + countryid + "/N/L";
        final RadioButton rb[];
        final RadioGroup ll = new RadioGroup(getContext());
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

        RequestQueue que = Volley.newRequestQueue(getContext());
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
                                final RadioButton rb = new RadioButton(getContext());
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
                                    }
                                });


                                //Log.d("DATA",myarray.get(i));


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                        ((ViewGroup) v.findViewById(R.id.choices)).addView(ll);

                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {


                SharedPreferences pref = getActivity().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
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

        playlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createLifeObject();

            }
        });


        return v;


    }



}
