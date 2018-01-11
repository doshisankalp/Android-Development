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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import android.util.*;
public class YourCountry extends AppCompatActivity implements OnMapReadyCallback {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    GoogleMap mGoogleMap;
    Context context;
    MapFragment map;
    JSONObject countryObj;
    JSONObject self;
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
        ImageView country=(ImageView)findViewById(R.id.flag) ;
        TextView capital=(TextView)findViewById(R.id.Capital);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        if(googleServicesAvailable()){
            Toast.makeText(this,"perfect",Toast.LENGTH_LONG).show();
            ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
           // map.getMapAsync( this);
        }


        i =getIntent();

        String responce_string= i.getStringExtra("responce_object");
        Log.e("responce string:", responce_string);
        try {
            responce_object=new JSONObject(responce_string);
            Log.d("responce object 23", String.valueOf(responce_object));
            self=responce_object.getJSONObject("SELF");
            countryObj=self.getJSONObject("country");




            String country_code=countryObj.getString("code").toUpperCase();

            if(country_code.equals("AD"))
                country.setImageResource(R.drawable.ad);
            else if(country_code.equals("AE"))
                country.setImageResource(R.drawable.ae);
            else if(country_code.equals("AF"))
                country.setImageResource(R.drawable.af);
            else if(country_code.equals("AG"))
                country.setImageResource(R.drawable.ag);
            else if(country_code.equals("AL"))
                country.setImageResource(R.drawable.al);
            else if(country_code.equals("AM"))
                country.setImageResource(R.drawable.am);
            else if(country_code.equals("AO"))
                country.setImageResource(R.drawable.ao);
            else if(country_code.equals("AR"))
                country.setImageResource(R.drawable.ar);
            else if(country_code.equals("AT"))
                country.setImageResource(R.drawable.at);
            else if(country_code.equals("AU"))
                country.setImageResource(R.drawable.au);
            else if(country_code.equals("AZ"))
                country.setImageResource(R.drawable.az);
            else if(country_code.equals("BA"))
                country.setImageResource(R.drawable.ba);
            else if(country_code.equals("BB"))
                country.setImageResource(R.drawable.bb);
            else if(country_code.equals("BD"))
                country.setImageResource(R.drawable.bd);
            else if(country_code.equals("BE"))
                country.setImageResource(R.drawable.be);
            else if(country_code.equals("BF"))
                country.setImageResource(R.drawable.bf);
            else if(country_code.equals("BG"))
                country.setImageResource(R.drawable.bg);
            else if(country_code.equals("BH"))
                country.setImageResource(R.drawable.bh);
            else if(country_code.equals("BI"))
                country.setImageResource(R.drawable.bi);
            else if(country_code.equals("BJ"))
                country.setImageResource(R.drawable.bj);
            else if(country_code.equals("BN"))
                country.setImageResource(R.drawable.bn);
            else if(country_code.equals("BO"))
                country.setImageResource(R.drawable.bo);
            else if(country_code.equals("BR"))
                country.setImageResource(R.drawable.br);
            else if(country_code.equals("BS"))
                country.setImageResource(R.drawable.bs);
            else if(country_code.equals("BT"))
                country.setImageResource(R.drawable.bt);
            else if(country_code.equals("BW"))
                country.setImageResource(R.drawable.bw);
            else if(country_code.equals("BY"))
                country.setImageResource(R.drawable.by);
            else if(country_code.equals("BZ"))
                country.setImageResource(R.drawable.bz);
            else if(country_code.equals("CA"))
                country.setImageResource(R.drawable.ca);
            else if(country_code.equals("CD"))
                country.setImageResource(R.drawable.cd);
            else if(country_code.equals("CF"))
                country.setImageResource(R.drawable.cf);
            else if(country_code.equals("CG"))
                country.setImageResource(R.drawable.cg);
            else if(country_code.equals("CH"))
                country.setImageResource(R.drawable.ch);
            else if(country_code.equals("CI"))
                country.setImageResource(R.drawable.ci);
            else if(country_code.equals("CL"))
                country.setImageResource(R.drawable.cl);
            else if(country_code.equals("CM"))
                country.setImageResource(R.drawable.cm);
            else if(country_code.equals("CN"))
                country.setImageResource(R.drawable.cn);
            else if(country_code.equals("CO"))
                country.setImageResource(R.drawable.co);
            else if(country_code.equals("CR"))
                country.setImageResource(R.drawable.cr);
            else if(country_code.equals("CU"))
                country.setImageResource(R.drawable.cu);
            else if(country_code.equals("CV"))
                country.setImageResource(R.drawable.cv);
            else if(country_code.equals("CY"))
                country.setImageResource(R.drawable.cy);
            else if(country_code.equals("CZ"))
                country.setImageResource(R.drawable.cz);
            else if(country_code.equals("DE"))
                country.setImageResource(R.drawable.de);
            else if(country_code.equals("DJ"))
                country.setImageResource(R.drawable.dj);
            else if(country_code.equals("DK"))
                country.setImageResource(R.drawable.dk);
            else if(country_code.equals("DM"))
                country.setImageResource(R.drawable.dm);
            else if(country_code.equals("DO"))
                country.setImageResource(R.drawable.do1);
            else if(country_code.equals("DZ"))
                country.setImageResource(R.drawable.dz);
            else if(country_code.equals("EC"))
                country.setImageResource(R.drawable.ec);
            else if(country_code.equals("EE"))
                country.setImageResource(R.drawable.ee);
            else if(country_code.equals("EG"))
                country.setImageResource(R.drawable.eg);
            else if(country_code.equals("EH"))
                country.setImageResource(R.drawable.eh);
            else if(country_code.equals("ER"))
                country.setImageResource(R.drawable.er);
            else if(country_code.equals("ES"))
                country.setImageResource(R.drawable.es);
            else if(country_code.equals("ET"))
                country.setImageResource(R.drawable.et);
            else if(country_code.equals("FI"))
                country.setImageResource(R.drawable.fi);
            else if(country_code.equals("FJ"))
                country.setImageResource(R.drawable.fj);
            else if(country_code.equals("FM"))
                country.setImageResource(R.drawable.fm);
            else if(country_code.equals("FR"))
                country.setImageResource(R.drawable.fr);
            else if(country_code.equals("GA"))
                country.setImageResource(R.drawable.ga);
            else if(country_code.equals("GB"))
                country.setImageResource(R.drawable.gb);
            else if(country_code.equals("GD"))
                country.setImageResource(R.drawable.gd);
            else if(country_code.equals("GE"))
                country.setImageResource(R.drawable.ge);
            else if(country_code.equals("GF"))
                country.setImageResource(R.drawable.gf);
            else if(country_code.equals("GH"))
                country.setImageResource(R.drawable.gh);
            else if(country_code.equals("GM"))
                country.setImageResource(R.drawable.gm);
            else if(country_code.equals("GN"))
                country.setImageResource(R.drawable.gn);
            else if(country_code.equals("GP"))
                country.setImageResource(R.drawable.gp);
            else if(country_code.equals("GQ"))
                country.setImageResource(R.drawable.gq);
            else if(country_code.equals("GR"))
                country.setImageResource(R.drawable.gr);
            else if(country_code.equals("GT"))
                country.setImageResource(R.drawable.gt);
            else if(country_code.equals("GU"))
                country.setImageResource(R.drawable.gu);
            else if(country_code.equals("GW"))
                country.setImageResource(R.drawable.gw);
            else if(country_code.equals("GY"))
                country.setImageResource(R.drawable.gy);
            else if(country_code.equals("HK"))
                country.setImageResource(R.drawable.hk);
            else if(country_code.equals("HN"))
                country.setImageResource(R.drawable.hn);
            else if(country_code.equals("HR"))
                country.setImageResource(R.drawable.hr);
            else if(country_code.equals("HT"))
                country.setImageResource(R.drawable.ht);
            else if(country_code.equals("HU"))
                country.setImageResource(R.drawable.hu);
            else if(country_code.equals("ID"))
                country.setImageResource(R.drawable.id);
            else if(country_code.equals("IE"))
                country.setImageResource(R.drawable.ie);
            else if(country_code.equals("IL"))
                country.setImageResource(R.drawable.il);
            else if(country_code.equals("IN"))
                country.setImageResource(R.drawable.in);
            else if(country_code.equals("IQ"))
                country.setImageResource(R.drawable.iq);
            else if(country_code.equals("IR"))
                country.setImageResource(R.drawable.ir);
            else if(country_code.equals("IS"))
                country.setImageResource(R.drawable.is);
            else if(country_code.equals("IT"))
                country.setImageResource(R.drawable.it);
            else if(country_code.equals("JM"))
                country.setImageResource(R.drawable.jm);
            else if(country_code.equals("JO"))
                country.setImageResource(R.drawable.jo);
            else if(country_code.equals("JP"))
                country.setImageResource(R.drawable.jp);
            else if(country_code.equals("KE"))
                country.setImageResource(R.drawable.ke);
            else if(country_code.equals("KG"))
                country.setImageResource(R.drawable.kg);
            else if(country_code.equals("KH"))
                country.setImageResource(R.drawable.kh);
            else if(country_code.equals("KI"))
                country.setImageResource(R.drawable.ki);
            else if(country_code.equals("KM"))
                country.setImageResource(R.drawable.km);
            else if(country_code.equals("KN"))
                country.setImageResource(R.drawable.kn);
            else if(country_code.equals("KP"))
                country.setImageResource(R.drawable.kp);
            else if(country_code.equals("KR"))
                country.setImageResource(R.drawable.kr);
            else if(country_code.equals("KS"))
                country.setImageResource(R.drawable.ks);
            else if(country_code.equals("KW"))
                country.setImageResource(R.drawable.kw);
            else if(country_code.equals("KZ"))
                country.setImageResource(R.drawable.kz);
            else if(country_code.equals("LA"))
                country.setImageResource(R.drawable.la);
            else if(country_code.equals("LB"))
                country.setImageResource(R.drawable.lb);
            else if(country_code.equals("LC"))
                country.setImageResource(R.drawable.lc);
            else if(country_code.equals("LI"))
                country.setImageResource(R.drawable.li);
            else if(country_code.equals("LK"))
                country.setImageResource(R.drawable.lk);
            else if(country_code.equals("LR"))
                country.setImageResource(R.drawable.lr);
            else if(country_code.equals("LS"))
                country.setImageResource(R.drawable.ls);
            else if(country_code.equals("LT"))
                country.setImageResource(R.drawable.lt);
            else if(country_code.equals("LU"))
                country.setImageResource(R.drawable.lu);
            else if(country_code.equals("LV"))
                country.setImageResource(R.drawable.lv);
            else if(country_code.equals("LY"))
                country.setImageResource(R.drawable.ly);
            else if(country_code.equals("MA"))
                country.setImageResource(R.drawable.ma);
            else if(country_code.equals("MC"))
                country.setImageResource(R.drawable.mc);
            else if(country_code.equals("MD"))
                country.setImageResource(R.drawable.md);
            else if(country_code.equals("ME"))
                country.setImageResource(R.drawable.me);
            else if(country_code.equals("MG"))
                country.setImageResource(R.drawable.mg);
            else if(country_code.equals("MH"))
                country.setImageResource(R.drawable.mg);
            else if(country_code.equals("MK"))
                country.setImageResource(R.drawable.mk);
            else if(country_code.equals("ML"))
                country.setImageResource(R.drawable.ml);
            else if(country_code.equals("MM"))
                country.setImageResource(R.drawable.mm);
            else if(country_code.equals("MN"))
                country.setImageResource(R.drawable.mn);
            else if(country_code.equals("MO"))
                country.setImageResource(R.drawable.mo);
            else if(country_code.equals("MQ"))
                country.setImageResource(R.drawable.mq);
            else if(country_code.equals("MR"))
                country.setImageResource(R.drawable.mr);
            else if(country_code.equals("MT"))
                country.setImageResource(R.drawable.mt);
            else if(country_code.equals("MU"))
                country.setImageResource(R.drawable.mu);
            else if(country_code.equals("MV"))
                country.setImageResource(R.drawable.mv);
            else if(country_code.equals("MW"))
                country.setImageResource(R.drawable.mw);
            else if(country_code.equals("MX"))
                country.setImageResource(R.drawable.mx);
            else if(country_code.equals("MY"))
                country.setImageResource(R.drawable.my);
            else if(country_code.equals("MZ"))
                country.setImageResource(R.drawable.mz);
            else if(country_code.equals("NA"))
                country.setImageResource(R.drawable.na);
            else if(country_code.equals("NC"))
                country.setImageResource(R.drawable.nc);
            else if(country_code.equals("NE"))
                country.setImageResource(R.drawable.ne);
            else if(country_code.equals("NG"))
                country.setImageResource(R.drawable.ng);
            else if(country_code.equals("NI"))
                country.setImageResource(R.drawable.ni);
            else if(country_code.equals("NL"))
                country.setImageResource(R.drawable.nl);
            else if(country_code.equals("NO"))
                country.setImageResource(R.drawable.no);
            else if(country_code.equals("NP"))
                country.setImageResource(R.drawable.np);
            else if(country_code.equals("NR"))
                country.setImageResource(R.drawable.nr);
            else if(country_code.equals("NZ"))
                country.setImageResource(R.drawable.nz);
            else if(country_code.equals("OM"))
                country.setImageResource(R.drawable.om);
            else if(country_code.equals("PA"))
                country.setImageResource(R.drawable.pa);
            else if(country_code.equals("PE"))
                country.setImageResource(R.drawable.pe);
            else if(country_code.equals("PF"))
                country.setImageResource(R.drawable.pf);
            else if(country_code.equals("PG"))
                country.setImageResource(R.drawable.pg);
            else if(country_code.equals("PH"))
                country.setImageResource(R.drawable.ph);
            else if(country_code.equals("PK"))
                country.setImageResource(R.drawable.pk);
            else if(country_code.equals("PL"))
                country.setImageResource(R.drawable.pl);
            else if(country_code.equals("PR"))
                country.setImageResource(R.drawable.pr);
            else if(country_code.equals("PT"))
                country.setImageResource(R.drawable.pt);
            else if(country_code.equals("PW"))
                country.setImageResource(R.drawable.pw);
            else if(country_code.equals("PY"))
                country.setImageResource(R.drawable.py);
            else if(country_code.equals("QA"))
                country.setImageResource(R.drawable.qa);
            else if(country_code.equals("RE"))
                country.setImageResource(R.drawable.re);
            else if(country_code.equals("RO"))
                country.setImageResource(R.drawable.ro);
            else if(country_code.equals("RS"))
                country.setImageResource(R.drawable.rs);
            else if(country_code.equals("RU"))
                country.setImageResource(R.drawable.ru);
            else if(country_code.equals("RW"))
                country.setImageResource(R.drawable.rw);
            else if(country_code.equals("SA"))
                country.setImageResource(R.drawable.sa);
            else if(country_code.equals("SB"))
                country.setImageResource(R.drawable.sb);
            else if(country_code.equals("SC"))
                country.setImageResource(R.drawable.sc);
            else if(country_code.equals("SD"))
                country.setImageResource(R.drawable.sd);
            else if(country_code.equals("SE"))
                country.setImageResource(R.drawable.se);
            else if(country_code.equals("SG"))
                country.setImageResource(R.drawable.sg);
            else if(country_code.equals("SI"))
                country.setImageResource(R.drawable.si);
            else if(country_code.equals("SK"))
                country.setImageResource(R.drawable.sk);
            else if(country_code.equals("SL"))
                country.setImageResource(R.drawable.sl);
            else if(country_code.equals("SM"))
                country.setImageResource(R.drawable.sm);
            else if(country_code.equals("SN"))
                country.setImageResource(R.drawable.sn);
            else if(country_code.equals("SO"))
                country.setImageResource(R.drawable.so);
            else if(country_code.equals("SR"))
                country.setImageResource(R.drawable.sr);
            else if(country_code.equals("ST"))
                country.setImageResource(R.drawable.st);
            else if(country_code.equals("SV"))
                country.setImageResource(R.drawable.sv);
            else if(country_code.equals("SY"))
                country.setImageResource(R.drawable.sy);
            else if(country_code.equals("SZ"))
                country.setImageResource(R.drawable.sz);
            else if(country_code.equals("TD"))
                country.setImageResource(R.drawable.td);
            else if(country_code.equals("TG"))
                country.setImageResource(R.drawable.tg);
            else if(country_code.equals("TH"))
                country.setImageResource(R.drawable.th);
            else if(country_code.equals("TJ"))
                country.setImageResource(R.drawable.tj);
            else if(country_code.equals("TL"))
                country.setImageResource(R.drawable.tl);
            else if(country_code.equals("TM"))
                country.setImageResource(R.drawable.tm);
            else if(country_code.equals("TN"))
                country.setImageResource(R.drawable.tn);
            else if(country_code.equals("TO"))
                country.setImageResource(R.drawable.to);
            else if(country_code.equals("TR"))
                country.setImageResource(R.drawable.tr);
            else if(country_code.equals("TT"))
                country.setImageResource(R.drawable.tt);
            else if(country_code.equals("TV"))
                country.setImageResource(R.drawable.tv);
            else if(country_code.equals("TW"))
                country.setImageResource(R.drawable.tw);
            else if(country_code.equals("TZ"))
                country.setImageResource(R.drawable.tz);
            else if(country_code.equals("UA"))
                country.setImageResource(R.drawable.ua);
            else if(country_code.equals("UG"))
                country.setImageResource(R.drawable.ug);
            else if(country_code.equals("US"))
                country.setImageResource(R.drawable.us);
            else if(country_code.equals("UY"))
                country.setImageResource(R.drawable.uy);
            else if(country_code.equals("UZ"))
                country.setImageResource(R.drawable.uz);
            else if(country_code.equals("VA"))
                country.setImageResource(R.drawable.va);
            else if(country_code.equals("VC"))
                country.setImageResource(R.drawable.vc);
            else if(country_code.equals("VE"))
                country.setImageResource(R.drawable.ve);
            else if(country_code.equals("VN"))
                country.setImageResource(R.drawable.vn);
            else if(country_code.equals("VU"))
                country.setImageResource(R.drawable.vu);
            else if(country_code.equals("WS"))
                country.setImageResource(R.drawable.ws);
            else if(country_code.equals("YE"))
                country.setImageResource(R.drawable.ye);
            else if(country_code.equals("ZA"))
                country.setImageResource(R.drawable.za);
            else if(country_code.equals("ZM"))
                country.setImageResource(R.drawable.zm);
            else if(country_code.equals("ZW"))
                country.setImageResource(R.drawable.zw);





            countryName.setText(countryObj.getString("countryName"));
            capital.setText(countryObj.getString("capital"));
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //MapsInitializer.initialize(getContext())
        mGoogleMap=googleMap;
        try {

            JSONObject city=self.getJSONObject("city");
            double lat=city.getDouble("latitude");
            double lon=city.getDouble("longitude");

            mGoogleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(lat, lon))
                    .title("Hello world"));
            LatLng latLng=new LatLng(lat,lon);
            CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(latLng, 11.0f);
            mGoogleMap.animateCamera(yourLocation);

        } catch (JSONException e) {
            e.printStackTrace();
        }


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
