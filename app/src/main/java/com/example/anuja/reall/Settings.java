package com.example.anuja.reall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
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

public class Settings extends AppCompatActivity {
    String humanrightabuses,truthfullness,crime,customs,volunteering,naturaldisaster,corruption,culturaldiscrimination,
    accidentsandtrauma,romanticrealtionship,climate,charity,robbery,homosexuality,cardiovasculardiseases,
    druguse,physicalabuse,parasiticdisease,birthdefects,pregnencychildren,substanceaduse,sexualdiscrimination,consciense,
    religion,sexualabuse,burglary,sexuallytransmitteddisease,murder,assult,selfsacrifise,rape,cancers,agediscrimination,
    war,smoking,otherconditions,emotionalabuse,malnutrition,sports,love,greed,infertility,housing,traditions,cuisine,motorvehicletheft,
    workplacecorruption,takingastand,governmentcorruption,infectiousdisease,conscription,arts,nature,welfaregovernmentassistance,
    alcoholuse,psycologicaldisorders,degenerativecondition,outofwedlockchildren,history;

    SharedPreferences pref;
    String demo,token;
    CheckBox conscience_main,family_main,government_main,disaster_main,vice_main,country_main,crime_main,health_main,checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,
            checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,checkBox17,checkBox18,
            checkBox19,checkBox20,checkBox21,checkBox22,checkBox23,checkBox24,checkBox25,checkBox26,checkBox27,
            checkBox28,checkBox29,checkBox30,checkBox31,checkBox32,checkBox33,checkBox34,checkBox35,checkBox36,checkBox37,
            checkBox38,checkBox39,checkBox40,checkBox41,checkBox42,checkBox43,checkBox44,checkBox45,checkBox46,checkBox47,
            checkBox48,checkBox49,checkBox50,checkBox51,checkBox52,checkBox53,checkBox54,checkBox55,checkBox56,checkBox57;
    Button save;

    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        save=(Button)findViewById(R.id.save_button);

        conscience_main=(CheckBox)findViewById(R.id.conscience_Box) ;
        family_main=(CheckBox)findViewById(R.id.famAndSexuality_Box) ;
        government_main=(CheckBox)findViewById(R.id.governmentHumanRights_Box) ;
        disaster_main=(CheckBox)findViewById(R.id.naturalDisasters_Box) ;
        vice_main=(CheckBox)findViewById(R.id.vices_Box) ;
        country_main=(CheckBox)findViewById(R.id.countryAndCulture_Box) ;
        crime_main=(CheckBox)findViewById(R.id.crimeAndAbuse_Box) ;
        health_main=(CheckBox)findViewById(R.id.health_Box) ;



       checkBox1 = (CheckBox) findViewById(R.id.conscience_sub_Box);
       checkBox2 = (CheckBox) findViewById(R.id.charity_Box);
       checkBox3 = (CheckBox) findViewById(R.id.crime_Box);
        checkBox4 = (CheckBox) findViewById(R.id.volunteer_Box);
        checkBox5 = (CheckBox) findViewById(R.id.greed_Box);
        checkBox6 = (CheckBox) findViewById(R.id.selfSacrifice_Box);
        checkBox7 = (CheckBox) findViewById(R.id.truthfulness_Box);
        checkBox8 = (CheckBox) findViewById(R.id.takingAStand_Box);


        checkBox9 = (CheckBox) findViewById(R.id.homosexuality_Box);
        checkBox10 = (CheckBox) findViewById(R.id.infertility_Box);
        checkBox11 = (CheckBox) findViewById(R.id.outOfWedlock_Box);
        checkBox12 = (CheckBox) findViewById(R.id.pregnancy_Box);
        checkBox13 = (CheckBox) findViewById(R.id.romanticRelationship_Box);
        checkBox14 = (CheckBox) findViewById(R.id.sexuallyTransmittedDisease_Box);
        checkBox15 = (CheckBox) findViewById(R.id.love_Box);


        checkBox16 = (CheckBox) findViewById(R.id.consription_Box);
        checkBox17 = (CheckBox) findViewById(R.id.governmentCorruption_Box);
        checkBox18 = (CheckBox) findViewById(R.id.humanRightsAbuses_Box);
        checkBox19 = (CheckBox) findViewById(R.id.war_Box);
        checkBox20 = (CheckBox) findViewById(R.id.welfareGovernmentAssistance_Box);
        checkBox21 = (CheckBox) findViewById(R.id.corruption_Box);


        checkBox22 = (CheckBox) findViewById(R.id.allDisasters_Box);


