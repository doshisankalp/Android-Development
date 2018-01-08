package com.example.anuja.reall;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.security.AccessController.getContext;

public class CompletedLives extends AppCompatActivity {
    int length;
    SharedPreferences pref;
    Button showlife;
    ColorStateList colorStateList = null;
    public static int countryid;
    HashMap<String,Integer> id=new HashMap<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_lives);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showlife=(Button)findViewById(R.id.showlifebutton);


        getCountries();

        Log.e("id",String.valueOf(countryid));

showlife.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
          Intent intent = new Intent(CompletedLives.this, StartLife.class);
           intent.putExtra("ID",String.valueOf(countryid));
           Log.e("hi", String.valueOf(countryid));
         startActivity(intent);
    }
});
    }
   // public void tomainactivity(View view) {
       // Intent intent = new Intent(CompletedLives.this, MainActivity.class);
      //  startActivity(intent);
    //}

    public void goto_selectcity(View view) {
      //  Intent intent = new Intent(DesignALife.this, Selectcity.class);
     //   intent.putExtra("countryId",countryid);
       // startActivity(intent);


    }





    @SuppressLint("WrongConstant")
    void getCountries()
    {
        String username;
        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        username=pref.getString("username","");
        Log.e("username",username);

        String url=Constant.GAMEURL+"getAllSavedGamesInfoList/"+username;
        final ArrayList<String> myarray=new ArrayList<String>();
        final RadioButton rb[];
        final TextView blank[];
        final RadioGroup ll = new RadioGroup(CompletedLives.this);
        ll.setOrientation(LinearLayout.VERTICAL);
       /* final CardView card = new CardView(CompletedLives.this);

        // Set the CardView layoutParams
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        card.setLayoutParams(params);

        card.setCardBackgroundColor(Color.TRANSPARENT);*/
        if(Build.VERSION.SDK_INT>=21)
        {

            colorStateList = new ColorStateList(
                    new int[][]{

                            new int[]{-android.R.attr.state_enabled }, //disabled
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

        RequestQueue que= Volley.newRequestQueue(CompletedLives.this);
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(final JSONArray response) {

                        length=response.length();
                        JSONObject obj = null;



                        for(int i=0;i<response.length();i++)
                        {
                            try {
                                //myarray.add(((JSONObject) response.get(i)).getString("countryName"));


                                obj=(JSONObject) response.get(i);

                                if(obj.getString("status").equals("END_GAME")) {


                                    Log.e("DATA", obj.getString("status"));
                                    id.put(obj.getString("name"), obj.getInt("reallivesGameId"));



                                    final RadioButton rb = new RadioButton(CompletedLives.this);
                                    final TextView tv=new TextView(CompletedLives.this);
                                    rb.setTextColor(Color.WHITE);
                                    rb.setTextSize(20f);
                                    rb.setButtonTintList(colorStateList);
                                    rb.setText(obj.getString("name"));
                                    ll.addView(rb);
                                    ll.addView(tv);

                                    rb.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Log.e("Value", rb.getText().toString());
                                            countryid = id.get(rb.getText().toString());
                                            Log.e("Value", String.valueOf(countryid));




                                        }
                                    });
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }



                        ((LinearLayout)findViewById(R.id.choices)).addView(ll);

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
                SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                String token=pref.getString("token",null);
                Log.e("x-auth-token",token);

                HashMap<String,String> headers=new HashMap<>();
                headers.put("Content-Type","application/json");
                headers.put("x-auth-token",token);
                return headers;
            }


        };

        req.setRetryPolicy(new RetryPolicy() {
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

        que.add(req);

    }







    public void     tomainactivity(View view) {

        Intent intent = new Intent(CompletedLives.this, MainActivity.class);
        startActivity(intent);
    }

}
