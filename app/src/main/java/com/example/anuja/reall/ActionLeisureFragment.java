package com.example.anuja.reall;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.anuja.reall.Adapter.LoadlivesAdapter;
import com.example.anuja.reall.Model.Loadlives;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;
import static java.lang.Thread.sleep;

/**
 * Created by ANUJA on 09/Jun/2017.
 */

public class ActionLeisureFragment extends Fragment {
    static CheckBox arts, social, religious, volunteer, outdoor, television, fashion, play, study, endurance, sports, music;
    SharedPreferences pref;
    static JSONObject whole_object,artobject,socialobject,religiousobject,volunteerobject,outdoorobject,teleisionobject,fasionobject,playobject,studyobject,enduranceobject,sportsobject,musicobject;
    static JSONArray leisure;
    static JSONObject self;
    static String age,time,id;
    static  int count=0;
    private ViewPager viewPager;
    String url=Constant.GAMEURL+"actionbar/leisure/";
    static String arts1, social1, religious1, volunteer1, outdoor1, television1, fashion1, play1, study1, endurance1, sports1, music1;

    RequestQueue requestQueue,requestQueue2;


    Button send;

    public static Context baseContext;
    public ActionLeisureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        baseContext = getActivity();


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.actionfragment_leisure, container, false);
count=0;



        arts = (CheckBox) v.findViewById(R.id.CB1);
        social = (CheckBox) v.findViewById(R.id.CB2);
        religious = (CheckBox) v.findViewById(R.id.CB3);
        volunteer = (CheckBox) v.findViewById(R.id.CB4);
        outdoor = (CheckBox) v.findViewById(R.id.CB5);
        television = (CheckBox) v.findViewById(R.id.CB6);
        fashion = (CheckBox) v.findViewById(R.id.CB7);
        play = (CheckBox) v.findViewById(R.id.CB8);
        study = (CheckBox) v.findViewById(R.id.CB9);
        endurance = (CheckBox) v.findViewById(R.id.CB10);
        sports = (CheckBox) v.findViewById(R.id.CB11);
        music = (CheckBox) v.findViewById(R.id.CB12);


        send=(Button)v.findViewById(R.id.savebutton);






        leisure();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sendleisure();
                } catch (JSONException e) {
                        e.printStackTrace();
                }
            }
        });










        return v;




    }



    public void sendleisure() throws JSONException {
        requestQueue2=Volley.newRequestQueue(getActivity());



        JSONArray arr = new JSONArray();
        JSONObject art=new JSONObject();
        JSONObject social2=new JSONObject();
        JSONObject religious2=new JSONObject();
        JSONObject volunteer2=new JSONObject();
        JSONObject outdoor2=new JSONObject();
        JSONObject televison2=new JSONObject();
        JSONObject fashion2=new JSONObject();
        JSONObject play2=new JSONObject();
        JSONObject study2=new JSONObject();
        JSONObject endurance2=new JSONObject();
        JSONObject sports2=new JSONObject();
        JSONObject music2=new JSONObject();


        art.put( "leisure_code","ART");
        art.put("leisure_name", "ART");
        art.put("selected", arts.isChecked());
        art.put("enabled",arts.isEnabled());


        social2.put( "leisure_code","SOCIAL_OR_POLITICAL_ACTIVITIES");
        social2.put("leisure_name", "SOCIAL_OR_POLITICAL_ACTIVITIES");
        social2.put("selected", social.isChecked());
        social2.put("enabled",social.isEnabled());

        religious2.put( "leisure_code","RELIGIOUS_ACTIVITY");
        religious2.put("leisure_name", "RELIGIOUS_ACTIVITY");
        religious2.put("selected", religious.isChecked());
        religious2.put("enabled",religious.isEnabled());

        volunteer2.put( "leisure_code","VOLUNTEERING");
        volunteer2.put("leisure_name", "VOLUNTEERING");
        volunteer2.put("selected",volunteer.isChecked());
        volunteer2.put("enabled",volunteer.isEnabled());

        outdoor2.put( "leisure_code","OUTDOOR_ACTIVITIES");
        outdoor2.put("leisure_name", "OUTDOOR_ACTIVITIES");
        outdoor2.put("selected",outdoor.isChecked());
        outdoor2.put("enabled",outdoor.isEnabled());

        televison2.put( "leisure_code","TELEVISION_VIEWING");
        televison2.put("leisure_name", "TELEVISION_VIEWING");
        televison2.put("selected",television.isChecked());
        televison2.put("enabled",television.isEnabled());

        fashion2.put( "leisure_code","FASHION_CLOTHING_APPEARANCE");
        fashion2.put("leisure_name", "FASHION_CLOTHING_APPEARANCE");
        fashion2.put("selected",fashion.isChecked());
        fashion2.put("enabled",fashion.isEnabled());

        play2.put( "leisure_code","PLAY");
        play2.put("leisure_name", "PLAY");
        play2.put("selected",play.isChecked());
        play2.put("enabled",play.isEnabled());

        study2.put( "leisure_code","READING_STUDY");
        study2.put("leisure_name", "READING_STUDY");
        study2.put("selected",study.isChecked());
        study2.put("enabled",study.isEnabled());

        endurance2.put( "leisure_code","ENDURANCE");
        endurance2.put("leisure_name", "ENDURANCE");
        endurance2.put("selected",endurance.isChecked());
        endurance2.put("enabled",endurance.isEnabled());

        sports2.put( "leisure_code","SPORTS");
        sports2.put("leisure_name", "SPORTS");
        sports2.put("selected",sports.isChecked());
        sports2.put("enabled",sports.isEnabled());

        music2.put( "leisure_code","MUSIC");
        music2.put("leisure_name", "MUSIC");
        music2.put("selected",music.isChecked());
        music2.put("enabled",music.isEnabled());


















        arr.put(art);
        arr.put(social2);
        arr.put(religious2);
        arr.put(volunteer2);
        arr.put(outdoor2);
        arr.put(televison2);
        arr.put(fashion2);
        arr.put(play2);
        arr.put(study2);
        arr.put(endurance2);
        arr.put(sports2);
        arr.put(music2);

//...
        Log.e("array",String.valueOf(arr));

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.PUT,Constant.GAMEURL+"actionbar/leisure/"+id,arr,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        Log.e("hi",String.valueOf(response));





                    }



                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {


                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                pref = getActivity().getSharedPreferences("Options", MODE_PRIVATE);
                String token = pref.getString("token", "");
                Log.e("token", token);
                headers.put("Content-Type", "application/json");
                headers.put("x-auth-token", token);
                return headers;
            }
        };


        requestQueue2.add(request);





    }

    public static void statusen() {

        if (!arts.isChecked()) {
            arts.setEnabled(true);
        }
        if (!music.isChecked()) {
            music.setEnabled(true);
        }
        if (!social.isChecked()) {
            social.setEnabled(true);
        }
        if (!religious.isChecked()) {
            religious.setEnabled(true);
        }
        if (!volunteer.isChecked()) {
            volunteer.setEnabled(true);
        }
        if (!outdoor.isChecked()) {
            outdoor.setEnabled(true);
        }
        if (!television.isChecked()) {
            television.setEnabled(true);
        }
        if (!fashion.isChecked()) {
            fashion.setEnabled(true);
        }
        if (!play.isChecked()) {
            play.setEnabled(true);
        }
        if (!study.isChecked()) {
            study.setEnabled(true);
        }
        if (!endurance.isChecked()) {
            endurance.setEnabled(true);
        }
        if (!sports.isChecked()) {
            sports.setEnabled(true);
        }
    }


    public static void statusdis() {

        if (!arts.isChecked()) {
            arts.setEnabled(false);
        }
        if (!music.isChecked()) {
            music.setEnabled(false);
        }
        if (!social.isChecked()) {
            social.setEnabled(false);
        }
        if (!religious.isChecked()) {
            religious.setEnabled(false);
        }
        if (!volunteer.isChecked()) {
            volunteer.setEnabled(false);
        }
        if (!outdoor.isChecked()) {
            outdoor.setEnabled(false);
        }
        if (!television.isChecked()) {
            television.setEnabled(false);
        }
        if (!fashion.isChecked()) {
            fashion.setEnabled(false);
        }
        if (!play.isChecked()) {
            play.setEnabled(false);
        }
        if (!study.isChecked()) {
            study.setEnabled(false);
        }
        if (!endurance.isChecked()) {
            endurance.setEnabled(false);
        }
        if (!sports.isChecked()) {
            sports.setEnabled(false);
        }


    }
    public void leisure(){
        requestQueue=Volley.newRequestQueue(getActivity());

        pref = getActivity().getSharedPreferences("Options", MODE_PRIVATE);
        String object = pref.getString("whole_object", "");



        try {
            whole_object = new JSONObject(object);
            Log.e("whole",String.valueOf(whole_object));
            self=whole_object.getJSONObject("SELF");
            time=self.getString("leisureTimeAvailable");
            age=self.getString("age");
            id=self.getString("reallivesGameId");
            Log.e("age1",id);
            Log.e("time",time);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,Constant.GAMEURL+"actionbar/leisure/"+id,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.e("response",String.valueOf(response));
                        try {
                            leisure=response.getJSONArray("leisure");

                            artobject=leisure.getJSONObject(0);
                            arts.setChecked(Boolean.parseBoolean(artobject.getString("selected")));
                            if(Boolean.parseBoolean(artobject.getString("selected")))
                            {
                                count++;
                            }
                            arts1=artobject.getString("enabled");



                            musicobject=leisure.getJSONObject(1);
                            music.setChecked(Boolean.parseBoolean(musicobject.getString("selected")));
                            if(Boolean.parseBoolean(musicobject.getString("selected")))
                            {
                                count++;
                            }
                            music1=musicobject.getString("enabled");


                            studyobject=leisure.getJSONObject(2);
                            study.setChecked(Boolean.parseBoolean(studyobject.getString("selected")));
                            if(Boolean.parseBoolean(studyobject.getString("selected")))
                            {
                                count++;
                            }
                            study1=studyobject.getString("enabled");

                            fasionobject=leisure.getJSONObject(3);
                            fashion.setChecked(Boolean.parseBoolean(fasionobject.getString("selected")));
                            if(Boolean.parseBoolean(fasionobject.getString("selected")))
                            {
                                count++;
                            }
                            fashion1=fasionobject.getString("enabled");

                            teleisionobject=leisure.getJSONObject(4);
                            television.setChecked(Boolean.parseBoolean(teleisionobject.getString("selected")));
                            if(Boolean.parseBoolean(teleisionobject.getString("selected")))
                            {
                                count++;
                            }
                            television1=teleisionobject.getString("enabled");

                            sportsobject=leisure.getJSONObject(5);
                            sports.setChecked(Boolean.parseBoolean(sportsobject.getString("selected")));
                            if(Boolean.parseBoolean(sportsobject.getString("selected")))
                            {
                                count++;
                            }
                            sports1=sportsobject.getString("enabled");

                            outdoorobject=leisure.getJSONObject(6);
                            outdoor.setChecked(Boolean.parseBoolean(outdoorobject.getString("selected")));
                            if(Boolean.parseBoolean(outdoorobject.getString("selected")))
                            {
                                count++;
                            }
                            outdoor1=outdoorobject.getString("enabled");

                            volunteerobject=leisure.getJSONObject(7);
                            volunteer.setChecked(Boolean.parseBoolean(volunteerobject.getString("selected")));
                            if(Boolean.parseBoolean(volunteerobject.getString("selected")))
                            {
                                count++;
                            }
                            volunteer1=volunteerobject.getString("enabled");

                            religiousobject=leisure.getJSONObject(8);
                            religious.setChecked(Boolean.parseBoolean(religiousobject.getString("selected")));
                            if(Boolean.parseBoolean(religiousobject.getString("selected")))
                            {
                                count++;
                            }
                            religious1=religiousobject.getString("enabled");

                            socialobject=leisure.getJSONObject(9);
                            social.setChecked(Boolean.parseBoolean(socialobject.getString("selected")));
                            if(Boolean.parseBoolean(socialobject.getString("selected")))
                            {
                                count++;
                            }
                            social1=socialobject.getString("enabled");

                            enduranceobject=leisure.getJSONObject(10);
                            endurance.setChecked(Boolean.parseBoolean(enduranceobject.getString("selected")));
                            if(Boolean.parseBoolean(enduranceobject.getString("selected")))
                            {
                                count++;
                            }
                            endurance1=enduranceobject.getString("enabled");

                            playobject=leisure.getJSONObject(11);
                            play.setChecked(Boolean.parseBoolean(playobject.getString("selected")));
                            if(Boolean.parseBoolean(playobject.getString("selected")))
                            {
                                count++;
                            }
                            play1=playobject.getString("enabled");






                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        if(arts1.equals("true")){
                            arts.setEnabled(true);
                        }
                        else
                        {
                            arts.setEnabled(false);
                        }
                        if(music1.equals("true")){
                            music.setEnabled(true);
                        }
                        else
                        {
                            music.setEnabled(false);
                        }
                        if(study1.equals("true")){
                            study.setEnabled(true);
                        }
                        else
                        {
                            study.setEnabled(false);
                        }
                        if(fashion1.equals("true")){
                            fashion.setEnabled(true);
                        }
                        else
                        {
                            fashion.setEnabled(false);
                        }
                        if(television1.equals("true")){
                            television.setEnabled(true);
                        }
                        else
                        {
                            television.setEnabled(false);
                        }
                        if(outdoor1.equals("true")){
                            outdoor.setEnabled(true);
                        }
                        else
                        {
                            outdoor.setEnabled(false);
                        }
                        if(sports1.equals("true")){
                            sports.setEnabled(true);
                        }
                        else
                        {
                            sports.setEnabled(false);
                        }
                        if(volunteer1.equals("true")){
                            volunteer.setEnabled(true);
                        }
                        else
                        {
                            volunteer.setEnabled(false);
                        }
                        if(religious1.equals("true")){
                            religious.setEnabled(true);
                        }
                        else
                        {
                            religious.setEnabled(false);
                        }
                        if(social1.equals("true")){
                            social.setEnabled(true);
                        }
                        else
                        {
                            social.setEnabled(false);
                        }
                        if(endurance1.equals("true")){
                            endurance.setEnabled(true);
                        }
                        else
                        {
                            endurance.setEnabled(false);
                        }
                        if(play1.equals("true")){
                            play.setEnabled(true);
                        }
                        else
                        {
                            play.setEnabled(false);
                        }
                    }



                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                pref = getActivity().getSharedPreferences("Options", MODE_PRIVATE);
                String token = pref.getString("token", "");
                Log.e("token", token);
                headers.put("Content-Type", "application/json");
                headers.put("x-auth-token", token);
                return headers;
            }
        };


        requestQueue.add(request);






    }
    public static void myClickMethod(View v){

        boolean checked = ((CheckBox) v).isChecked();

        Log.e("id", String.valueOf(id));
        if(checked){
           count++;
           Log.e("count",String.valueOf(count));
       }
       if(!checked){
           count--;
           Log.e("count",String.valueOf(count));
       }

       if(age.equals("0"))
       {
           if(count<4)
           {

                statusen();
           }
           else
           {



                //\
             //  ActionActivity.showToast(,"hi");


              statusdis();
           }

       }


    }




    }











