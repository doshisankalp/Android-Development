package com.example.anuja.reall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AttributesActivity extends AppCompatActivity implements PersonalityFragment.ObjectDataInter{
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Button mybutton;

    public static JSONObject countryObject;
    public static JSONObject cityObject;
    public static JSONObject traitsObject=new JSONObject();
    public static JSONObject traitsObject2=new JSONObject();
    public static String gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attributes);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mybutton=(Button)findViewById(R.id.playlifebutton);

        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        //rb=findViewById(R.id.);
        //rb.setText("FirstButton");

        try {
            traitsObject.put("sex","M");
            traitsObject.put("urbanRular","R");
            traitsObject.put("artistic",0);
            traitsObject.put("athletic",0);
            traitsObject.put("goodLooks",0);
            traitsObject.put("happiness",0);
            traitsObject.put("health",0);
            traitsObject.put("intelligence",0);
            traitsObject.put("musical",0);
            traitsObject.put("physicalEndurance",0);
            traitsObject.put("resistance",0);
            traitsObject.put("spiritual",0);
            traitsObject.put("strength",0);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        Intent i=getIntent();

        try {
            countryObject=new JSONObject(i.getStringExtra("countryObject"));

            cityObject=new JSONObject(i.getStringExtra("cityObject"));

            //if(i.getStringExtra("traitsObject"))!=null);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        //Log.e("countryObject",countryObject.toString());
        //Log.e("cityObject",cityObject.toString());

    }

    public String getgen()
    {
        return gen;
    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PersonalityFragment(), "Personality");
        adapter.addFragment(new FirstNameFragment(), "Name");
        adapter.addFragment(new SurnameFragment(), "Surname");
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
    public void tomainactivity(View view) {
        Intent intent = new Intent(AttributesActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void toselectcity(View view) {
        Intent i=getIntent();
        //Log.e("traitsObject",i.getStringExtra("traitsObject"));

        Intent intent = new Intent(AttributesActivity.this,Selectcity.class);
        startActivity(intent);
    }

    @Override
    public void getObjectData(String value) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        PersonalityFragment personalityFragment=new PersonalityFragment();
        //NameFragment nameFragment=(NameFragment)fragmentManager.findFragmentById(R.id.name_fragment);
        //SurnameFragment surnameFragment= (SurnameFragment) fragmentManager.findFragmentById(R.id.surname_fragment);
        fragmentTransaction.add(R.id.person_fragment,personalityFragment);
        fragmentTransaction.commit();

        try {
            traitsObject2=new JSONObject(value);
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

}

