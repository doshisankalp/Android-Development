package com.example.anuja.reall;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class YourCountry extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Context context;
    Intent i;
    static JSONObject responce_object;
    CountryStatisticsFragment countryStatisticsFragment = new CountryStatisticsFragment();
    CountryWikipediaFragment countryWikipediaFragment=new CountryWikipediaFragment();
    CountryLonelyPlanetFragment countryLonelyPlanetFragment=new CountryLonelyPlanetFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_country_main);
        System.out.println("your country");
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        TextView countryName=(TextView)findViewById(R.id.countryName);
        TextView capital=(TextView)findViewById(R.id.Capital);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        if(googleServicesAvailable()){
            Toast.makeText(this,"perfect",Toast.LENGTH_LONG).show();
        }


        i =getIntent();

        String responce_string= i.getStringExtra("responce_object");
        Log.e("responce string:", responce_string);
        try {
            responce_object=new JSONObject(responce_string);
            Log.d("responce object 23", String.valueOf(responce_object));
            JSONObject self=responce_object.getJSONObject("SELF");
            JSONObject country=self.getJSONObject("country");
            countryName.setText(country.getString("countryName"));
            capital.setText(country.getString("capital"));
            countryStatisticsFragment.setObj(responce_object,countryWikipediaFragment,countryLonelyPlanetFragment);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public boolean googleServicesAvailable(){

        GoogleApiAvailability api=GoogleApiAvailability.getInstance();
        int isAvailable=api.isGooglePlayServicesAvailable(this);
        if(isAvailable== ConnectionResult.SUCCESS){
           // Toast.makeText(this,"Cant connect to play services",Toast.LENGTH_LONG).show();

            return  true;
        }
        else if(api.isUserResolvableError(isAvailable)){
            Dialog dialog=api.getErrorDialog(this,isAvailable,0);
            dialog.show();
            //Toast.makeText(this,"Cant connect to play services",Toast.LENGTH_LONG).show();


        }else
        {
            //Toast.makeText(this,"Cant connect to play services",Toast.LENGTH_LONG).show();
        }
        return false;
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        adapter.addFragment(countryStatisticsFragment, "Statistics");

        adapter.addFragment(countryWikipediaFragment, "Wikipedia");
        adapter.addFragment(countryLonelyPlanetFragment,"Lonely Planet");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override

        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override

        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }


}