        checkBox23 = (CheckBox) findViewById(R.id.alcoholUse_Box);
        checkBox24 = (CheckBox) findViewById(R.id.drugUse_Box);
        checkBox25 = (CheckBox) findViewById(R.id.smoking_Box);


        checkBox26 = (CheckBox) findViewById(R.id.customs_Box);
        checkBox27 = (CheckBox) findViewById(R.id.climate_Box);
        checkBox28 = (CheckBox) findViewById(R.id.arts_Box);
        checkBox29 = (CheckBox) findViewById(R.id.housing_Box);
        checkBox30 = (CheckBox) findViewById(R.id.cuisine_Box);
        checkBox31 = (CheckBox) findViewById(R.id.sports_Box);
        checkBox32 = (CheckBox) findViewById(R.id.history_Box);
        checkBox33 = (CheckBox) findViewById(R.id.nature_Box);
        checkBox34 = (CheckBox) findViewById(R.id.traditions_Box);
        checkBox35 = (CheckBox) findViewById(R.id.religion_Box);


        checkBox37 = (CheckBox) findViewById(R.id.assault_Box);
        checkBox38 = (CheckBox) findViewById(R.id.burglary_Box);
        checkBox39 = (CheckBox) findViewById(R.id.emotionalAbuse_Box);
        checkBox40 = (CheckBox) findViewById(R.id.motorVehicleTheft_Box);
        checkBox41 = (CheckBox) findViewById(R.id.murder_Box);
        checkBox42 = (CheckBox) findViewById(R.id.physicalAbuse_Box);
        checkBox43 = (CheckBox) findViewById(R.id.rape_Box);
        checkBox44 = (CheckBox) findViewById(R.id.robbery_Box);
        checkBox45 = (CheckBox) findViewById(R.id.sexualAbuse_Box);
        checkBox46 = (CheckBox) findViewById(R.id.workPlaceCorruption_Box);


        checkBox47 = (CheckBox) findViewById(R.id.accidentsAndTrauma_Box);
        checkBox48 = (CheckBox) findViewById(R.id.birthDefects_Box);
        checkBox49 = (CheckBox) findViewById(R.id.cancers_Box);
        checkBox50 = (CheckBox) findViewById(R.id.cardiovascular_Box);
        checkBox51 = (CheckBox) findViewById(R.id.degenerative_Box);
        checkBox52 = (CheckBox) findViewById(R.id.infectious_Box);
        checkBox53 = (CheckBox) findViewById(R.id.malnutrition_Box);
        checkBox54 = (CheckBox) findViewById(R.id.parasitic_Box);
        checkBox55 = (CheckBox) findViewById(R.id.psychologicalDisease_Box);
        checkBox56 = (CheckBox) findViewById(R.id.substanceAbuse_Box);

        checkBox57 = (CheckBox) findViewById(R.id.otherConditions_Box);



        humanrightabuses=truthfullness=crime=customs=volunteering=naturaldisaster=corruption=culturaldiscrimination=
                accidentsandtrauma=romanticrealtionship=climate=charity=robbery=homosexuality=cardiovasculardiseases=
                        druguse=physicalabuse=parasiticdisease=birthdefects=pregnencychildren=substanceaduse=sexualdiscrimination=consciense=
                                religion=sexualabuse=burglary=sexuallytransmitteddisease=murder=assult=selfsacrifise=rape=cancers=agediscrimination=
                                        war=smoking=otherconditions=emotionalabuse=malnutrition=sports=love=greed=infertility=housing=traditions=cuisine=motorvehicletheft=
                                                workplacecorruption=takingastand=governmentcorruption=infectiousdisease=conscription=arts=nature=welfaregovernmentassistance=
                                                        alcoholuse=psycologicaldisorders=degenerativecondition=outofwedlockchildren=history="false";




