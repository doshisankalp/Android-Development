package com.example.anuja.reall;


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

import static android.content.Context.MODE_PRIVATE;
import static com.example.anuja.reall.AttributesActivity.countryObject;



public class FirstNameFragment extends Fragment {

    static String countryid,mygender,firstname;
    ColorStateList colorStateList;
    public FirstNameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v=inflater.inflate(R.layout.fragment_first_name,container,false);



        //Log.e("traits",traitsObject2.toString());

        try {
            countryid=(countryObject.get("countryid")).toString();
            Log.e("countryid",countryid);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        SharedPreferences pref = getActivity().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
        final SharedPreferences.Editor editor = pref.edit();
        mygender=pref.getString("sex",null);
        Log.e("gender in fnf",mygender);


        if(mygender.equals("M"))
        {
            String url="http://192.168.1.124:9090/rlg/game/characterDesign/maleNameList/"+countryid+"/M/F";
            final RadioButton rb[];
            final RadioGroup ll = new RadioGroup(getContext());
            ll.setOrientation(LinearLayout.VERTICAL);



            if(Build.VERSION.SDK_INT>=21)
            {

                colorStateList = new ColorStateList(
                        new int[][]{

                                new int[]{-android.R.attr.state_enabled}, //disabled
                                new int[]{android.R.attr.state_enabled} //enabled
                        },
                        new int[] {

                                Color.BLACK //disabled
                                ,Color.CYAN //enabled

                        }
                );


                //radio.setButtonTintList(colorStateList);//set the color tint list
                //radio.invalidate(); //could not be necessary
            }

            RequestQueue que= Volley.newRequestQueue(getContext());
            JsonArrayRequest req = new JsonArrayRequest(url,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            int length = response.length();
                            JSONObject obj = null;


                            for(int i=0;i<response.length();i++)
                            {
                                try {
                                    //myarray.add(((JSONObject) response.get(i)).getString("countryName"));

                                    obj=(JSONObject) response.get(i);
                                    Log.e("DATA",obj.getString("name"));
                                    final RadioButton rb=new RadioButton(getContext());
                                    rb.setTextColor(Color.WHITE);
                                    rb.setTextSize(20f);
                                    rb.setButtonTintList(colorStateList);
                                    rb.setText(obj.getString("name"));
                                    ll.addView(rb);

                                    rb.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Log.e("Value",rb.getText().toString());
                                            firstname=rb.getText().toString();
                                            editor.putString("firstname",firstname);
                                            editor.commit();
                                        }
                                    });


                                    //Log.d("DATA",myarray.get(i));




                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                            ((ViewGroup)v.findViewById(R.id.choices)).addView(ll);

                        }




                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            })
            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {


                    SharedPreferences pref = getActivity().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    String token=pref.getString("token",null);
                    Log.e("x-auth-token",token);

                    HashMap<String,String> headers=new HashMap<>();
                    headers.put("Content-Type","application/json");
                    headers.put("x-auth-token",token);
                    return headers;
                }


            };

            que.add(req);

        }

        else if(mygender.equals("F"))
        {

            String url="http://192.168.1.124:9090/rlg/game/characterDesign/maleNameList/"+countryid+"/F/F";
            final RadioButton rb[];
            final RadioGroup ll = new RadioGroup(getContext());
            ll.setOrientation(LinearLayout.VERTICAL);



            if(Build.VERSION.SDK_INT>=21)
            {

                colorStateList = new ColorStateList(
                        new int[][]{

                                new int[]{-android.R.attr.state_enabled}, //disabled
                                new int[]{android.R.attr.state_enabled} //enabled
                        },
                        new int[] {

                                Color.BLACK //disabled
                                ,Color.CYAN //enabled

                        }
                );


                //radio.setButtonTintList(colorStateList);//set the color tint list
                //radio.invalidate(); //could not be necessary
            }

            RequestQueue que= Volley.newRequestQueue(getContext());
            JsonArrayRequest req = new JsonArrayRequest(url,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            int length = response.length();
                            JSONObject obj = null;


                            for(int i=0;i<response.length();i++)
                            {
                                try {
                                    //myarray.add(((JSONObject) response.get(i)).getString("countryName"));

                                    obj=(JSONObject) response.get(i);
                                    Log.e("DATA",obj.getString("name"));
                                    final RadioButton rb=new RadioButton(getContext());
                                    rb.setTextColor(Color.WHITE);
                                    rb.setTextSize(20f);
                                    rb.setButtonTintList(colorStateList);
                                    rb.setText(obj.getString("name"));
                                    ll.addView(rb);

                                    rb.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Log.e("Value",rb.getText().toString());
                                            firstname=rb.getText().toString();
                                            editor.putString("firstname",firstname);
                                            editor.commit();
                                        }
                                    });


                                    //Log.d("DATA",myarray.get(i));




                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                            ((ViewGroup)v.findViewById(R.id.choices)).addView(ll);

                        }




                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            })
            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {


                    SharedPreferences pref = getActivity().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    String token=pref.getString("token",null);
                    Log.e("x-auth-token",token);

                    HashMap<String,String> headers=new HashMap<>();
                    headers.put("Content-Type","application/json");
                    headers.put("x-auth-token",token);
                    return headers;
                }


            };

            que.add(req);

        }








        return v;
    }

}
