package com.example.anuja.reall;




import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CountryStatisticsFragment extends Fragment {
    static  JSONObject jsonObject=new JSONObject();


    public CountryStatisticsFragment() {
        // Required empty public constructor
    }

    public void setObj(JSONObject obj,CountryWikipediaFragment countryWikipediaFragment,CountryLonelyPlanetFragment countryLonelyPlanetFragment){
        jsonObject=obj;
        JSONObject country= null;
        try {
            JSONObject self = jsonObject.getJSONObject("SELF");
            country =self.getJSONObject("country");
            String country_name=country.getString("countryName");


            countryWikipediaFragment.setCountry(country_name);
            System.out.print("");
            countryLonelyPlanetFragment.setCountry(country_name);
        } catch (JSONException e) {
            e.printStackTrace();
        }







    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.your_country_1_table_tab, container, false);
        TextView registerCountryCapital=(TextView) view.findViewById(R.id.RegisterCountryCapital);
        TextView countryCapital=(TextView) view.findViewById(R.id.CountryCapital);
        TextView countryCurrency=(TextView)view.findViewById(R.id.CountryCurrency);
        TextView registerCountryCurrency=(TextView)view.findViewById(R.id.RegisterCountryCurrency);
        TextView countryPrimarySchool=(TextView)view.findViewById(R.id.CountryPrimarySchool);
        TextView registerCountryPrimarySchool=(TextView)view.findViewById(R.id.RegisterCountryPrimarySchool);
        TextView countryPopulation=(TextView)view.findViewById(R.id.CountryPopulation);
        TextView registerCountryPopulation=(TextView)view.findViewById(R.id.RegisterCountryPopulation);
        TextView countrySexRatio=(TextView)view.findViewById(R.id.CountrySexRatio);
        TextView registerCountrySexRatio=(TextView)view.findViewById(R.id.RegisteredCountrySexRatio);
        TextView countryBirthRate=(TextView)view.findViewById(R.id.CountryBirthRate);
        TextView registerCountryBirthrate=(TextView)view.findViewById(R.id.RegisterCountryBirthRate);
        TextView countryDeathRate=(TextView)view.findViewById(R.id.CountryDeathRate);
        TextView registereCountryDeathRate=(TextView)view.findViewById(R.id.RegisterCountryDeathRate);
        TextView countryInfantMortality=(TextView)view.findViewById(R.id.CountryInfantMortality);
        TextView registerCountryInfantMortality=(TextView)view.findViewById(R.id.RegisterCountryInfantMortality);
        TextView countryPrimarySchoolEnroll=(TextView)view.findViewById(R.id.CountryPrimarySchoolEnroll);
        TextView registerPrimarySchoolEnroll=(TextView)view.findViewById(R.id.RegisterCountryPrimarySchoolEnroll);
        TextView countryUnemployment=(TextView)view.findViewById(R.id.CountryUnemployment);
        TextView registerCountryUnemployment=(TextView)view.findViewById(R.id.RegisterCountryUnemployment);
        TextView countryHealth=(TextView)view.findViewById(R.id.CountryHealth);
        TextView registerCountryHealth=(TextView)view.findViewById(R.id.RegisterCountryHealth);
        TextView countryElectricity=(TextView)view.findViewById(R.id.CountryElectricity);
        TextView registerCountryElectricity=(TextView)view.findViewById(R.id.RegisterCountryElectricity);
        TextView countryPPP=(TextView)view.findViewById(R.id.CountryPPP);
        TextView registerCountryPPP=(TextView)view.findViewById(R.id.RegisterCountryPPP);
        TextView countryGINI=(TextView)view.findViewById(R.id.CountryGini);
        TextView registerCountryGINI=(TextView)view.findViewById(R.id.RegisterCountryGini);
        TextView countrySDG=(TextView)view.findViewById(R.id.CountrySDG);
        TextView registerCountrySDG=(TextView)view.findViewById(R.id.RegisterCountrySDG);
        TextView countryHappiness=(TextView)view.findViewById(R.id.CountryHappiness);
        TextView registerCountryHappiness=(TextView)view.findViewById(R.id.RegisterCountryHappiness);
        TextView countryHDI=(TextView)view.findViewById(R.id.CountryHDI);
        TextView registerCountryHDI=(TextView)view.findViewById(R.id.RegisterCountryHDI);
        TextView countryCorruption=(TextView)view.findViewById(R.id.CountryCorruption);
        TextView registerCountryCorruption=(TextView)view.findViewById(R.id.RegisterCountryCorruption);
        TextView countryGoiter=(TextView)view.findViewById(R.id.CountryGoiter);
        TextView registerCountryGoiter=(TextView)view.findViewById(R.id.RegisterCountryGoiter);
        TextView countryFemaleSmokers=(TextView)view.findViewById(R.id.CountryFemaleSmokers);
        TextView registeredCountryFemaleSmokers=(TextView)view.findViewById(R.id.RegisterCountryFemaleSmokers);
        TextView countryMaleSmokers=(TextView)view.findViewById(R.id.CountryMaleSmokers);
        TextView registerCountryMaleSmokers=(TextView)view.findViewById(R.id.RegisterCountryMaleSmokers);



        if(jsonObject!=null){
            try {
                JSONObject objectSelf=jsonObject.getJSONObject("SELF");
//                    JSONArray arr2=object.names();
//                    System.out.println("inner name "+String.valueOf(arr2));
                JSONObject selfCountry=objectSelf.getJSONObject("registerCoutry");
                registerCountryCapital.setText(selfCountry.getString("capital"));
                registerCountryCurrency.setText(selfCountry.getString("currencyName"));
                registerCountryPrimarySchool.setText(selfCountry.getString("primarySchool"));
                registerCountryPopulation.setText(selfCountry.getString("population"));
                registerCountrySexRatio.setText(selfCountry.getString("sexRatio"));
                registerCountryBirthrate.setText(selfCountry.getString("birthRate"));
                registereCountryDeathRate.setText(selfCountry.getString("deathRate"));
                registerCountryInfantMortality.setText(selfCountry.getString("infantMortalityRate"));
                registerPrimarySchoolEnroll.setText(selfCountry.getString("primarySchool"));
                registerCountryUnemployment.setText(selfCountry.getString("unEmploymentRate"));
                registerCountryHealth.setText(selfCountry.getString("healthInformation"));
                registerCountryElectricity.setText(selfCountry.getString("eletricityConsumption"));
                registerCountryPPP.setText(selfCountry.getString("ppp"));
                registerCountryHDI.setText(selfCountry.getString("hdi"));
                registerCountryGINI.setText(selfCountry.getString("gini"));
                //SDG RANK AND PRI SCHOOL ENROLL
                registerCountrySDG.setText(selfCountry.getString("sdgiRank"));
                registerCountryHappiness.setText(selfCountry.getString("happinessRank"));
                registerCountryCorruption.setText(selfCountry.getString("corruption"));
                registerCountryGoiter.setText(selfCountry.getString("goiter"));
                registeredCountryFemaleSmokers.setText(selfCountry.getString("femaleSmoker"));
                registerCountryMaleSmokers.setText(selfCountry.getString("maleSmoker"));




               JSONObject registerCountry=objectSelf.getJSONObject("country");
                countryCapital.setText(registerCountry.getString("capital"));
                countryCurrency.setText(registerCountry.getString("currencyName"));
                countryPrimarySchool.setText(registerCountry.getString("primarySchool"));
                countryPopulation.setText(registerCountry.getString("population"));
                countrySexRatio.setText(registerCountry.getString("sexRatio"));
                countryBirthRate.setText(registerCountry.getString("birthRate"));
                countryDeathRate.setText(registerCountry.getString("deathRate"));
                countryInfantMortality.setText(registerCountry.getString("infantMortalityRate"));
                countryPrimarySchoolEnroll.setText(registerCountry.getString("primarySchool"));
                countryUnemployment.setText(registerCountry.getString("unEmploymentRate"));
                countryHealth.setText(registerCountry.getString("healthInformation"));
                countryElectricity.setText(registerCountry.getString("eletricityConsumption"));
                countryPPP.setText(registerCountry.getString("ppp"));
                countryHDI.setText(registerCountry.getString("hdi"));
                countryGINI.setText(registerCountry.getString("gini"));
                //SDG RANK AND PRI SCHOOL ENROLL
                countrySDG.setText(registerCountry.getString("sdgiRank"));
                countryHappiness.setText(registerCountry.getString("happinessRank"));
                countryCorruption.setText(registerCountry.getString("corruption"));
                countryGoiter.setText(registerCountry.getString("goiter"));
                countryFemaleSmokers.setText(registerCountry.getString("femaleSmoker"));
                countryMaleSmokers.setText(registerCountry.getString("maleSmoker"));





            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else
            System.out.println("null");
        return view;
    }

}