        send();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });



    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.conscience_Box:

                if (checked) {
                    checkBox1.setChecked(true);
                    checkBox2.setChecked(true);
                    checkBox3.setChecked(true);
                    checkBox4.setChecked(true);
                    checkBox5.setChecked(true);
                    checkBox6.setChecked(true);
                    checkBox7.setChecked(true);
                    checkBox8.setChecked(true);
                }
                // Put some meat on the sandwich
                else{
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);
                    checkBox6.setChecked(false);
                    checkBox7.setChecked(false);
                    checkBox8.setChecked(false);
                }

                break;
            case R.id.famAndSexuality_Box:
                if (checked) {
                    checkBox9.setChecked(true);
                    checkBox10.setChecked(true);
                    checkBox11.setChecked(true);
                    checkBox12.setChecked(true);
                    checkBox13.setChecked(true);
                    checkBox14.setChecked(true);
                    checkBox15.setChecked(true);

                }
                // Put some meat on the sandwich
                else{
                    checkBox9.setChecked(false);
                    checkBox10.setChecked(false);
                    checkBox11.setChecked(false);
                    checkBox12.setChecked(false);
                    checkBox13.setChecked(false);
                    checkBox14.setChecked(false);
                    checkBox15.setChecked(false);

                }

                    break;

            case R.id.governmentHumanRights_Box:
                if (checked) {
                    checkBox16.setChecked(true);
                    checkBox17.setChecked(true);
                    checkBox18.setChecked(true);
                    checkBox19.setChecked(true);
                    checkBox20.setChecked(true);
                    checkBox21.setChecked(true);

                }
                // Put some meat on the sandwich
                else{
                    checkBox16.setChecked(false);
                    checkBox17.setChecked(false);
                    checkBox18.setChecked(false);
                    checkBox19.setChecked(false);
                    checkBox20.setChecked(false);
                    checkBox21.setChecked(false);

                }

                break;

            case R.id.naturalDisasters_Box:
                if (checked) {
                    checkBox22.setChecked(true);

                }
                // Put some meat on the sandwich
                else{
                    checkBox22.setChecked(false);

                }

                break;
            case R.id.vices_Box:
                if (checked) {
                    checkBox23.setChecked(true);
                    checkBox24.setChecked(true);
                    checkBox25.setChecked(true);

                }
                // Put some meat on the sandwich
                else{
                    checkBox23.setChecked(false);
                    checkBox24.setChecked(false);
                    checkBox25.setChecked(false);


                }

                break;

            case R.id.countryAndCulture_Box:
                if (checked) {
                    checkBox26.setChecked(true);
                    checkBox27.setChecked(true);
                    checkBox28.setChecked(true);
                    checkBox29.setChecked(true);
                    checkBox30.setChecked(true);
                    checkBox31.setChecked(true);
                    checkBox32.setChecked(true);
                    checkBox33.setChecked(true);
                    checkBox34.setChecked(true);
                    checkBox35.setChecked(true);


                }
                // Put some meat on the sandwich
                else{
                    checkBox26.setChecked(false);
                    checkBox27.setChecked(false);
                    checkBox28.setChecked(false);
                    checkBox29.setChecked(false);
                    checkBox30.setChecked(false);
                    checkBox31.setChecked(false);
                    checkBox32.setChecked(false);
                    checkBox33.setChecked(false);
                    checkBox34.setChecked(false);
                    checkBox35.setChecked(false);

                }

                break;


            case R.id.crimeAndAbuse_Box:
                if (checked) {
                    checkBox37.setChecked(true);
                    checkBox38.setChecked(true);
                    checkBox39.setChecked(true);
                    checkBox40.setChecked(true);
                    checkBox41.setChecked(true);
                    checkBox42.setChecked(true);
                    checkBox43.setChecked(true);
                    checkBox44.setChecked(true);
                    checkBox45.setChecked(true);
                    checkBox46.setChecked(true);


                }
                // Put some meat on the sandwich
                else{

                    checkBox37.setChecked(false);
                    checkBox38.setChecked(false);
                    checkBox39.setChecked(false);
                    checkBox40.setChecked(false);
                    checkBox41.setChecked(false);
                    checkBox42.setChecked(false);
                    checkBox43.setChecked(false);
                    checkBox44.setChecked(false);
                    checkBox45.setChecked(false);
                    checkBox46.setChecked(false);
                }

                break;


            case R.id.health_Box:
                if (checked) {
                    checkBox47.setChecked(true);
                    checkBox48.setChecked(true);
                    checkBox49.setChecked(true);
                    checkBox50.setChecked(true);
                    checkBox51.setChecked(true);
                    checkBox52.setChecked(true);
                    checkBox53.setChecked(true);
                    checkBox54.setChecked(true);
                    checkBox55.setChecked(true);
                    checkBox56.setChecked(true);
                    checkBox57.setChecked(true);


                }
                // Put some meat on the sandwich
                else{


                    checkBox47.setChecked(false);
                    checkBox48.setChecked(false);
                    checkBox49.setChecked(false);
                    checkBox50.setChecked(false);
                    checkBox51.setChecked(false);
                    checkBox52.setChecked(false);
                    checkBox53.setChecked(false);
                    checkBox54.setChecked(false);
                    checkBox55.setChecked(false);
                    checkBox56.setChecked(false);
                    checkBox57.setChecked(false);

                }

                break;

        }
        if(checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() &&
                checkBox5.isChecked() && checkBox6.isChecked() && checkBox7.isChecked() && checkBox8.isChecked()){
            conscience_main.setChecked(true);


        }
        else
        {
            conscience_main.setChecked(false);
        }

        if(checkBox9.isChecked() && checkBox10.isChecked() && checkBox11.isChecked() && checkBox12.isChecked() &&
                checkBox13.isChecked() && checkBox14.isChecked() && checkBox15.isChecked()){
            family_main.setChecked(true);

        }
        else
        {
            family_main.setChecked(false);
        }

        if(checkBox16.isChecked() && checkBox17.isChecked() && checkBox18.isChecked() && checkBox19.isChecked() &&
                checkBox20.isChecked() && checkBox21.isChecked()){
            government_main.setChecked(true);

        }
        else
        {
            government_main.setChecked(false);
        }


        if(checkBox22.isChecked()){
            disaster_main.setChecked(true);

        }
        else
        {
            disaster_main.setChecked(false);
        }

        if(checkBox23.isChecked() && checkBox24.isChecked() && checkBox25.isChecked()){
            vice_main.setChecked(true);


        }
        else
        {
            vice_main.setChecked(false);
        }

        if(checkBox26.isChecked() && checkBox27.isChecked() && checkBox28.isChecked() && checkBox29.isChecked() &&
                checkBox30.isChecked() && checkBox31.isChecked() && checkBox32.isChecked() && checkBox33.isChecked() && checkBox34.isChecked() && checkBox35.isChecked()){
            country_main.setChecked(true);

        }
        else
        {
            country_main.setChecked(false);
        }

        if(checkBox37.isChecked() && checkBox38.isChecked() && checkBox39.isChecked() && checkBox40.isChecked() &&
                checkBox41.isChecked() && checkBox42.isChecked() && checkBox43.isChecked() && checkBox44.isChecked()&& checkBox45.isChecked() && checkBox46.isChecked()){
            crime_main.setChecked(true);

        }
        else
        {
            crime_main.setChecked(false);
        }



        if(checkBox47.isChecked() && checkBox48.isChecked() && checkBox49.isChecked() && checkBox50.isChecked() &&
                checkBox51.isChecked() && checkBox52.isChecked() && checkBox53.isChecked() && checkBox54.isChecked()&& checkBox55.isChecked() && checkBox56.isChecked() && checkBox57.isChecked()){
            health_main.setChecked(true);

        }
        else
        {
            health_main.setChecked(false);
        }

    }
    public void send()
    {
        String username;
        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        username=pref.getString("username","");
        Log.e("username",username);

        String url="http://192.168.1.124:9090/rlg/game/gamesettings/"+username+"?";
        Log.e("url",url);
        RequestQueue requestQueue= Volley.newRequestQueue(Settings.this);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            humanrightabuses = response.getString("HUMANRIGHTABUSES");
                            truthfullness = response.getString("TRUTHFULNESS");
                            crime = response.getString("CRIME");
                            customs = response.getString("CUSTOMS");
                            volunteering = response.getString("VOLUNTEERING");
                            naturaldisaster=response.getString("NATUREALDIASTER");
                            corruption = response.getString("CORRUPTION");
                            culturaldiscrimination = response.getString("CULTURALRACIALDISCRIMINATION");
                            accidentsandtrauma = response.getString("ACCIDENTSANDTRAUMA");
                            romanticrealtionship = response.getString("ROMANTICRELATIONSHIPS");
                            climate = response.getString("CLIMATE");
                            charity = response.getString("CHARITY");
                            robbery = response.getString("ROBBERY");
                            homosexuality = response.getString("HOMOSEXUALITY");
                            cardiovasculardiseases = response.getString("CARDIOVASCULARDISEASES");
                            druguse = response.getString("DRUGUSE");
                            physicalabuse = response.getString("PHYSICALABUSE");
                            parasiticdisease = response.getString("PARASITICDISEASES");
                            birthdefects = response.getString("BIRTHDEFECTS");
                            pregnencychildren = response.getString("PREGNANCYCHILDREN");
                            substanceaduse = response.getString("SUBSTANCEADUSE");
                            sexualdiscrimination = response.getString("SEXUALDISCRIMINATIONS");
                            consciense = response.getString("CONSCIENCE");
                            religion = response.getString("RELIGION");
                            sexualabuse = response.getString("SEXUALABUSE");
                            burglary = response.getString("BURGLARY");
                            sexuallytransmitteddisease = response.getString("SEXUALLYTRANSMITTEDDISEASES");
                            murder = response.getString("MURDER");
                            selfsacrifise=response.getString("SELFSACRIFICE");
                            assult = response.getString("ASSULT");
                            rape = response.getString("RAPE");
                            cancers = response.getString("CANCERS");
                            agediscrimination = response.getString("AGEDICRIMINATION");
                            war= response.getString("WAR");
                            smoking = response.getString("SMOKING");
                            otherconditions = response.getString("OTHERCONDITIONS");
                            emotionalabuse = response.getString("EMOTIONALABUSE");
                            malnutrition = response.getString("MALNUTRITION");
                            sports = response.getString("SPORTS");
                            love = response.getString("LOVE");
                            greed = response.getString("GREED");
                            infertility = response.getString("INFERTILITY");
                            housing = response.getString("HOUSING");
                            traditions = response.getString("TRADITIONS");
                            cuisine = response.getString("CUISINE");
                            motorvehicletheft = response.getString("MOTORVEHICLETHEFT");
                            workplacecorruption = response.getString("WORKPLACECORRUPTION");
                            takingastand = response.getString("TAKINGASTAND");
                            governmentcorruption = response.getString("GOVERMENTCORRUPTION");
                            infectiousdisease = response.getString("INFECTIOUSDISSEASE");
                            conscription = response.getString("CONSCRIPTION");
                            arts = response.getString("ARTS");
                            nature = response.getString("NATURE");
                            welfaregovernmentassistance = response.getString("WELFAREGOVERMENTASSISTANCE");
                            alcoholuse = response.getString("ALCOHOLUSE");
                            psycologicaldisorders = response.getString("PSYCHOLOGICALDISORDERS");
                            degenerativecondition = response.getString("DEGENERATIVECONDITION");
                            outofwedlockchildren = response.getString("OUTOFWEDLOCKCHILDERN");
                            history = response.getString("HISTORY");


                            set();








                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }) {


            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
                String token=pref.getString("token","");
                Log.e("token",token);
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("x-auth-token",token);
                return headers;
            }



        };
        requestQueue.add(jsonObjReq);


    }

    public void set() {
        if (consciense.equals("true")) {
            checkBox1.setChecked(true);
        } else {
            checkBox1.setChecked(false);
        }
        if (charity.equals("true")) {
            checkBox2.setChecked(true);
        } else {
            checkBox2.setChecked(false);
        }

        if (crime.equals("true")) {
            checkBox3.setChecked(true);
        } else {
            checkBox3.setChecked(false);
        }
        if (volunteering.equals("true")) {
            checkBox4.setChecked(true);
        } else {
            checkBox4.setChecked(false);
        }
        if (greed.equals("true")) {
            checkBox5.setChecked(true);
        } else {
            checkBox5.setChecked(false);
        }
        if (selfsacrifise.equals("true")) {
            checkBox6.setChecked(true);
        } else {
            checkBox6.setChecked(false);
        }
        if (truthfullness.equals("true")) {
            checkBox7.setChecked(true);
        } else {
            checkBox7.setChecked(false);
        }
        if (takingastand.equals("true")) {
            checkBox8.setChecked(true);
        } else {
            checkBox8.setChecked(false);
        }
        if (homosexuality.equals("true")) {
            checkBox9.setChecked(true);
        } else {
            checkBox9.setChecked(false);
        }
        if (infertility.equals("true")) {
            checkBox10.setChecked(true);
        } else {
            checkBox10.setChecked(false);
        }
        if (outofwedlockchildren.equals("true")) {
            checkBox11.setChecked(true);
        } else {
            checkBox11.setChecked(false);
        }
        if (pregnencychildren.equals("true")) {
            checkBox12.setChecked(true);
        } else {
            checkBox12.setChecked(false);
        }
        if (romanticrealtionship.equals("true")) {
            checkBox13.setChecked(true);
        } else {
            checkBox13.setChecked(false);
        }
        if (sexuallytransmitteddisease.equals("true")) {
            checkBox14.setChecked(true);
        } else {
            checkBox14.setChecked(false);
        }
        if (love.equals("true")) {
            checkBox15.setChecked(true);
        } else {
            checkBox15.setChecked(false);
        }
        if (conscription.equals("true")) {
            checkBox16.setChecked(true);
        } else {
            checkBox16.setChecked(false);
        }
        if (governmentcorruption.equals("true")) {
            checkBox17.setChecked(true);
        } else {
            checkBox17.setChecked(false);
        }
        if (humanrightabuses.equals("true")) {
            checkBox18.setChecked(true);
        } else {
            checkBox18.setChecked(false);
        }
        if (war.equals("true")) {
            checkBox19.setChecked(true);
        } else {
            checkBox19.setChecked(false);
        }
        if (welfaregovernmentassistance.equals("true")) {
            checkBox20.setChecked(true);
        } else {
            checkBox20.setChecked(false);
        }
        if (corruption.equals("true")) {
            checkBox21.setChecked(true);
        } else {
            checkBox21.setChecked(false);
        }
        if (naturaldisaster.equals("true")) {
            checkBox22.setChecked(true);
        } else {
            checkBox22.setChecked(false);
        }
        if (alcoholuse.equals("true")) {
            checkBox23.setChecked(true);
        } else {
            checkBox23.setChecked(false);
        }
        if (druguse.equals("true")) {
            checkBox24.setChecked(true);
        } else {
            checkBox24.setChecked(false);
        }
        if (smoking.equals("true")) {
            checkBox25.setChecked(true);
        } else {
            checkBox25.setChecked(false);
        }
        if (customs.equals("true")) {
            checkBox26.setChecked(true);
        } else {
            checkBox26.setChecked(false);
        }
        if (climate.equals("true")) {
            checkBox27.setChecked(true);
        } else {
            checkBox27.setChecked(false);
        }
        if (arts.equals("true")) {
            checkBox28.setChecked(true);
        } else {
            checkBox28.setChecked(false);
        }
        if (housing.equals("true")) {
            checkBox29.setChecked(true);
        } else {
            checkBox29.setChecked(false);
        }
        if (cuisine.equals("true")) {
            checkBox30.setChecked(true);
        } else {
            checkBox30.setChecked(false);
        }
        if (sports.equals("true")) {
            checkBox31.setChecked(true);
        } else {
            checkBox31.setChecked(false);
        }
        if (history.equals("true")) {
            checkBox32.setChecked(true);
        } else {
            checkBox32.setChecked(false);
        }
        if (nature.equals("true")) {
            checkBox33.setChecked(true);
        } else {
            checkBox33.setChecked(false);
        }
        if (traditions.equals("true")) {
            checkBox34.setChecked(true);
        } else {
            checkBox34.setChecked(false);
        }
        if (religion.equals("true")) {
            checkBox35.setChecked(true);
        } else {
            checkBox35.setChecked(false);
        }
        if (assult.equals("true")) {
            checkBox37.setChecked(true);
        } else {
            checkBox37.setChecked(false);
        }
        if (burglary.equals("true")) {
            checkBox38.setChecked(true);
        } else {
            checkBox38.setChecked(false);
        }
        if (emotionalabuse.equals("true")) {
            checkBox39.setChecked(true);
        } else {
            checkBox39.setChecked(false);
        }
        if (motorvehicletheft.equals("true")) {
            checkBox40.setChecked(true);
        } else {
            checkBox40.setChecked(false);
        }
        if (murder.equals("true")) {
            checkBox41.setChecked(true);
        } else {
            checkBox41.setChecked(false);
        }
        if (physicalabuse.equals("true")) {
            checkBox42.setChecked(true);
        } else {
            checkBox42.setChecked(false);
        }
        if (rape.equals("true")) {
            checkBox43.setChecked(true);
        } else {
            checkBox43.setChecked(false);
        }
        if (robbery.equals("true")) {
            checkBox44.setChecked(true);
        } else {
            checkBox44.setChecked(false);
        }
        if (sexualabuse.equals("true")) {
            checkBox45.setChecked(true);
        } else {
            checkBox45.setChecked(false);
        }
        if (workplacecorruption.equals("true")) {
            checkBox46.setChecked(true);
        } else {
            checkBox46.setChecked(false);
        }
        if (accidentsandtrauma.equals("true")) {
            checkBox47.setChecked(true);
        } else {
            checkBox47.setChecked(false);
        }
        if (birthdefects.equals("true")) {
            checkBox48.setChecked(true);
        } else {
            checkBox48.setChecked(false);
        }
        if (cancers.equals("true")) {
            checkBox49.setChecked(true);
        } else {
            checkBox49.setChecked(false);
        }
        if (cardiovasculardiseases.equals("true")) {
            checkBox50.setChecked(true);
        } else {
            checkBox50.setChecked(false);
        }
        if (degenerativecondition.equals("true")) {
            checkBox51.setChecked(true);
        } else {
            checkBox51.setChecked(false);
        }
        if (infectiousdisease.equals("true")) {
            checkBox52.setChecked(true);
        } else {
            checkBox52.setChecked(false);
        }
        if (malnutrition.equals("true")) {
            checkBox53.setChecked(true);
        } else {
            checkBox53.setChecked(false);
        }
        if (parasiticdisease.equals("true")) {
            checkBox54.setChecked(true);
        } else {
            checkBox54.setChecked(false);
        }
        if (psycologicaldisorders.equals("true")) {
            checkBox55.setChecked(true);
        } else {
            checkBox55.setChecked(false);
        }
        if (substanceaduse.equals("true")) {
            checkBox56.setChecked(true);
        } else {
            checkBox56.setChecked(false);
        }
        if (otherconditions.equals("true")) {
            checkBox57.setChecked(true);
        } else {
            checkBox57.setChecked(false);
        }


        if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() &&
                checkBox5.isChecked() && checkBox6.isChecked() && checkBox7.isChecked() && checkBox8.isChecked()) {
            conscience_main.setChecked(true);

        }

        if (checkBox9.isChecked() && checkBox10.isChecked() && checkBox11.isChecked() && checkBox12.isChecked() &&
                checkBox13.isChecked() && checkBox14.isChecked() && checkBox15.isChecked()) {
            family_main.setChecked(true);

        }

        if (checkBox16.isChecked() && checkBox17.isChecked() && checkBox18.isChecked() && checkBox19.isChecked() &&
                checkBox20.isChecked() && checkBox21.isChecked()) {
            government_main.setChecked(true);

        }

        if (checkBox22.isChecked()) {
            disaster_main.setChecked(true);

        }

        if (checkBox23.isChecked() && checkBox24.isChecked() && checkBox25.isChecked()) {
            vice_main.setChecked(true);

        }

        if (checkBox26.isChecked() && checkBox27.isChecked() && checkBox28.isChecked() && checkBox29.isChecked() &&
                checkBox30.isChecked() && checkBox31.isChecked() && checkBox32.isChecked() && checkBox33.isChecked() && checkBox34.isChecked() && checkBox35.isChecked()) {
            country_main.setChecked(true);

        }

        if (checkBox37.isChecked() && checkBox38.isChecked() && checkBox39.isChecked() && checkBox40.isChecked() &&
                checkBox41.isChecked() && checkBox42.isChecked() && checkBox43.isChecked() && checkBox44.isChecked() && checkBox45.isChecked() && checkBox46.isChecked()) {
            crime_main.setChecked(true);

        }


        if (checkBox47.isChecked() && checkBox48.isChecked() && checkBox49.isChecked() && checkBox50.isChecked() &&
                checkBox51.isChecked() && checkBox52.isChecked() && checkBox53.isChecked() && checkBox54.isChecked() && checkBox55.isChecked() && checkBox56.isChecked() && checkBox57.isChecked()) {
            health_main.setChecked(true);

        }
    }


