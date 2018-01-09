package com.example.anuja.reall;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

/**
 * Created by ANUJA on 09/Jun/2017.
 */

public class ActionLeisureFragment extends Fragment {
    CheckBox arts, social, religious, volunteer, outdoor, television, fashion, play, study, endurance, sports, music;
    SharedPreferences pref;
    String arts1, social1, religious1, volunteer1, outdoor1, television1, fashion1, play1, study1, endurance1, sports1, music1;
    static JSONObject whole_object,artobject,socialobject,religiousobject,volunteerobject,outdoorobject,teleisionobject,fasionobject,playobject,studyobject,enduranceobject,sportsobject,musicobject;
    static JSONArray leisure;
    static JSONObject self;
    private ViewPager viewPager;
    String url=Constant.GAMEURL+"actionbar/leisure/";
RequestQueue requestQueue;

    public ActionLeisureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.actionfragment_leisure, container, false);
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
        pref = getActivity().getSharedPreferences("Options", MODE_PRIVATE);
        String object = pref.getString("whole_object", "");

        try {
            whole_object = new JSONObject(object);
            Log.e("whole",String.valueOf(whole_object));
            self=whole_object.getJSONObject("SELF");
            String time=self.getString("leisureTimeAvailable");
            String age=self.getString("age");
            Log.e("age",age);
            Log.e("time",time);
        } catch (JSONException e) {
            e.printStackTrace();
        }


       leisure();






        return v;




    }

    public void leisure(){
        requestQueue=Volley.newRequestQueue(getActivity());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,"http://192.168.1.124:9090/rlg/game/actionbar/leisure/102",null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.e("response",String.valueOf(response));
                        try {
                            leisure=response.getJSONArray("leisure");

                            artobject=leisure.getJSONObject(0);
                            arts.setChecked(Boolean.parseBoolean(artobject.getString("selected")));

                            musicobject=leisure.getJSONObject(1);
                            music.setChecked(Boolean.parseBoolean(musicobject.getString("selected")));

                            studyobject=leisure.getJSONObject(2);
                            study.setChecked(Boolean.parseBoolean(studyobject.getString("selected")));

                            fasionobject=leisure.getJSONObject(3);
                            fashion.setChecked(Boolean.parseBoolean(fasionobject.getString("selected")));

                            teleisionobject=leisure.getJSONObject(4);
                            television.setChecked(Boolean.parseBoolean(teleisionobject.getString("selected")));

                            sportsobject=leisure.getJSONObject(5);
                            sports.setChecked(Boolean.parseBoolean(sportsobject.getString("selected")));

                            outdoorobject=leisure.getJSONObject(6);
                            outdoor.setChecked(Boolean.parseBoolean(outdoorobject.getString("selected")));

                            volunteerobject=leisure.getJSONObject(7);
                            volunteer.setChecked(Boolean.parseBoolean(volunteerobject.getString("selected")));

                            religiousobject=leisure.getJSONObject(8);
                            religious.setChecked(Boolean.parseBoolean(religiousobject.getString("selected")));

                            socialobject=leisure.getJSONObject(9);
                            social.setChecked(Boolean.parseBoolean(socialobject.getString("selected")));

                            enduranceobject=leisure.getJSONObject(10);
                            endurance.setChecked(Boolean.parseBoolean(enduranceobject.getString("selected")));

                            playobject=leisure.getJSONObject(11);
                            play.setChecked(Boolean.parseBoolean(playobject.getString("selected")));






                        } catch (JSONException e) {
                            e.printStackTrace();
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
}
