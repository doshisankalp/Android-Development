package com.example.anuja.reall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StartLife extends AppCompatActivity {
    Intent i;
    JSONObject responce_object=new JSONObject();
    SharedPreferences pref;
    Button start_life;
    static String ID="";
    String url;
    ImageView reg_country,country;
    TextView name,gender,location,language,religion,capital,currency,primary_school,primary_enrol,population,unemployment_rate,sex_ratio,birth_rate,death_rate,health_per_capita,access_elect,goiter,corruption,hdi,happiness_index,gini,sdg,ppp,agri,services,industry;
    TextView reg_capital,reg_currency,reg_primary_school,reg_primary_enrol,reg_population,reg_unemployment_rate,reg_sex_ratio,reg_birth_rate,reg_death_rate,reg_health_per_capita,reg_access_elect,reg_goiter,reg_corruption,reg_hdi,reg_happiness_index,reg_gini,reg_sdg,reg_ppp,reg_agri,reg_services,reg_industry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_life);

        i =getIntent();
        ID= i.getStringExtra("ID");
        Log.e("In start:", String.valueOf(ID));
        url=Constant.GAMEURL+"get_person/"+ID;
        reg_country=(ImageView)findViewById(R.id.reg_country_flag);
        country=(ImageView)findViewById(R.id.country_flag);

        start_life=(Button)findViewById(R.id.start_life);
        name=(TextView)findViewById(R.id.Name);
        gender=(TextView)findViewById(R.id.start_life_gender);
        location=(TextView)findViewById(R.id.start_life_location);
        language=(TextView)findViewById(R.id.start_life_language);
        capital=(TextView)findViewById(R.id.capital);
        religion=(TextView)findViewById(R.id.start_life_religion);
        currency=(TextView)findViewById(R.id.currency);
        primary_school=(TextView)findViewById(R.id.primary_school);
        population=(TextView)findViewById(R.id.population);
        unemployment_rate=(TextView)findViewById(R.id.unemployment_rate);
        sex_ratio=(TextView)findViewById(R.id.sex_ratio);
        birth_rate=(TextView)findViewById(R.id.birth_rate);
        death_rate=(TextView)findViewById(R.id.death_rate);
        health_per_capita=(TextView)findViewById(R.id.health_per_capita);
        access_elect=(TextView)findViewById(R.id.access_elect);
        goiter=(TextView)findViewById(R.id.goitre);
        corruption=(TextView)findViewById(R.id.corruption);
        hdi=(TextView)findViewById(R.id.hdi);
        happiness_index=(TextView)findViewById(R.id.happiness_index);
        gini=(TextView)findViewById(R.id.gini);
        sdg=(TextView)findViewById(R.id.sdg);
        ppp=(TextView)findViewById(R.id.ppp);
        agri=(TextView)findViewById(R.id.agri);
        services=(TextView)findViewById(R.id.services);
        industry=(TextView)findViewById(R.id.industry);
        primary_enrol=(TextView)findViewById(R.id.primary_school_enr);
        reg_primary_enrol=(TextView)findViewById(R.id.reg_primary_school_enr);

        reg_capital=(TextView)findViewById(R.id.capital1);
        reg_currency=(TextView)findViewById(R.id.currency1);
        reg_primary_school=(TextView)findViewById(R.id.primary_school1);
        reg_population=(TextView)findViewById(R.id.population1);
        reg_unemployment_rate=(TextView)findViewById(R.id.unemployment_rate1);
        reg_sex_ratio=(TextView)findViewById(R.id.sex_ratio1);
        reg_birth_rate=(TextView)findViewById(R.id.birth_rate1);
        reg_death_rate=(TextView)findViewById(R.id.death_rate1);
        reg_health_per_capita=(TextView)findViewById(R.id.health_per_capita1);
        reg_access_elect=(TextView)findViewById(R.id.access_elect1);
        reg_goiter=(TextView)findViewById(R.id.goitre1);
        reg_corruption=(TextView)findViewById(R.id.corruption1);
        reg_hdi=(TextView)findViewById(R.id.hdi1);
        reg_happiness_index=(TextView)findViewById(R.id.happiness_index1);
        reg_gini=(TextView)findViewById(R.id.gini1);
        reg_sdg=(TextView)findViewById(R.id.sdg1);
        reg_ppp=(TextView)findViewById(R.id.ppp1);
        reg_agri=(TextView)findViewById(R.id.agri1);
        reg_services=(TextView)findViewById(R.id.services1);
        reg_industry=(TextView)findViewById(R.id.industry1);
        get_life_info();
    }




    private void get_life_info() {
        final JSONObject jsonobject_one = new JSONObject();
        final JSONObject jsonObject=new JSONObject();
        RequestQueue requestQueue= Volley.newRequestQueue(StartLife.this);
        Log.e("url",url);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(


                Request.Method.GET,url, jsonobject_one,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            responce_object=response;
                            JSONObject object = response.getJSONObject("SELF");
                            name.setText(object.getString("fullName"));
                            gender.setText( object.getString("sex"));
                            JSONObject object5=object.getJSONObject("traits");
                            happiness_index.setText(object5.getString("happiness"));
                            JSONObject object1=object.getJSONObject("country");
                            String country_code=object1.getString("code");
                            Log.e("code",country_code);

                            if(country_code.equals("AD"))
                                country.setImageResource(R.raw.ad);
                            if(country_code.equals("AE"))
                                country.setImageResource(R.raw.ae);
                            if(country_code.equals("AF"))
                                country.setImageResource(R.raw.af);
                            if(country_code.equals("AG"))
                                country.setImageResource(R.raw.ag);
                            if(country_code.equals("AL"))
                                country.setImageResource(R.raw.al);
                            if(country_code.equals("AM"))
                                country.setImageResource(R.raw.am);
                            if(country_code.equals("AO"))
                                country.setImageResource(R.raw.ao);
                            if(country_code.equals("AR"))
                                country.setImageResource(R.raw.ar);
                            if(country_code.equals("AT"))
                                country.setImageResource(R.raw.at);
                            if(country_code.equals("AU"))
                                country.setImageResource(R.raw.au);
                            if(country_code.equals("AZ"))
                                country.setImageResource(R.raw.az);
                            if(country_code.equals("BA"))
                                country.setImageResource(R.raw.ba);
                            if(country_code.equals("BB"))
                                country.setImageResource(R.raw.bb);
                            if(country_code.equals("BD"))
                                country.setImageResource(R.raw.bd);
                            if(country_code.equals("BE"))
                                country.setImageResource(R.raw.be);
                            if(country_code.equals("BF"))
                                country.setImageResource(R.raw.bf);
                            if(country_code.equals("BG"))
                                country.setImageResource(R.raw.bg);
                            if(country_code.equals("BH"))
                                country.setImageResource(R.raw.bh);
                            if(country_code.equals("BI"))
                                country.setImageResource(R.raw.bi);
                            if(country_code.equals("BJ"))
                                country.setImageResource(R.raw.bj);
                            if(country_code.equals("BN"))
                                country.setImageResource(R.raw.bn);
                            if(country_code.equals("BO"))
                                country.setImageResource(R.raw.bo);
                            if(country_code.equals("BR"))
                                country.setImageResource(R.raw.br);
                            if(country_code.equals("BS"))
                                country.setImageResource(R.raw.bs);
                            if(country_code.equals("BT"))
                                country.setImageResource(R.raw.bt);
                            if(country_code.equals("BW"))
                                country.setImageResource(R.raw.bw);
                            if(country_code.equals("BY"))
                                country.setImageResource(R.raw.by);
                            if(country_code.equals("BZ"))
                                country.setImageResource(R.raw.bz);
                            if(country_code.equals("CA"))
                                country.setImageResource(R.raw.ca);
                            if(country_code.equals("CD"))
                                country.setImageResource(R.raw.cd);
                            if(country_code.equals("CF"))
                                country.setImageResource(R.raw.cf);
                            if(country_code.equals("CG"))
                                country.setImageResource(R.raw.cg);
                            if(country_code.equals("CH"))
                                country.setImageResource(R.raw.ch);
                            if(country_code.equals("CI"))
                                country.setImageResource(R.raw.ci);
                            if(country_code.equals("CL"))
                                country.setImageResource(R.raw.cl);
                            if(country_code.equals("CM"))
                                country.setImageResource(R.raw.cm);
                            if(country_code.equals("CN"))
                                country.setImageResource(R.raw.cn);
                            if(country_code.equals("CO"))
                                country.setImageResource(R.raw.co);
                            if(country_code.equals("CR"))
                                country.setImageResource(R.raw.cr);
                            if(country_code.equals("CU"))
                                country.setImageResource(R.raw.cu);
                            if(country_code.equals("CV"))
                                country.setImageResource(R.raw.cv);
                            if(country_code.equals("CY"))
                                country.setImageResource(R.raw.cy);
                            if(country_code.equals("CZ"))
                                country.setImageResource(R.raw.cz);
                            if(country_code.equals("DE"))
                                country.setImageResource(R.raw.de);
                            if(country_code.equals("DJ"))
                                country.setImageResource(R.raw.dj);
                            if(country_code.equals("DK"))
                                country.setImageResource(R.raw.dk);
                            if(country_code.equals("DM"))
                                country.setImageResource(R.raw.dm);
                            if(country_code.equals("DO"))
                                country.setImageResource(R.raw.do1);
                            if(country_code.equals("DZ"))
                                country.setImageResource(R.raw.dz);
                            if(country_code.equals("EC"))
                                country.setImageResource(R.raw.ec);
                            if(country_code.equals("EE"))
                                country.setImageResource(R.raw.ee);
                            if(country_code.equals("EG"))
                                country.setImageResource(R.raw.eg);
                            if(country_code.equals("EH"))
                                country.setImageResource(R.raw.eh);
                            if(country_code.equals("ER"))
                                country.setImageResource(R.raw.er);
                            if(country_code.equals("ES"))
                                country.setImageResource(R.raw.es);
                            if(country_code.equals("ET"))
                                country.setImageResource(R.raw.et);
                            if(country_code.equals("FI"))
                                country.setImageResource(R.raw.fi);
                            if(country_code.equals("FJ"))
                                country.setImageResource(R.raw.fj);
                            if(country_code.equals("FM"))
                                country.setImageResource(R.raw.fm);
                            if(country_code.equals("FR"))
                                country.setImageResource(R.raw.fr);
                            if(country_code.equals("GA"))
                                country.setImageResource(R.raw.ga);
                            if(country_code.equals("GB"))
                                country.setImageResource(R.raw.gb);
                            if(country_code.equals("GD"))
                                country.setImageResource(R.raw.gd);
                            if(country_code.equals("GE"))
                                country.setImageResource(R.raw.ge);
                            if(country_code.equals("GF"))
                                country.setImageResource(R.raw.gf);
                            if(country_code.equals("GH"))
                                country.setImageResource(R.raw.gh);
                            if(country_code.equals("GM"))
                                country.setImageResource(R.raw.gm);
                            if(country_code.equals("GN"))
                                country.setImageResource(R.raw.gn);
                            if(country_code.equals("GP"))
                                country.setImageResource(R.raw.gp);
                            if(country_code.equals("GQ"))
                                country.setImageResource(R.raw.gq);
                            if(country_code.equals("GR"))
                                country.setImageResource(R.raw.gr);
                            if(country_code.equals("GT"))
                                country.setImageResource(R.raw.gt);
                            if(country_code.equals("GU"))
                                country.setImageResource(R.raw.gu);
                            if(country_code.equals("GW"))
                                country.setImageResource(R.raw.gw);
                            if(country_code.equals("GY"))
                                country.setImageResource(R.raw.gy);
                            if(country_code.equals("HK"))
                                country.setImageResource(R.raw.hk);
                            if(country_code.equals("HN"))
                                country.setImageResource(R.raw.hn);
                            if(country_code.equals("HR"))
                                country.setImageResource(R.raw.hr);
                            if(country_code.equals("HT"))
                                country.setImageResource(R.raw.ht);
                            if(country_code.equals("HU"))
                                country.setImageResource(R.raw.hu);
                            if(country_code.equals("ID"))
                                country.setImageResource(R.raw.id);
                            if(country_code.equals("IE"))
                                country.setImageResource(R.raw.ie);
                            if(country_code.equals("IL"))
                                country.setImageResource(R.raw.il);
                            if(country_code.equals("IN"))
                                country.setImageResource(R.raw.in);
                            if(country_code.equals("IQ"))
                                country.setImageResource(R.raw.iq);
                            if(country_code.equals("IR"))
                                country.setImageResource(R.raw.ir);
                            if(country_code.equals("IS"))
                                country.setImageResource(R.raw.is);
                            if(country_code.equals("IT"))
                                country.setImageResource(R.raw.it);
                            if(country_code.equals("JM"))
                                country.setImageResource(R.raw.jm);
                            if(country_code.equals("JO"))
                                country.setImageResource(R.raw.jo);
                            if(country_code.equals("JP"))
                                country.setImageResource(R.raw.jp);
                            if(country_code.equals("KE"))
                                country.setImageResource(R.raw.ke);
                            if(country_code.equals("KG"))
                                country.setImageResource(R.raw.kg);
                            if(country_code.equals("KH"))
                                country.setImageResource(R.raw.kh);
                            if(country_code.equals("KI"))
                                country.setImageResource(R.raw.ki);
                            if(country_code.equals("KM"))
                                country.setImageResource(R.raw.km);
                            if(country_code.equals("KN"))
                                country.setImageResource(R.raw.kn);
                            if(country_code.equals("KP"))
                                country.setImageResource(R.raw.kp);
                            if(country_code.equals("KR"))
                                country.setImageResource(R.raw.kr);
                            if(country_code.equals("KS"))
                                country.setImageResource(R.raw.ks);
                            if(country_code.equals("KW"))
                                country.setImageResource(R.raw.kw);
                            if(country_code.equals("KZ"))
                                country.setImageResource(R.raw.kz);
                            if(country_code.equals("LA"))
                                country.setImageResource(R.raw.la);
                            if(country_code.equals("LB"))
                                country.setImageResource(R.raw.lb);
                            if(country_code.equals("LC"))
                                country.setImageResource(R.raw.lc);
                            if(country_code.equals("LI"))
                                country.setImageResource(R.raw.li);
                            if(country_code.equals("LK"))
                                country.setImageResource(R.raw.lk);
                            if(country_code.equals("LR"))
                                country.setImageResource(R.raw.lr);
                            if(country_code.equals("LS"))
                                country.setImageResource(R.raw.ls);
                            if(country_code.equals("LT"))
                                country.setImageResource(R.raw.lt);
                            if(country_code.equals("LU"))
                                country.setImageResource(R.raw.lu);
                            if(country_code.equals("LV"))
                                country.setImageResource(R.raw.lv);
                            if(country_code.equals("LY"))
                                country.setImageResource(R.raw.ly);
                            if(country_code.equals("MA"))
                                country.setImageResource(R.raw.ma);
                            if(country_code.equals("MC"))
                                country.setImageResource(R.raw.mc);
                            if(country_code.equals("MD"))
                                country.setImageResource(R.raw.md);
                            if(country_code.equals("ME"))
                                country.setImageResource(R.raw.me);
                            if(country_code.equals("MG"))
                                country.setImageResource(R.raw.mg);
                            if(country_code.equals("MH"))
                                country.setImageResource(R.raw.mg);
                            if(country_code.equals("MK"))
                                country.setImageResource(R.raw.mk);
                            if(country_code.equals("ML"))
                                country.setImageResource(R.raw.ml);
                            if(country_code.equals("MM"))
                                country.setImageResource(R.raw.mm);
                            if(country_code.equals("MN"))
                                country.setImageResource(R.raw.mn);
                            if(country_code.equals("MO"))
                                country.setImageResource(R.raw.mo);
                            if(country_code.equals("MQ"))
                                country.setImageResource(R.raw.mq);
                            if(country_code.equals("MR"))
                                country.setImageResource(R.raw.mr);
                            if(country_code.equals("MT"))
                                country.setImageResource(R.raw.mt);
                            if(country_code.equals("MU"))
                                country.setImageResource(R.raw.mu);
                            if(country_code.equals("MV"))
                                country.setImageResource(R.raw.mv);
                            if(country_code.equals("MW"))
                                country.setImageResource(R.raw.mw);
                            if(country_code.equals("MX"))
                                country.setImageResource(R.raw.mx);
                            if(country_code.equals("MY"))
                                country.setImageResource(R.raw.my);
                            if(country_code.equals("MZ"))
                                country.setImageResource(R.raw.mz);
                            if(country_code.equals("NA"))
                                country.setImageResource(R.raw.na);
                            if(country_code.equals("NC"))
                                country.setImageResource(R.raw.nc);
                            if(country_code.equals("NE"))
                                country.setImageResource(R.raw.ne);
                            if(country_code.equals("NG"))
                                country.setImageResource(R.raw.ng);
                            if(country_code.equals("NI"))
                                country.setImageResource(R.raw.ni);
                            if(country_code.equals("NL"))
                                country.setImageResource(R.raw.nl);
                            if(country_code.equals("NO"))
                                country.setImageResource(R.raw.no);
                            if(country_code.equals("NP"))
                                country.setImageResource(R.raw.np);
                            if(country_code.equals("NR"))
                                country.setImageResource(R.raw.nr);
                            if(country_code.equals("NZ"))
                                country.setImageResource(R.raw.nz);
                            if(country_code.equals("OM"))
                                country.setImageResource(R.raw.om);
                            if(country_code.equals("PA"))
                                country.setImageResource(R.raw.pa);
                            if(country_code.equals("PE"))
                                country.setImageResource(R.raw.pe);
                            if(country_code.equals("PF"))
                                country.setImageResource(R.raw.pf);
                            if(country_code.equals("PG"))
                                country.setImageResource(R.raw.pg);
                            if(country_code.equals("PH"))
                                country.setImageResource(R.raw.ph);
                            if(country_code.equals("PK"))
                                country.setImageResource(R.raw.pk);
                            if(country_code.equals("PL"))
                                country.setImageResource(R.raw.pl);
                            if(country_code.equals("PR"))
                                country.setImageResource(R.raw.pr);
                            if(country_code.equals("PT"))
                                country.setImageResource(R.raw.pt);
                            if(country_code.equals("PW"))
                                country.setImageResource(R.raw.pw);
                            if(country_code.equals("PY"))
                                country.setImageResource(R.raw.py);
                            if(country_code.equals("QA"))
                                country.setImageResource(R.raw.qa);
                            if(country_code.equals("RE"))
                                country.setImageResource(R.raw.re);
                            if(country_code.equals("RO"))
                                country.setImageResource(R.raw.ro);
                            if(country_code.equals("RS"))
                                country.setImageResource(R.raw.rs);
                            if(country_code.equals("RU"))
                                country.setImageResource(R.raw.ru);
                            if(country_code.equals("RW"))
                                country.setImageResource(R.raw.rw);
                            if(country_code.equals("SA"))
                                country.setImageResource(R.raw.sa);
                            if(country_code.equals("SB"))
                                country.setImageResource(R.raw.sb);
                            if(country_code.equals("SC"))
                                country.setImageResource(R.raw.sc);
                            if(country_code.equals("SD"))
                                country.setImageResource(R.raw.sd);
                            if(country_code.equals("SE"))
                                country.setImageResource(R.raw.se);
                            if(country_code.equals("SG"))
                                country.setImageResource(R.raw.sg);
                            if(country_code.equals("SI"))
                                country.setImageResource(R.raw.si);
                            if(country_code.equals("SK"))
                                country.setImageResource(R.raw.sk);
                            if(country_code.equals("SL"))
                                country.setImageResource(R.raw.sl);
                            if(country_code.equals("SM"))
                                country.setImageResource(R.raw.sm);
                            if(country_code.equals("SN"))
                                country.setImageResource(R.raw.sn);
                            if(country_code.equals("SO"))
                                country.setImageResource(R.raw.so);
                            if(country_code.equals("SR"))
                                country.setImageResource(R.raw.sr);
                            if(country_code.equals("ST"))
                                country.setImageResource(R.raw.st);
                            if(country_code.equals("SV"))
                                country.setImageResource(R.raw.sv);
                            if(country_code.equals("SY"))
                                country.setImageResource(R.raw.sy);
                            if(country_code.equals("SZ"))
                                country.setImageResource(R.raw.sz);
                            if(country_code.equals("TD"))
                                country.setImageResource(R.raw.td);
                            if(country_code.equals("TG"))
                                country.setImageResource(R.raw.tg);
                            if(country_code.equals("TH"))
                                country.setImageResource(R.raw.th);
                            if(country_code.equals("TJ"))
                                country.setImageResource(R.raw.tj);
                            if(country_code.equals("TL"))
                                country.setImageResource(R.raw.tl);
                            if(country_code.equals("TM"))
                                country.setImageResource(R.raw.tm);
                            if(country_code.equals("TN"))
                                country.setImageResource(R.raw.tn);
                            if(country_code.equals("TO"))
                                country.setImageResource(R.raw.to);
                            if(country_code.equals("TR"))
                                country.setImageResource(R.raw.tr);
                            if(country_code.equals("TT"))
                                country.setImageResource(R.raw.tt);
                            if(country_code.equals("TV"))
                                country.setImageResource(R.raw.tv);
                            if(country_code.equals("TW"))
                                country.setImageResource(R.raw.tw);
                            if(country_code.equals("TZ"))
                                country.setImageResource(R.raw.tz);
                            if(country_code.equals("UA"))
                                country.setImageResource(R.raw.ua);
                            if(country_code.equals("UG"))
                                country.setImageResource(R.raw.ug);
                            if(country_code.equals("US"))
                                country.setImageResource(R.raw.us);
                            if(country_code.equals("UY"))
                                country.setImageResource(R.raw.uy);
                            if(country_code.equals("UZ"))
                                country.setImageResource(R.raw.uz);
                            if(country_code.equals("VA"))
                                country.setImageResource(R.raw.va);
                            if(country_code.equals("VC"))
                                country.setImageResource(R.raw.vc);
                            if(country_code.equals("VE"))
                                country.setImageResource(R.raw.ve);
                            if(country_code.equals("VN"))
                                country.setImageResource(R.raw.vn);
                            if(country_code.equals("VU"))
                                country.setImageResource(R.raw.vu);
                            if(country_code.equals("WS"))
                                country.setImageResource(R.raw.ws);
                            if(country_code.equals("YE"))
                                country.setImageResource(R.raw.ye);
                            if(country_code.equals("ZA"))
                                country.setImageResource(R.raw.za);
                            if(country_code.equals("ZM"))
                                country.setImageResource(R.raw.zm);
                            if(country_code.equals("ZW"))
                                country.setImageResource(R.raw.zw);







                            primary_enrol.setText(object1.getString("primaryStudents"));
                            primary_school.setText(object1.getString("primarySchool"));
                            industry.setText(object1.getString("industry"));
                            services.setText(object1.getString("services"));
                            agri.setText(object1.getString("agriculture"));
                            health_per_capita.setText(object1.getString("wealthPerCapita"));
                            access_elect.setText(object1.getString("eletricityConsumption"));
                            happiness_index.setText(object1.getString("happinessScore"));
                            ppp.setText(object1.getString("ppp"));
                            sdg.setText(object1.getString("sdgiScore"));
                            gini.setText(object1.getString("gini"));
                            currency.setText(object1.getString("currencyName"));
                            goiter.setText(object1.getString("goitre"));
                            hdi.setText(object1.getString("hdi"));
                            corruption.setText(object1.getString("corruption"));
                            sex_ratio.setText(object1.getString("sexRatio"));
                            birth_rate.setText(object1.getString("birthRate"));
                            death_rate.setText(object1.getString("deathRate"));
                            unemployment_rate.setText(object1.getString("unEmploymentRate"));
                            population.setText(object1.getString("population"));
                            JSONObject object2=object.getJSONObject("region");
                            location.setText(object2.getString("regionName")+","+object1.getString("countryName"));
                            JSONObject object3=object.getJSONObject("language");
                            language.setText("language:"+object3.getString("languageName"));
                            capital.setText(object1.getString("capital"));
                            JSONObject object4=object.getJSONObject("religion");
                            religion.setText(object4.getString("religionName"));


                            JSONObject object_r = response.getJSONObject("SELF");
                            JSONObject object_r5=object_r.getJSONObject("traits");
                            reg_happiness_index.setText(object_r5.getString("happiness"));
                            JSONObject object_r1=object_r.getJSONObject("registerCoutry");
                            String reg_country_code=object_r1.getString("code");
                            Log.e("code",reg_country_code);
                            if(reg_country_code.equals("AD"))
                                reg_country.setImageResource(R.raw.ad);
                            if(reg_country_code.equals("AE"))
                                reg_country.setImageResource(R.raw.ae);
                            if(reg_country_code.equals("AF"))
                                reg_country.setImageResource(R.raw.af);
                            if(reg_country_code.equals("AG"))
                                reg_country.setImageResource(R.raw.ag);
                            if(reg_country_code.equals("AL"))
                                reg_country.setImageResource(R.raw.al);
                            if(reg_country_code.equals("AM"))
                                reg_country.setImageResource(R.raw.am);
                            if(reg_country_code.equals("AO"))
                                reg_country.setImageResource(R.raw.ao);
                            if(reg_country_code.equals("AR"))
                                reg_country.setImageResource(R.raw.ar);
                            if(reg_country_code.equals("AT"))
                                reg_country.setImageResource(R.raw.at);
                            if(reg_country_code.equals("AU"))
                                reg_country.setImageResource(R.raw.au);
                            if(reg_country_code.equals("AZ"))
                                reg_country.setImageResource(R.raw.az);
                            if(reg_country_code.equals("BA"))
                                reg_country.setImageResource(R.raw.ba);
                            if(reg_country_code.equals("BB"))
                                reg_country.setImageResource(R.raw.bb);
                            if(reg_country_code.equals("BD"))
                                reg_country.setImageResource(R.raw.bd);
                            if(reg_country_code.equals("BE"))
                                reg_country.setImageResource(R.raw.be);
                            if(reg_country_code.equals("BF"))
                                reg_country.setImageResource(R.raw.bf);
                            if(reg_country_code.equals("BG"))
                                reg_country.setImageResource(R.raw.bg);
                            if(reg_country_code.equals("BH"))
                                reg_country.setImageResource(R.raw.bh);
                            if(reg_country_code.equals("BI"))
                                reg_country.setImageResource(R.raw.bi);
                            if(reg_country_code.equals("BJ"))
                                reg_country.setImageResource(R.raw.bj);
                            if(reg_country_code.equals("BN"))
                                reg_country.setImageResource(R.raw.bn);
                            if(reg_country_code.equals("BO"))
                                reg_country.setImageResource(R.raw.bo);
                            if(reg_country_code.equals("BR"))
                                reg_country.setImageResource(R.raw.br);
                            if(reg_country_code.equals("BS"))
                                reg_country.setImageResource(R.raw.bs);
                            if(reg_country_code.equals("BT"))
                                reg_country.setImageResource(R.raw.bt);
                            if(reg_country_code.equals("BW"))
                                reg_country.setImageResource(R.raw.bw);
                            if(reg_country_code.equals("BY"))
                                reg_country.setImageResource(R.raw.by);
                            if(reg_country_code.equals("BZ"))
                                reg_country.setImageResource(R.raw.bz);
                            if(reg_country_code.equals("CA"))
                                reg_country.setImageResource(R.raw.ca);
                            if(reg_country_code.equals("CD"))
                                reg_country.setImageResource(R.raw.cd);
                            if(reg_country_code.equals("CF"))
                                reg_country.setImageResource(R.raw.cf);
                            if(reg_country_code.equals("CG"))
                                reg_country.setImageResource(R.raw.cg);
                            if(reg_country_code.equals("CH"))
                                reg_country.setImageResource(R.raw.ch);
                            if(reg_country_code.equals("CI"))
                                reg_country.setImageResource(R.raw.ci);
                            if(reg_country_code.equals("CL"))
                                reg_country.setImageResource(R.raw.cl);
                            if(reg_country_code.equals("CM"))
                                reg_country.setImageResource(R.raw.cm);
                            if(reg_country_code.equals("CN"))
                                reg_country.setImageResource(R.raw.cn);
                            if(reg_country_code.equals("CO"))
                                reg_country.setImageResource(R.raw.co);
                            if(reg_country_code.equals("CR"))
                                reg_country.setImageResource(R.raw.cr);
                            if(reg_country_code.equals("CU"))
                                reg_country.setImageResource(R.raw.cu);
                            if(reg_country_code.equals("CV"))
                                reg_country.setImageResource(R.raw.cv);
                            if(reg_country_code.equals("CY"))
                                reg_country.setImageResource(R.raw.cy);
                            if(reg_country_code.equals("CZ"))
                                reg_country.setImageResource(R.raw.cz);
                            if(reg_country_code.equals("DE"))
                                reg_country.setImageResource(R.raw.de);
                            if(reg_country_code.equals("DJ"))
                                reg_country.setImageResource(R.raw.dj);
                            if(reg_country_code.equals("DK"))
                                reg_country.setImageResource(R.raw.dk);
                            if(reg_country_code.equals("DM"))
                                reg_country.setImageResource(R.raw.dm);
                            if(reg_country_code.equals("DO"))
                                reg_country.setImageResource(R.raw.do1);
                            if(reg_country_code.equals("DZ"))
                                reg_country.setImageResource(R.raw.dz);
                            if(reg_country_code.equals("EC"))
                                reg_country.setImageResource(R.raw.ec);
                            if(reg_country_code.equals("EE"))
                                reg_country.setImageResource(R.raw.ee);
                            if(reg_country_code.equals("EG"))
                                reg_country.setImageResource(R.raw.eg);
                            if(reg_country_code.equals("EH"))
                                reg_country.setImageResource(R.raw.eh);
                            if(reg_country_code.equals("ER"))
                                reg_country.setImageResource(R.raw.er);
                            if(reg_country_code.equals("ES"))
                                reg_country.setImageResource(R.raw.es);
                            if(reg_country_code.equals("ET"))
                                reg_country.setImageResource(R.raw.et);
                            if(reg_country_code.equals("FI"))
                                reg_country.setImageResource(R.raw.fi);
                            if(reg_country_code.equals("FJ"))
                                reg_country.setImageResource(R.raw.fj);
                            if(reg_country_code.equals("FM"))
                                reg_country.setImageResource(R.raw.fm);
                            if(reg_country_code.equals("FR"))
                                reg_country.setImageResource(R.raw.fr);
                            if(reg_country_code.equals("GA"))
                                reg_country.setImageResource(R.raw.ga);
                            if(reg_country_code.equals("GB"))
                                reg_country.setImageResource(R.raw.gb);
                            if(reg_country_code.equals("GD"))
                                reg_country.setImageResource(R.raw.gd);
                            if(reg_country_code.equals("GE"))
                                reg_country.setImageResource(R.raw.ge);
                            if(reg_country_code.equals("GF"))
                                reg_country.setImageResource(R.raw.gf);
                            if(reg_country_code.equals("GH"))
                                reg_country.setImageResource(R.raw.gh);
                            if(reg_country_code.equals("GM"))
                                reg_country.setImageResource(R.raw.gm);
                            if(reg_country_code.equals("GN"))
                                reg_country.setImageResource(R.raw.gn);
                            if(reg_country_code.equals("GP"))
                                reg_country.setImageResource(R.raw.gp);
                            if(reg_country_code.equals("GQ"))
                                reg_country.setImageResource(R.raw.gq);
                            if(reg_country_code.equals("GR"))
                                reg_country.setImageResource(R.raw.gr);
                            if(reg_country_code.equals("GT"))
                                reg_country.setImageResource(R.raw.gt);
                            if(reg_country_code.equals("GU"))
                                reg_country.setImageResource(R.raw.gu);
                            if(reg_country_code.equals("GW"))
                                reg_country.setImageResource(R.raw.gw);
                            if(reg_country_code.equals("GY"))
                                reg_country.setImageResource(R.raw.gy);
                            if(reg_country_code.equals("HK"))
                                reg_country.setImageResource(R.raw.hk);
                            if(reg_country_code.equals("HN"))
                                reg_country.setImageResource(R.raw.hn);
                            if(reg_country_code.equals("HR"))
                                reg_country.setImageResource(R.raw.hr);
                            if(reg_country_code.equals("HT"))
                                reg_country.setImageResource(R.raw.ht);
                            if(reg_country_code.equals("HU"))
                                reg_country.setImageResource(R.raw.hu);
                            if(reg_country_code.equals("ID"))
                                reg_country.setImageResource(R.raw.id);
                            if(reg_country_code.equals("IE"))
                                reg_country.setImageResource(R.raw.ie);
                            if(reg_country_code.equals("IL"))
                                reg_country.setImageResource(R.raw.il);
                            if(reg_country_code.equals("IN"))
                                reg_country.setImageResource(R.raw.in);
                            if(reg_country_code.equals("IQ"))
                                reg_country.setImageResource(R.raw.iq);
                            if(reg_country_code.equals("IR"))
                                reg_country.setImageResource(R.raw.ir);
                            if(reg_country_code.equals("IS"))
                                reg_country.setImageResource(R.raw.is);
                            if(reg_country_code.equals("IT"))
                                reg_country.setImageResource(R.raw.it);
                            if(reg_country_code.equals("JM"))
                                reg_country.setImageResource(R.raw.jm);
                            if(reg_country_code.equals("JO"))
                                reg_country.setImageResource(R.raw.jo);
                            if(reg_country_code.equals("JP"))
                                reg_country.setImageResource(R.raw.jp);
                            if(reg_country_code.equals("KE"))
                                reg_country.setImageResource(R.raw.ke);
                            if(reg_country_code.equals("KG"))
                                reg_country.setImageResource(R.raw.kg);
                            if(reg_country_code.equals("KH"))
                                reg_country.setImageResource(R.raw.kh);
                            if(reg_country_code.equals("KI"))
                                reg_country.setImageResource(R.raw.ki);
                            if(reg_country_code.equals("KM"))
                                reg_country.setImageResource(R.raw.km);
                            if(reg_country_code.equals("KN"))
                                reg_country.setImageResource(R.raw.kn);
                            if(reg_country_code.equals("KP"))
                                reg_country.setImageResource(R.raw.kp);
                            if(reg_country_code.equals("KR"))
                                reg_country.setImageResource(R.raw.kr);
                            if(reg_country_code.equals("KS"))
                                reg_country.setImageResource(R.raw.ks);
                            if(reg_country_code.equals("KW"))
                                reg_country.setImageResource(R.raw.kw);
                            if(reg_country_code.equals("KZ"))
                                reg_country.setImageResource(R.raw.kz);
                            if(reg_country_code.equals("LA"))
                                reg_country.setImageResource(R.raw.la);
                            if(reg_country_code.equals("LB"))
                                reg_country.setImageResource(R.raw.lb);
                            if(reg_country_code.equals("LC"))
                                reg_country.setImageResource(R.raw.lc);
                            if(reg_country_code.equals("LI"))
                                reg_country.setImageResource(R.raw.li);
                            if(reg_country_code.equals("LK"))
                                reg_country.setImageResource(R.raw.lk);
                            if(reg_country_code.equals("LR"))
                                reg_country.setImageResource(R.raw.lr);
                            if(reg_country_code.equals("LS"))
                                reg_country.setImageResource(R.raw.ls);
                            if(reg_country_code.equals("LT"))
                                reg_country.setImageResource(R.raw.lt);
                            if(reg_country_code.equals("LU"))
                                reg_country.setImageResource(R.raw.lu);
                            if(reg_country_code.equals("LV"))
                                reg_country.setImageResource(R.raw.lv);
                            if(reg_country_code.equals("LY"))
                                reg_country.setImageResource(R.raw.ly);
                            if(reg_country_code.equals("MA"))
                                reg_country.setImageResource(R.raw.ma);
                            if(reg_country_code.equals("MC"))
                                reg_country.setImageResource(R.raw.mc);
                            if(reg_country_code.equals("MD"))
                                reg_country.setImageResource(R.raw.md);
                            if(reg_country_code.equals("ME"))
                                reg_country.setImageResource(R.raw.me);
                            if(reg_country_code.equals("MG"))
                                reg_country.setImageResource(R.raw.mg);
                            if(reg_country_code.equals("MH"))
                                reg_country.setImageResource(R.raw.mg);
                            if(reg_country_code.equals("MK"))
                                reg_country.setImageResource(R.raw.mk);
                            if(reg_country_code.equals("ML"))
                                reg_country.setImageResource(R.raw.ml);
                            if(reg_country_code.equals("MM"))
                                reg_country.setImageResource(R.raw.mm);
                            if(reg_country_code.equals("MN"))
                                reg_country.setImageResource(R.raw.mn);
                            if(reg_country_code.equals("MO"))
                                reg_country.setImageResource(R.raw.mo);
                            if(reg_country_code.equals("MQ"))
                                reg_country.setImageResource(R.raw.mq);
                            if(reg_country_code.equals("MR"))
                                reg_country.setImageResource(R.raw.mr);
                            if(reg_country_code.equals("MT"))
                                reg_country.setImageResource(R.raw.mt);
                            if(reg_country_code.equals("MU"))
                                reg_country.setImageResource(R.raw.mu);
                            if(reg_country_code.equals("MV"))
                                reg_country.setImageResource(R.raw.mv);
                            if(reg_country_code.equals("MW"))
                                reg_country.setImageResource(R.raw.mw);
                            if(reg_country_code.equals("MX"))
                                reg_country.setImageResource(R.raw.mx);
                            if(reg_country_code.equals("MY"))
                                reg_country.setImageResource(R.raw.my);
                            if(reg_country_code.equals("MZ"))
                                reg_country.setImageResource(R.raw.mz);
                            if(reg_country_code.equals("NA"))
                                reg_country.setImageResource(R.raw.na);
                            if(reg_country_code.equals("NC"))
                                reg_country.setImageResource(R.raw.nc);
                            if(reg_country_code.equals("NE"))
                                reg_country.setImageResource(R.raw.ne);
                            if(reg_country_code.equals("NG"))
                                reg_country.setImageResource(R.raw.ng);
                            if(reg_country_code.equals("NI"))
                                reg_country.setImageResource(R.raw.ni);
                            if(reg_country_code.equals("NL"))
                                reg_country.setImageResource(R.raw.nl);
                            if(reg_country_code.equals("NO"))
                                reg_country.setImageResource(R.raw.no);
                            if(reg_country_code.equals("NP"))
                                reg_country.setImageResource(R.raw.np);
                            if(reg_country_code.equals("NR"))
                                reg_country.setImageResource(R.raw.nr);
                            if(reg_country_code.equals("NZ"))
                                reg_country.setImageResource(R.raw.nz);
                            if(reg_country_code.equals("OM"))
                                reg_country.setImageResource(R.raw.om);
                            if(reg_country_code.equals("PA"))
                                reg_country.setImageResource(R.raw.pa);
                            if(reg_country_code.equals("PE"))
                                reg_country.setImageResource(R.raw.pe);
                            if(reg_country_code.equals("PF"))
                                reg_country.setImageResource(R.raw.pf);
                            if(reg_country_code.equals("PG"))
                                reg_country.setImageResource(R.raw.pg);
                            if(reg_country_code.equals("PH"))
                                reg_country.setImageResource(R.raw.ph);
                            if(reg_country_code.equals("PK"))
                                reg_country.setImageResource(R.raw.pk);
                            if(reg_country_code.equals("PL"))
                                reg_country.setImageResource(R.raw.pl);
                            if(reg_country_code.equals("PR"))
                                reg_country.setImageResource(R.raw.pr);
                            if(reg_country_code.equals("PT"))
                                reg_country.setImageResource(R.raw.pt);
                            if(reg_country_code.equals("PW"))
                                reg_country.setImageResource(R.raw.pw);
                            if(reg_country_code.equals("PY"))
                                reg_country.setImageResource(R.raw.py);
                            if(reg_country_code.equals("QA"))
                                reg_country.setImageResource(R.raw.qa);
                            if(reg_country_code.equals("RE"))
                                reg_country.setImageResource(R.raw.re);
                            if(reg_country_code.equals("RO"))
                                reg_country.setImageResource(R.raw.ro);
                            if(reg_country_code.equals("RS"))
                                reg_country.setImageResource(R.raw.rs);
                            if(reg_country_code.equals("RU"))
                                reg_country.setImageResource(R.raw.ru);
                            if(reg_country_code.equals("RW"))
                                reg_country.setImageResource(R.raw.rw);
                            if(reg_country_code.equals("SA"))
                                reg_country.setImageResource(R.raw.sa);
                            if(reg_country_code.equals("SB"))
                                reg_country.setImageResource(R.raw.sb);
                            if(reg_country_code.equals("SC"))
                                reg_country.setImageResource(R.raw.sc);
                            if(reg_country_code.equals("SD"))
                                reg_country.setImageResource(R.raw.sd);
                            if(reg_country_code.equals("SE"))
                                reg_country.setImageResource(R.raw.se);
                            if(reg_country_code.equals("SG"))
                                reg_country.setImageResource(R.raw.sg);
                            if(reg_country_code.equals("SI"))
                                reg_country.setImageResource(R.raw.si);
                            if(reg_country_code.equals("SK"))
                                reg_country.setImageResource(R.raw.sk);
                            if(reg_country_code.equals("SL"))
                                reg_country.setImageResource(R.raw.sl);
                            if(reg_country_code.equals("SM"))
                                reg_country.setImageResource(R.raw.sm);
                            if(reg_country_code.equals("SN"))
                                reg_country.setImageResource(R.raw.sn);
                            if(reg_country_code.equals("SO"))
                                reg_country.setImageResource(R.raw.so);
                            if(reg_country_code.equals("SR"))
                                reg_country.setImageResource(R.raw.sr);
                            if(reg_country_code.equals("ST"))
                                reg_country.setImageResource(R.raw.st);
                            if(reg_country_code.equals("SV"))
                                reg_country.setImageResource(R.raw.sv);
                            if(reg_country_code.equals("SY"))
                                reg_country.setImageResource(R.raw.sy);
                            if(reg_country_code.equals("SZ"))
                                reg_country.setImageResource(R.raw.sz);
                            if(reg_country_code.equals("TD"))
                                reg_country.setImageResource(R.raw.td);
                            if(reg_country_code.equals("TG"))
                                reg_country.setImageResource(R.raw.tg);
                            if(reg_country_code.equals("TH"))
                                reg_country.setImageResource(R.raw.th);
                            if(reg_country_code.equals("TJ"))
                                reg_country.setImageResource(R.raw.tj);
                            if(reg_country_code.equals("TL"))
                                reg_country.setImageResource(R.raw.tl);
                            if(reg_country_code.equals("TM"))
                                reg_country.setImageResource(R.raw.tm);
                            if(reg_country_code.equals("TN"))
                                reg_country.setImageResource(R.raw.tn);
                            if(reg_country_code.equals("TO"))
                                reg_country.setImageResource(R.raw.to);
                            if(reg_country_code.equals("TR"))
                                reg_country.setImageResource(R.raw.tr);
                            if(reg_country_code.equals("TT"))
                                reg_country.setImageResource(R.raw.tt);
                            if(reg_country_code.equals("TV"))
                                reg_country.setImageResource(R.raw.tv);
                            if(reg_country_code.equals("TW"))
                                reg_country.setImageResource(R.raw.tw);
                            if(reg_country_code.equals("TZ"))
                                reg_country.setImageResource(R.raw.tz);
                            if(reg_country_code.equals("UA"))
                                reg_country.setImageResource(R.raw.ua);
                            if(reg_country_code.equals("UG"))
                                reg_country.setImageResource(R.raw.ug);
                            if(reg_country_code.equals("US"))
                                reg_country.setImageResource(R.raw.us);
                            if(reg_country_code.equals("UY"))
                                reg_country.setImageResource(R.raw.uy);
                            if(reg_country_code.equals("UZ"))
                                reg_country.setImageResource(R.raw.uz);
                            if(reg_country_code.equals("VA"))
                                reg_country.setImageResource(R.raw.va);
                            if(reg_country_code.equals("VC"))
                                reg_country.setImageResource(R.raw.vc);
                            if(reg_country_code.equals("VE"))
                                reg_country.setImageResource(R.raw.ve);
                            if(reg_country_code.equals("VN"))
                                reg_country.setImageResource(R.raw.vn);
                            if(reg_country_code.equals("VU"))
                                reg_country.setImageResource(R.raw.vu);
                            if(reg_country_code.equals("WS"))
                                reg_country.setImageResource(R.raw.ws);
                            if(reg_country_code.equals("YE"))
                                reg_country.setImageResource(R.raw.ye);
                            if(reg_country_code.equals("ZA"))
                                reg_country.setImageResource(R.raw.za);
                            if(reg_country_code.equals("ZM"))
                                reg_country.setImageResource(R.raw.zm);
                            if(reg_country_code.equals("ZW"))
                                reg_country.setImageResource(R.raw.zw);




                            reg_primary_enrol.setText(object_r1.getString("primaryStudents"));
                            reg_primary_school.setText(object_r1.getString("primarySchool"));
                            reg_industry.setText(object_r1.getString("industry"));
                            reg_services.setText(object_r1.getString("services"));
                            reg_agri.setText(object_r1.getString("agriculture"));
                            reg_health_per_capita.setText(object_r1.getString("wealthPerCapita"));
                            reg_access_elect.setText(object_r1.getString("eletricityConsumption"));
                            reg_happiness_index.setText(object_r1.getString("happinessScore"));
                            reg_ppp.setText(object_r1.getString("ppp"));
                            reg_sdg.setText(object_r1.getString("sdgiScore"));
                            reg_gini.setText(object_r1.getString("gini"));
                            reg_currency.setText(object_r1.getString("currencyName"));
                            reg_goiter.setText(object_r1.getString("goitre"));
                            reg_hdi.setText(object_r1.getString("hdi"));
                            reg_corruption.setText(object_r1.getString("corruption"));
                            reg_sex_ratio.setText(object_r1.getString("sexRatio"));
                            reg_birth_rate.setText(object_r1.getString("birthRate"));
                            reg_death_rate.setText(object_r1.getString("deathRate"));
                            reg_unemployment_rate.setText(object_r1.getString("unEmploymentRate"));
                            reg_population.setText(object_r1.getString("population"));
                            reg_capital.setText(object_r1.getString("capital"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Log.e("DATA",response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                pref=getApplication().getSharedPreferences("Options",MODE_PRIVATE);
                String token=pref.getString("token","");
                Log.e("token in start",token);
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("x-auth-token",token);
                return headers;
            }

        };

        jsonObjReq.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return  100000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 100000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }

        });

        requestQueue.add(jsonObjReq);


    }


    public void tolivealife(View view)
    {
        Intent intent = new Intent(StartLife.this, LiveALife.class);
        intent.putExtra("responce_object", String.valueOf(responce_object));
        Log.e("Send object to livelife", String.valueOf(responce_object));
        startActivity(intent);
    }
}