public String data(boolean flag)
{
        String data;
        if(flag==true)
        {
                data="true";
            return data;
        }
        else
        {
            data="false";
            return data;
        }

}
    public void save(){
        String username;
        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        username=pref.getString("username","");
        Log.e("username",username);
        String url1="http://192.168.1.124:9090/rlg/game/gamesettings/"+username;
        final JSONObject jsonobject_one = new JSONObject();

        try {

            jsonobject_one.put("ACCIDENTSANDTRAUMA",data(checkBox47.isChecked()));
            jsonobject_one.put("ALCOHOLUSE",data(checkBox23.isChecked()));
            jsonobject_one.put("ARTS",data(checkBox28.isChecked()));
            jsonobject_one.put("ASSULT",data(checkBox37.isChecked()));
            jsonobject_one.put("BIRTHDEFECTS",data(checkBox48.isChecked()));
            jsonobject_one.put("BURGLARY",data(checkBox38.isChecked()));
            jsonobject_one.put("CANCERS",data(checkBox49.isChecked()));
            jsonobject_one.put("CARDIOVASCULARDISEASES",data(checkBox50.isChecked()));
            jsonobject_one.put("CHARITY",data(checkBox2.isChecked()));
            jsonobject_one.put("CLIMATE",data(checkBox27.isChecked()));
            jsonobject_one.put("CONSCIENCE",data(checkBox1.isChecked()));
            jsonobject_one.put("CONSCRIPTION",data(checkBox16.isChecked()));
            jsonobject_one.put("CORRUPTION",data(checkBox21.isChecked()));
            jsonobject_one.put("CRIME",data(checkBox3.isChecked()));
            jsonobject_one.put("CUISINE",data(checkBox30.isChecked()));
            jsonobject_one.put("CUSTOMS",data(checkBox26.isChecked()));
            jsonobject_one.put("DEGENERATIVECONDITION",data(checkBox51.isChecked()));
            jsonobject_one.put("DRUGUSE",data(checkBox24.isChecked()));
            jsonobject_one.put("EMOTIONALABUSE",data(checkBox39.isChecked()));
            jsonobject_one.put("GOVERMENTCORRUPTION",data(checkBox17.isChecked()));
            jsonobject_one.put("GREED",data(checkBox5.isChecked()));
            jsonobject_one.put("HISTORY",data(checkBox32.isChecked()));
            jsonobject_one.put("HOMOSEXUALITY",data(checkBox9.isChecked()));
            jsonobject_one.put("HOUSING",data(checkBox29.isChecked()));
            jsonobject_one.put("HUMANRIGHTABUSES",data(checkBox18.isChecked()));
            jsonobject_one.put("INFECTIOUSDISSEASE",data(checkBox52.isChecked()));
            jsonobject_one.put("INFERTILITY",data(checkBox10.isChecked()));
            jsonobject_one.put("LOVE",data(checkBox15.isChecked()));
            jsonobject_one.put("MALNUTRITION",data(checkBox53.isChecked()));
            jsonobject_one.put("MOTORVEHICLETHEFT",data(checkBox40.isChecked()));
            jsonobject_one.put("MURDER",data(checkBox41.isChecked()));
            jsonobject_one.put("NATURE",data(checkBox33.isChecked()));
            jsonobject_one.put("NATUREALDIASTER",data(checkBox22.isChecked()));
            jsonobject_one.put("OTHERCONDITIONS",data(checkBox57.isChecked()));
            jsonobject_one.put("OUTOFWEDLOCKCHILDERN",data(checkBox11.isChecked()));
            jsonobject_one.put("PARASITICDISEASES",data(checkBox54.isChecked()));
            jsonobject_one.put("PHYSICALABUSE",data(checkBox42.isChecked()));
            jsonobject_one.put("PREGNANCYCHILDREN",data(checkBox12.isChecked()));
            jsonobject_one.put("PSYCHOLOGICALDISORDERS",data(checkBox55.isChecked()));
            jsonobject_one.put("RAPE",data(checkBox43.isChecked()));
            jsonobject_one.put("RELIGION",data(checkBox35.isChecked()));
            jsonobject_one.put("ROBBERY",data(checkBox44.isChecked()));
            jsonobject_one.put("ROMANTICRELATIONSHIPS",data(checkBox13.isChecked()));
            jsonobject_one.put("SELFSACRIFICE",data(checkBox6.isChecked()));
            jsonobject_one.put("SEXUALABUSE",data(checkBox45.isChecked()));
            jsonobject_one.put("SEXUALLYTRANSMITTEDDISEASES",data(checkBox14.isChecked()));
            jsonobject_one.put("SMOKING",data(checkBox25.isChecked()));
            jsonobject_one.put("SPORTS",data(checkBox31.isChecked()));
            jsonobject_one.put("SUBSTANCEADUSE",data(checkBox56.isChecked()));
            jsonobject_one.put("TAKINGASTAND",data(checkBox8.isChecked()));
            jsonobject_one.put("TRADITIONS",data(checkBox34.isChecked()));
            jsonobject_one.put("TRUTHFULNESS",data(checkBox7.isChecked()));
            jsonobject_one.put("VOLUNTEERING",data(checkBox4.isChecked()));
            jsonobject_one.put("WAR",data(checkBox19.isChecked()));
            jsonobject_one.put("WELFAREGOVERMENTASSISTANCE",data(checkBox20.isChecked()));
            jsonobject_one.put("WORKPLACECORRUPTION",data(checkBox46.isChecked()));


        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestQueue requestQueue= Volley.newRequestQueue(Settings.this);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.PUT, url1, jsonobject_one,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            demo = response.getString("status");
                            Log.e("hello",demo);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            error.printStackTrace();


            }
        }) {

            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
                String token=pref.getString("token","");
                Log.e("token",token);
                headers.put("Content-Type", "application/json");
                headers.put("x-auth-token",token);
                return headers;
            }

        };
        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return  5000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 5000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });
        requestQueue.add(jsonObjReq);
        Intent intent=new Intent(Settings.this,MainActivity.class);
        startActivity(intent);


    }




    }











//    public void mainCheckbox(View view)
//    {
//
//    }




