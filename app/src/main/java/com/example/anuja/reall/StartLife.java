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

import org.json.JSONArray;
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
                            String gender1=object.getString("sex");
                            if(gender1.equals("F")){
                                gender.setText("Female");
                            }
                            else
                            {
                                gender.setText("Male");
                            }

                            JSONObject object5=object.getJSONObject("traits");
                            happiness_index.setText(object5.getString("happiness"));
                            JSONObject object1=object.getJSONObject("country");
                            String country_code=object1.getString("code").toUpperCase();
                            Log.e("code",country_code);

                            if(country_code.equals("AD"))
                                country.setImageResource(R.raw.ad);
                            else if(country_code.equals("AE"))
                                country.setImageResource(R.raw.ae);
                            else if(country_code.equals("AF"))
                                country.setImageResource(R.raw.af);
                            else if(country_code.equals("AG"))
                                country.setImageResource(R.raw.ag);
                            else if(country_code.equals("AL"))
                                country.setImageResource(R.raw.al);
                            else if(country_code.equals("AM"))
                                country.setImageResource(R.raw.am);
                            else if(country_code.equals("AO"))
                                country.setImageResource(R.raw.ao);
                            else if(country_code.equals("AR"))
                                country.setImageResource(R.raw.ar);
                            else if(country_code.equals("AT"))
                                country.setImageResource(R.raw.at);
                            else if(country_code.equals("AU"))
                                country.setImageResource(R.raw.au);
                            else if(country_code.equals("AZ"))
                                country.setImageResource(R.raw.az);
                            else if(country_code.equals("BA"))
                                country.setImageResource(R.raw.ba);
                            else if(country_code.equals("BB"))
                                country.setImageResource(R.raw.bb);
                            else if(country_code.equals("BD"))
                                country.setImageResource(R.raw.bd);
                            else if(country_code.equals("BE"))
                                country.setImageResource(R.raw.be);
                            else if(country_code.equals("BF"))
                                country.setImageResource(R.raw.bf);
                            else if(country_code.equals("BG"))
                                country.setImageResource(R.raw.bg);
                            else if(country_code.equals("BH"))
                                country.setImageResource(R.raw.bh);
                            else if(country_code.equals("BI"))
                                country.setImageResource(R.raw.bi);
                            else if(country_code.equals("BJ"))
                                country.setImageResource(R.raw.bj);
                            else if(country_code.equals("BN"))
                                country.setImageResource(R.raw.bn);
                            else if(country_code.equals("BO"))
                                country.setImageResource(R.raw.bo);
                            else if(country_code.equals("BR"))
                                country.setImageResource(R.raw.br);
                            else if(country_code.equals("BS"))
                                country.setImageResource(R.raw.bs);
                            else if(country_code.equals("BT"))
                                country.setImageResource(R.raw.bt);
                            else if(country_code.equals("BW"))
                                country.setImageResource(R.raw.bw);
                            else if(country_code.equals("BY"))
                                country.setImageResource(R.raw.by);
                            else if(country_code.equals("BZ"))
                                country.setImageResource(R.raw.bz);
                            else if(country_code.equals("CA"))
                                country.setImageResource(R.raw.ca);
                            else if(country_code.equals("CD"))
                                country.setImageResource(R.raw.cd);
                            else if(country_code.equals("CF"))
                                country.setImageResource(R.raw.cf);
                            else if(country_code.equals("CG"))
                                country.setImageResource(R.raw.cg);
                            else if(country_code.equals("CH"))
                                country.setImageResource(R.raw.ch);
                            else if(country_code.equals("CI"))
                                country.setImageResource(R.raw.ci);
                            else if(country_code.equals("CL"))
                                country.setImageResource(R.raw.cl);
                            else if(country_code.equals("CM"))
                                country.setImageResource(R.raw.cm);
                            else if(country_code.equals("CN"))
                                country.setImageResource(R.raw.cn);
                            else if(country_code.equals("CO"))
                                country.setImageResource(R.raw.co);
                            else if(country_code.equals("CR"))
                                country.setImageResource(R.raw.cr);
                            else if(country_code.equals("CU"))
                                country.setImageResource(R.raw.cu);
                            else if(country_code.equals("CV"))
                                country.setImageResource(R.raw.cv);
                            else if(country_code.equals("CY"))
                                country.setImageResource(R.raw.cy);
                            else if(country_code.equals("CZ"))
                                country.setImageResource(R.raw.cz);
                            else if(country_code.equals("DE"))
                                country.setImageResource(R.raw.de);
                            else if(country_code.equals("DJ"))
                                country.setImageResource(R.raw.dj);
                            else if(country_code.equals("DK"))
                                country.setImageResource(R.raw.dk);
                            else if(country_code.equals("DM"))
                                country.setImageResource(R.raw.dm);
                            else if(country_code.equals("DO"))
                                country.setImageResource(R.raw.do1);
                            else if(country_code.equals("DZ"))
                                country.setImageResource(R.raw.dz);
                            else if(country_code.equals("EC"))
                                country.setImageResource(R.raw.ec);
                            else if(country_code.equals("EE"))
                                country.setImageResource(R.raw.ee);
                            else if(country_code.equals("EG"))
                                country.setImageResource(R.raw.eg);
                            else if(country_code.equals("EH"))
                                country.setImageResource(R.raw.eh);
                            else if(country_code.equals("ER"))
                                country.setImageResource(R.raw.er);
                            else if(country_code.equals("ES"))
                                country.setImageResource(R.raw.es);
                            else if(country_code.equals("ET"))
                                country.setImageResource(R.raw.et);
                            else if(country_code.equals("FI"))
                                country.setImageResource(R.raw.fi);
                            else if(country_code.equals("FJ"))
                                country.setImageResource(R.raw.fj);
                            else if(country_code.equals("FM"))
                                country.setImageResource(R.raw.fm);
                            else if(country_code.equals("FR"))
                                country.setImageResource(R.raw.fr);
                            else if(country_code.equals("GA"))
                                country.setImageResource(R.raw.ga);
                            else if(country_code.equals("GB"))
                                country.setImageResource(R.raw.gb);
                            else if(country_code.equals("GD"))
                                country.setImageResource(R.raw.gd);
                            else if(country_code.equals("GE"))
                                country.setImageResource(R.raw.ge);
                            else if(country_code.equals("GF"))
                                country.setImageResource(R.raw.gf);
                            else if(country_code.equals("GH"))
                                country.setImageResource(R.raw.gh);
                            else if(country_code.equals("GM"))
                                country.setImageResource(R.raw.gm);
                            else if(country_code.equals("GN"))
                                country.setImageResource(R.raw.gn);
                            else if(country_code.equals("GP"))
                                country.setImageResource(R.raw.gp);
                            else if(country_code.equals("GQ"))
                                country.setImageResource(R.raw.gq);
                            else if(country_code.equals("GR"))
                                country.setImageResource(R.raw.gr);
                            else if(country_code.equals("GT"))
                                country.setImageResource(R.raw.gt);
                            else if(country_code.equals("GU"))
                                country.setImageResource(R.raw.gu);
                            else if(country_code.equals("GW"))
                                country.setImageResource(R.raw.gw);
                            else if(country_code.equals("GY"))
                                country.setImageResource(R.raw.gy);
                            else if(country_code.equals("HK"))
                                country.setImageResource(R.raw.hk);
                            else if(country_code.equals("HN"))
                                country.setImageResource(R.raw.hn);
                            else if(country_code.equals("HR"))
                                country.setImageResource(R.raw.hr);
                            else if(country_code.equals("HT"))
                                country.setImageResource(R.raw.ht);
                            else if(country_code.equals("HU"))
                                country.setImageResource(R.raw.hu);
                            else if(country_code.equals("ID"))
                                country.setImageResource(R.raw.id);
                            else if(country_code.equals("IE"))
                                country.setImageResource(R.raw.ie);
                            else if(country_code.equals("IL"))
                                country.setImageResource(R.raw.il);
                            else if(country_code.equals("IN"))
                                country.setImageResource(R.raw.in);
                            else if(country_code.equals("IQ"))
                                country.setImageResource(R.raw.iq);
                            else if(country_code.equals("IR"))
                                country.setImageResource(R.raw.ir);
                            else if(country_code.equals("IS"))
                                country.setImageResource(R.raw.is);
                            else if(country_code.equals("IT"))
                                country.setImageResource(R.raw.it);
                            else if(country_code.equals("JM"))
                                country.setImageResource(R.raw.jm);
                            else if(country_code.equals("JO"))
                                country.setImageResource(R.raw.jo);
                            else if(country_code.equals("JP"))
                                country.setImageResource(R.raw.jp);
                            else if(country_code.equals("KE"))
                                country.setImageResource(R.raw.ke);
                            else if(country_code.equals("KG"))
                                country.setImageResource(R.raw.kg);
                            else if(country_code.equals("KH"))
                                country.setImageResource(R.raw.kh);
                            else if(country_code.equals("KI"))
                                country.setImageResource(R.raw.ki);
                            else if(country_code.equals("KM"))
                                country.setImageResource(R.raw.km);
                            else if(country_code.equals("KN"))
                                country.setImageResource(R.raw.kn);
                            else if(country_code.equals("KP"))
                                country.setImageResource(R.raw.kp);
                            else if(country_code.equals("KR"))
                                country.setImageResource(R.raw.kr);
                            else if(country_code.equals("KS"))
                                country.setImageResource(R.raw.ks);
                            else if(country_code.equals("KW"))
                                country.setImageResource(R.raw.kw);
                            else if(country_code.equals("KZ"))
                                country.setImageResource(R.raw.kz);
                            else if(country_code.equals("LA"))
                                country.setImageResource(R.raw.la);
                            else if(country_code.equals("LB"))
                                country.setImageResource(R.raw.lb);
                            else if(country_code.equals("LC"))
                                country.setImageResource(R.raw.lc);
                            else if(country_code.equals("LI"))
                                country.setImageResource(R.raw.li);
                            else if(country_code.equals("LK"))
                                country.setImageResource(R.raw.lk);
                            else if(country_code.equals("LR"))
                                country.setImageResource(R.raw.lr);
                            else if(country_code.equals("LS"))
                                country.setImageResource(R.raw.ls);
                            else if(country_code.equals("LT"))
                                country.setImageResource(R.raw.lt);
                            else if(country_code.equals("LU"))
                                country.setImageResource(R.raw.lu);
                            else if(country_code.equals("LV"))
                                country.setImageResource(R.raw.lv);
                            else if(country_code.equals("LY"))
                                country.setImageResource(R.raw.ly);
                            else if(country_code.equals("MA"))
                                country.setImageResource(R.raw.ma);
                            else if(country_code.equals("MC"))
                                country.setImageResource(R.raw.mc);
                            else if(country_code.equals("MD"))
                                country.setImageResource(R.raw.md);
                            else if(country_code.equals("ME"))
                                country.setImageResource(R.raw.me);
                            else if(country_code.equals("MG"))
                                country.setImageResource(R.raw.mg);
                            else if(country_code.equals("MH"))
                                country.setImageResource(R.raw.mg);
                            else if(country_code.equals("MK"))
                                country.setImageResource(R.raw.mk);
                            else if(country_code.equals("ML"))
                                country.setImageResource(R.raw.ml);
                            else if(country_code.equals("MM"))
                                country.setImageResource(R.raw.mm);
                            else if(country_code.equals("MN"))
                                country.setImageResource(R.raw.mn);
                            else if(country_code.equals("MO"))
                                country.setImageResource(R.raw.mo);
                            else if(country_code.equals("MQ"))
                                country.setImageResource(R.raw.mq);
                            else if(country_code.equals("MR"))
                                country.setImageResource(R.raw.mr);
                            else if(country_code.equals("MT"))
                                country.setImageResource(R.raw.mt);
                            else if(country_code.equals("MU"))
                                country.setImageResource(R.raw.mu);
                            else if(country_code.equals("MV"))
                                country.setImageResource(R.raw.mv);
                            else if(country_code.equals("MW"))
                                country.setImageResource(R.raw.mw);
                            else if(country_code.equals("MX"))
                                country.setImageResource(R.raw.mx);
                            else if(country_code.equals("MY"))
                                country.setImageResource(R.raw.my);
                            else if(country_code.equals("MZ"))
                                country.setImageResource(R.raw.mz);
                            else if(country_code.equals("NA"))
                                country.setImageResource(R.raw.na);
                            else if(country_code.equals("NC"))
                                country.setImageResource(R.raw.nc);
                            else if(country_code.equals("NE"))
                                country.setImageResource(R.raw.ne);
                            else if(country_code.equals("NG"))
                                country.setImageResource(R.raw.ng);
                            else if(country_code.equals("NI"))
                                country.setImageResource(R.raw.ni);
                            else if(country_code.equals("NL"))
                                country.setImageResource(R.raw.nl);
                            else if(country_code.equals("NO"))
                                country.setImageResource(R.raw.no);
                            else if(country_code.equals("NP"))
                                country.setImageResource(R.raw.np);
                            else if(country_code.equals("NR"))
                                country.setImageResource(R.raw.nr);
                            else if(country_code.equals("NZ"))
                                country.setImageResource(R.raw.nz);
                            else if(country_code.equals("OM"))
                                country.setImageResource(R.raw.om);
                            else if(country_code.equals("PA"))
                                country.setImageResource(R.raw.pa);
                            else if(country_code.equals("PE"))
                                country.setImageResource(R.raw.pe);
                            else if(country_code.equals("PF"))
                                country.setImageResource(R.raw.pf);
                            else if(country_code.equals("PG"))
                                country.setImageResource(R.raw.pg);
                            else if(country_code.equals("PH"))
                                country.setImageResource(R.raw.ph);
                            else if(country_code.equals("PK"))
                                country.setImageResource(R.raw.pk);
                            else if(country_code.equals("PL"))
                                country.setImageResource(R.raw.pl);
                            else if(country_code.equals("PR"))
                                country.setImageResource(R.raw.pr);
                            else if(country_code.equals("PT"))
                                country.setImageResource(R.raw.pt);
                            else if(country_code.equals("PW"))
                                country.setImageResource(R.raw.pw);
                            else if(country_code.equals("PY"))
                                country.setImageResource(R.raw.py);
                            else if(country_code.equals("QA"))
                                country.setImageResource(R.raw.qa);
                            else if(country_code.equals("RE"))
                                country.setImageResource(R.raw.re);
                            else if(country_code.equals("RO"))
                                country.setImageResource(R.raw.ro);
                            else if(country_code.equals("RS"))
                                country.setImageResource(R.raw.rs);
                            else if(country_code.equals("RU"))
                                country.setImageResource(R.raw.ru);
                            else if(country_code.equals("RW"))
                                country.setImageResource(R.raw.rw);
                            else if(country_code.equals("SA"))
                                country.setImageResource(R.raw.sa);
                            else if(country_code.equals("SB"))
                                country.setImageResource(R.raw.sb);
                            else if(country_code.equals("SC"))
                                country.setImageResource(R.raw.sc);
                            else if(country_code.equals("SD"))
                                country.setImageResource(R.raw.sd);
                            else if(country_code.equals("SE"))
                                country.setImageResource(R.raw.se);
                            else if(country_code.equals("SG"))
                                country.setImageResource(R.raw.sg);
                            else if(country_code.equals("SI"))
                                country.setImageResource(R.raw.si);
                            else if(country_code.equals("SK"))
                                country.setImageResource(R.raw.sk);
                            else if(country_code.equals("SL"))
                                country.setImageResource(R.raw.sl);
                            else if(country_code.equals("SM"))
                                country.setImageResource(R.raw.sm);
                            else if(country_code.equals("SN"))
                                country.setImageResource(R.raw.sn);
                            else if(country_code.equals("SO"))
                                country.setImageResource(R.raw.so);
                            else if(country_code.equals("SR"))
                                country.setImageResource(R.raw.sr);
                            else if(country_code.equals("ST"))
                                country.setImageResource(R.raw.st);
                            else if(country_code.equals("SV"))
                                country.setImageResource(R.raw.sv);
                            else if(country_code.equals("SY"))
                                country.setImageResource(R.raw.sy);
                            else if(country_code.equals("SZ"))
                                country.setImageResource(R.raw.sz);
                            else if(country_code.equals("TD"))
                                country.setImageResource(R.raw.td);
                            else if(country_code.equals("TG"))
                                country.setImageResource(R.raw.tg);
                            else if(country_code.equals("TH"))
                                country.setImageResource(R.raw.th);
                            else if(country_code.equals("TJ"))
                                country.setImageResource(R.raw.tj);
                            else if(country_code.equals("TL"))
                                country.setImageResource(R.raw.tl);
                            else if(country_code.equals("TM"))
                                country.setImageResource(R.raw.tm);
                            else if(country_code.equals("TN"))
                                country.setImageResource(R.raw.tn);
                            else if(country_code.equals("TO"))
                                country.setImageResource(R.raw.to);
                            else if(country_code.equals("TR"))
                                country.setImageResource(R.raw.tr);
                            else if(country_code.equals("TT"))
                                country.setImageResource(R.raw.tt);
                            else if(country_code.equals("TV"))
                                country.setImageResource(R.raw.tv);
                            else if(country_code.equals("TW"))
                                country.setImageResource(R.raw.tw);
                            else if(country_code.equals("TZ"))
                                country.setImageResource(R.raw.tz);
                            else if(country_code.equals("UA"))
                                country.setImageResource(R.raw.ua);
                            else if(country_code.equals("UG"))
                                country.setImageResource(R.raw.ug);
                            else if(country_code.equals("US"))
                                country.setImageResource(R.raw.us);
                            else if(country_code.equals("UY"))
                                country.setImageResource(R.raw.uy);
                            else if(country_code.equals("UZ"))
                                country.setImageResource(R.raw.uz);
                            else if(country_code.equals("VA"))
                                country.setImageResource(R.raw.va);
                            else if(country_code.equals("VC"))
                                country.setImageResource(R.raw.vc);
                            else if(country_code.equals("VE"))
                                country.setImageResource(R.raw.ve);
                            else if(country_code.equals("VN"))
                                country.setImageResource(R.raw.vn);
                            else if(country_code.equals("VU"))
                                country.setImageResource(R.raw.vu);
                            else if(country_code.equals("WS"))
                                country.setImageResource(R.raw.ws);
                            else if(country_code.equals("YE"))
                                country.setImageResource(R.raw.ye);
                            else if(country_code.equals("ZA"))
                                country.setImageResource(R.raw.za);
                            else if(country_code.equals("ZM"))
                                country.setImageResource(R.raw.zm);
                            else if(country_code.equals("ZW"))
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
                            String reg_country_code=object_r1.getString("code").toUpperCase();
                            Log.e("code",reg_country_code);
                            if(reg_country_code.equals("AD"))
                                reg_country.setImageResource(R.raw.ad);
                            else if(reg_country_code.equals("AE"))
                                reg_country.setImageResource(R.raw.ae);
                            else if(reg_country_code.equals("AF"))
                                reg_country.setImageResource(R.raw.af);
                            else if(reg_country_code.equals("AG"))
                                reg_country.setImageResource(R.raw.ag);
                            else if(reg_country_code.equals("AL"))
                                reg_country.setImageResource(R.raw.al);
                            else if(reg_country_code.equals("AM"))
                                reg_country.setImageResource(R.raw.am);
                            else if(reg_country_code.equals("AO"))
                                reg_country.setImageResource(R.raw.ao);
                            else if(reg_country_code.equals("AR"))
                                reg_country.setImageResource(R.raw.ar);
                            else if(reg_country_code.equals("AT"))
                                reg_country.setImageResource(R.raw.at);
                            else if(reg_country_code.equals("AU"))
                                reg_country.setImageResource(R.raw.au);
                            else if(reg_country_code.equals("AZ"))
                                reg_country.setImageResource(R.raw.az);
                            else if(reg_country_code.equals("BA"))
                                reg_country.setImageResource(R.raw.ba);
                            else if(reg_country_code.equals("BB"))
                                reg_country.setImageResource(R.raw.bb);
                            else if(reg_country_code.equals("BD"))
                                reg_country.setImageResource(R.raw.bd);
                            else if(reg_country_code.equals("BE"))
                                reg_country.setImageResource(R.raw.be);
                            else if(reg_country_code.equals("BF"))
                                reg_country.setImageResource(R.raw.bf);
                            else if(reg_country_code.equals("BG"))
                                reg_country.setImageResource(R.raw.bg);
                            else if(reg_country_code.equals("BH"))
                                reg_country.setImageResource(R.raw.bh);
                            else if(reg_country_code.equals("BI"))
                                reg_country.setImageResource(R.raw.bi);
                            else if(reg_country_code.equals("BJ"))
                                reg_country.setImageResource(R.raw.bj);
                            else if(reg_country_code.equals("BN"))
                                reg_country.setImageResource(R.raw.bn);
                            else if(reg_country_code.equals("BO"))
                                reg_country.setImageResource(R.raw.bo);
                            else if(reg_country_code.equals("BR"))
                                reg_country.setImageResource(R.raw.br);
                            else if(reg_country_code.equals("BS"))
                                reg_country.setImageResource(R.raw.bs);
                            else if(reg_country_code.equals("BT"))
                                reg_country.setImageResource(R.raw.bt);
                            else if(reg_country_code.equals("BW"))
                                reg_country.setImageResource(R.raw.bw);
                            else if(reg_country_code.equals("BY"))
                                reg_country.setImageResource(R.raw.by);
                            else if(reg_country_code.equals("BZ"))
                                reg_country.setImageResource(R.raw.bz);
                            else if(reg_country_code.equals("CA"))
                                reg_country.setImageResource(R.raw.ca);
                            else if(reg_country_code.equals("CD"))
                                reg_country.setImageResource(R.raw.cd);
                            else if(reg_country_code.equals("CF"))
                                reg_country.setImageResource(R.raw.cf);
                            else if(reg_country_code.equals("CG"))
                                reg_country.setImageResource(R.raw.cg);
                            else if(reg_country_code.equals("CH"))
                                reg_country.setImageResource(R.raw.ch);
                            else if(reg_country_code.equals("CI"))
                                reg_country.setImageResource(R.raw.ci);
                            else if(reg_country_code.equals("CL"))
                                reg_country.setImageResource(R.raw.cl);
                            else if(reg_country_code.equals("CM"))
                                reg_country.setImageResource(R.raw.cm);
                            else if(reg_country_code.equals("CN"))
                                reg_country.setImageResource(R.raw.cn);
                            else if(reg_country_code.equals("CO"))
                                reg_country.setImageResource(R.raw.co);
                            else if(reg_country_code.equals("CR"))
                                reg_country.setImageResource(R.raw.cr);
                            else if(reg_country_code.equals("CU"))
                                reg_country.setImageResource(R.raw.cu);
                            else if(reg_country_code.equals("CV"))
                                reg_country.setImageResource(R.raw.cv);
                            else if(reg_country_code.equals("CY"))
                                reg_country.setImageResource(R.raw.cy);
                            else if(reg_country_code.equals("CZ"))
                                reg_country.setImageResource(R.raw.cz);
                            else if(reg_country_code.equals("DE"))
                                reg_country.setImageResource(R.raw.de);
                            else if(reg_country_code.equals("DJ"))
                                reg_country.setImageResource(R.raw.dj);
                            else if(reg_country_code.equals("DK"))
                                reg_country.setImageResource(R.raw.dk);
                            else if(reg_country_code.equals("DM"))
                                reg_country.setImageResource(R.raw.dm);
                            else if(reg_country_code.equals("DO"))
                                reg_country.setImageResource(R.raw.do1);
                            else if(reg_country_code.equals("DZ"))
                                reg_country.setImageResource(R.raw.dz);
                            else if(reg_country_code.equals("EC"))
                                reg_country.setImageResource(R.raw.ec);
                            else if(reg_country_code.equals("EE"))
                                reg_country.setImageResource(R.raw.ee);
                            else if(reg_country_code.equals("EG"))
                                reg_country.setImageResource(R.raw.eg);
                            else if(reg_country_code.equals("EH"))
                                reg_country.setImageResource(R.raw.eh);
                            else if(reg_country_code.equals("ER"))
                                reg_country.setImageResource(R.raw.er);
                            else if(reg_country_code.equals("ES"))
                                reg_country.setImageResource(R.raw.es);
                            else if(reg_country_code.equals("ET"))
                                reg_country.setImageResource(R.raw.et);
                            else if(reg_country_code.equals("FI"))
                                reg_country.setImageResource(R.raw.fi);
                            else if(reg_country_code.equals("FJ"))
                                reg_country.setImageResource(R.raw.fj);
                            else if(reg_country_code.equals("FM"))
                                reg_country.setImageResource(R.raw.fm);
                            else if(reg_country_code.equals("FR"))
                                reg_country.setImageResource(R.raw.fr);
                            else if(reg_country_code.equals("GA"))
                                reg_country.setImageResource(R.raw.ga);
                            else if(reg_country_code.equals("GB"))
                                reg_country.setImageResource(R.raw.gb);
                            else if(reg_country_code.equals("GD"))
                                reg_country.setImageResource(R.raw.gd);
                            else if(reg_country_code.equals("GE"))
                                reg_country.setImageResource(R.raw.ge);
                            else if(reg_country_code.equals("GF"))
                                reg_country.setImageResource(R.raw.gf);
                            else if(reg_country_code.equals("GH"))
                                reg_country.setImageResource(R.raw.gh);
                            else if(reg_country_code.equals("GM"))
                                reg_country.setImageResource(R.raw.gm);
                            else if(reg_country_code.equals("GN"))
                                reg_country.setImageResource(R.raw.gn);
                            else if(reg_country_code.equals("GP"))
                                reg_country.setImageResource(R.raw.gp);
                            else if(reg_country_code.equals("GQ"))
                                reg_country.setImageResource(R.raw.gq);
                            else if(reg_country_code.equals("GR"))
                                reg_country.setImageResource(R.raw.gr);
                            else if(reg_country_code.equals("GT"))
                                reg_country.setImageResource(R.raw.gt);
                            else if(reg_country_code.equals("GU"))
                                reg_country.setImageResource(R.raw.gu);
                            else if(reg_country_code.equals("GW"))
                                reg_country.setImageResource(R.raw.gw);
                            else if(reg_country_code.equals("GY"))
                                reg_country.setImageResource(R.raw.gy);
                            else if(reg_country_code.equals("HK"))
                                reg_country.setImageResource(R.raw.hk);
                            else if(reg_country_code.equals("HN"))
                                reg_country.setImageResource(R.raw.hn);
                            else if(reg_country_code.equals("HR"))
                                reg_country.setImageResource(R.raw.hr);
                            else if(reg_country_code.equals("HT"))
                                reg_country.setImageResource(R.raw.ht);
                            else if(reg_country_code.equals("HU"))
                                reg_country.setImageResource(R.raw.hu);
                            else if(reg_country_code.equals("ID"))
                                reg_country.setImageResource(R.raw.id);
                            else if(reg_country_code.equals("IE"))
                                reg_country.setImageResource(R.raw.ie);
                            else if(reg_country_code.equals("IL"))
                                reg_country.setImageResource(R.raw.il);
                            else if(reg_country_code.equals("IN"))
                                reg_country.setImageResource(R.raw.in);
                            else if(reg_country_code.equals("IQ"))
                                reg_country.setImageResource(R.raw.iq);
                            else if(reg_country_code.equals("IR"))
                                reg_country.setImageResource(R.raw.ir);
                            else if(reg_country_code.equals("IS"))
                                reg_country.setImageResource(R.raw.is);
                            else if(reg_country_code.equals("IT"))
                                reg_country.setImageResource(R.raw.it);
                            else if(reg_country_code.equals("JM"))
                                reg_country.setImageResource(R.raw.jm);
                            else if(reg_country_code.equals("JO"))
                                reg_country.setImageResource(R.raw.jo);
                            else if(reg_country_code.equals("JP"))
                                reg_country.setImageResource(R.raw.jp);
                            else if(reg_country_code.equals("KE"))
                                reg_country.setImageResource(R.raw.ke);
                            else if(reg_country_code.equals("KG"))
                                reg_country.setImageResource(R.raw.kg);
                            else if(reg_country_code.equals("KH"))
                                reg_country.setImageResource(R.raw.kh);
                            else if(reg_country_code.equals("KI"))
                                reg_country.setImageResource(R.raw.ki);
                            else if(reg_country_code.equals("KM"))
                                reg_country.setImageResource(R.raw.km);
                            else if(reg_country_code.equals("KN"))
                                reg_country.setImageResource(R.raw.kn);
                            else if(reg_country_code.equals("KP"))
                                reg_country.setImageResource(R.raw.kp);
                            else if(reg_country_code.equals("KR"))
                                reg_country.setImageResource(R.raw.kr);
                            else if(reg_country_code.equals("KS"))
                                reg_country.setImageResource(R.raw.ks);
                            else if(reg_country_code.equals("KW"))
                                reg_country.setImageResource(R.raw.kw);
                            else if(reg_country_code.equals("KZ"))
                                reg_country.setImageResource(R.raw.kz);
                            else if(reg_country_code.equals("LA"))
                                reg_country.setImageResource(R.raw.la);
                            else if(reg_country_code.equals("LB"))
                                reg_country.setImageResource(R.raw.lb);
                            else if(reg_country_code.equals("LC"))
                                reg_country.setImageResource(R.raw.lc);
                            else if(reg_country_code.equals("LI"))
                                reg_country.setImageResource(R.raw.li);
                            else if(reg_country_code.equals("LK"))
                                reg_country.setImageResource(R.raw.lk);
                            else if(reg_country_code.equals("LR"))
                                reg_country.setImageResource(R.raw.lr);
                            else if(reg_country_code.equals("LS"))
                                reg_country.setImageResource(R.raw.ls);
                            else if(reg_country_code.equals("LT"))
                                reg_country.setImageResource(R.raw.lt);
                            else if(reg_country_code.equals("LU"))
                                reg_country.setImageResource(R.raw.lu);
                            else if(reg_country_code.equals("LV"))
                                reg_country.setImageResource(R.raw.lv);
                            else if(reg_country_code.equals("LY"))
                                reg_country.setImageResource(R.raw.ly);
                            else if(reg_country_code.equals("MA"))
                                reg_country.setImageResource(R.raw.ma);
                            else if(reg_country_code.equals("MC"))
                                reg_country.setImageResource(R.raw.mc);
                            else if(reg_country_code.equals("MD"))
                                reg_country.setImageResource(R.raw.md);
                            else if(reg_country_code.equals("ME"))
                                reg_country.setImageResource(R.raw.me);
                            else if(reg_country_code.equals("MG"))
                                reg_country.setImageResource(R.raw.mg);
                            else if(reg_country_code.equals("MH"))
                                reg_country.setImageResource(R.raw.mg);
                            else if(reg_country_code.equals("MK"))
                                reg_country.setImageResource(R.raw.mk);
                            else if(reg_country_code.equals("ML"))
                                reg_country.setImageResource(R.raw.ml);
                            else if(reg_country_code.equals("MM"))
                                reg_country.setImageResource(R.raw.mm);
                            else if(reg_country_code.equals("MN"))
                                reg_country.setImageResource(R.raw.mn);
                            else if(reg_country_code.equals("MO"))
                                reg_country.setImageResource(R.raw.mo);
                            else if(reg_country_code.equals("MQ"))
                                reg_country.setImageResource(R.raw.mq);
                            else if(reg_country_code.equals("MR"))
                                reg_country.setImageResource(R.raw.mr);
                            else if(reg_country_code.equals("MT"))
                                reg_country.setImageResource(R.raw.mt);
                            else if(reg_country_code.equals("MU"))
                                reg_country.setImageResource(R.raw.mu);
                            else if(reg_country_code.equals("MV"))
                                reg_country.setImageResource(R.raw.mv);
                            else if(reg_country_code.equals("MW"))
                                reg_country.setImageResource(R.raw.mw);
                            else if(reg_country_code.equals("MX"))
                                reg_country.setImageResource(R.raw.mx);
                            else if(reg_country_code.equals("MY"))
                                reg_country.setImageResource(R.raw.my);
                            else if(reg_country_code.equals("MZ"))
                                reg_country.setImageResource(R.raw.mz);
                            else if(reg_country_code.equals("NA"))
                                reg_country.setImageResource(R.raw.na);
                            else if(reg_country_code.equals("NC"))
                                reg_country.setImageResource(R.raw.nc);
                            else if(reg_country_code.equals("NE"))
                                reg_country.setImageResource(R.raw.ne);
                            else if(reg_country_code.equals("NG"))
                                reg_country.setImageResource(R.raw.ng);
                            else if(reg_country_code.equals("NI"))
                                reg_country.setImageResource(R.raw.ni);
                            else if(reg_country_code.equals("NL"))
                                reg_country.setImageResource(R.raw.nl);
                            else if(reg_country_code.equals("NO"))
                                reg_country.setImageResource(R.raw.no);
                            else if(reg_country_code.equals("NP"))
                                reg_country.setImageResource(R.raw.np);
                            else if(reg_country_code.equals("NR"))
                                reg_country.setImageResource(R.raw.nr);
                            else if(reg_country_code.equals("NZ"))
                                reg_country.setImageResource(R.raw.nz);
                            else if(reg_country_code.equals("OM"))
                                reg_country.setImageResource(R.raw.om);
                            else if(reg_country_code.equals("PA"))
                                reg_country.setImageResource(R.raw.pa);
                            else if(reg_country_code.equals("PE"))
                                reg_country.setImageResource(R.raw.pe);
                            else if(reg_country_code.equals("PF"))
                                reg_country.setImageResource(R.raw.pf);
                            else if(reg_country_code.equals("PG"))
                                reg_country.setImageResource(R.raw.pg);
                            else if(reg_country_code.equals("PH"))
                                reg_country.setImageResource(R.raw.ph);
                            else if(reg_country_code.equals("PK"))
                                reg_country.setImageResource(R.raw.pk);
                            else if(reg_country_code.equals("PL"))
                                reg_country.setImageResource(R.raw.pl);
                            else if(reg_country_code.equals("PR"))
                                reg_country.setImageResource(R.raw.pr);
                            else if(reg_country_code.equals("PT"))
                                reg_country.setImageResource(R.raw.pt);
                            else if(reg_country_code.equals("PW"))
                                reg_country.setImageResource(R.raw.pw);
                            else if(reg_country_code.equals("PY"))
                                reg_country.setImageResource(R.raw.py);
                            else if(reg_country_code.equals("QA"))
                                reg_country.setImageResource(R.raw.qa);
                            else if(reg_country_code.equals("RE"))
                                reg_country.setImageResource(R.raw.re);
                            else if(reg_country_code.equals("RO"))
                                reg_country.setImageResource(R.raw.ro);
                            else if(reg_country_code.equals("RS"))
                                reg_country.setImageResource(R.raw.rs);
                            else if(reg_country_code.equals("RU"))
                                reg_country.setImageResource(R.raw.ru);
                            else if(reg_country_code.equals("RW"))
                                reg_country.setImageResource(R.raw.rw);
                            else if(reg_country_code.equals("SA"))
                                reg_country.setImageResource(R.raw.sa);
                            else if(reg_country_code.equals("SB"))
                                reg_country.setImageResource(R.raw.sb);
                            else if(reg_country_code.equals("SC"))
                                reg_country.setImageResource(R.raw.sc);
                            else if(reg_country_code.equals("SD"))
                                reg_country.setImageResource(R.raw.sd);
                            else if(reg_country_code.equals("SE"))
                                reg_country.setImageResource(R.raw.se);
                            else if(reg_country_code.equals("SG"))
                                reg_country.setImageResource(R.raw.sg);
                            else if(reg_country_code.equals("SI"))
                                reg_country.setImageResource(R.raw.si);
                            else if(reg_country_code.equals("SK"))
                                reg_country.setImageResource(R.raw.sk);
                            else if(reg_country_code.equals("SL"))
                                reg_country.setImageResource(R.raw.sl);
                            else if(reg_country_code.equals("SM"))
                                reg_country.setImageResource(R.raw.sm);
                            else if(reg_country_code.equals("SN"))
                                reg_country.setImageResource(R.raw.sn);
                            else if(reg_country_code.equals("SO"))
                                reg_country.setImageResource(R.raw.so);
                            else if(reg_country_code.equals("SR"))
                                reg_country.setImageResource(R.raw.sr);
                            else if(reg_country_code.equals("ST"))
                                reg_country.setImageResource(R.raw.st);
                            else if(reg_country_code.equals("SV"))
                                reg_country.setImageResource(R.raw.sv);
                            else if(reg_country_code.equals("SY"))
                                reg_country.setImageResource(R.raw.sy);
                            else if(reg_country_code.equals("SZ"))
                                reg_country.setImageResource(R.raw.sz);
                            else if(reg_country_code.equals("TD"))
                                reg_country.setImageResource(R.raw.td);
                            else if(reg_country_code.equals("TG"))
                                reg_country.setImageResource(R.raw.tg);
                            else if(reg_country_code.equals("TH"))
                                reg_country.setImageResource(R.raw.th);
                            else if(reg_country_code.equals("TJ"))
                                reg_country.setImageResource(R.raw.tj);
                            else if(reg_country_code.equals("TL"))
                                reg_country.setImageResource(R.raw.tl);
                            else if(reg_country_code.equals("TM"))
                                reg_country.setImageResource(R.raw.tm);
                            else if(reg_country_code.equals("TN"))
                                reg_country.setImageResource(R.raw.tn);
                            else if(reg_country_code.equals("TO"))
                                reg_country.setImageResource(R.raw.to);
                            else if(reg_country_code.equals("TR"))
                                reg_country.setImageResource(R.raw.tr);
                            else if(reg_country_code.equals("TT"))
                                reg_country.setImageResource(R.raw.tt);
                            else if(reg_country_code.equals("TV"))
                                reg_country.setImageResource(R.raw.tv);
                            else if(reg_country_code.equals("TW"))
                                reg_country.setImageResource(R.raw.tw);
                            else if(reg_country_code.equals("TZ"))
                                reg_country.setImageResource(R.raw.tz);
                            else if(reg_country_code.equals("UA"))
                                reg_country.setImageResource(R.raw.ua);
                            else if(reg_country_code.equals("UG"))
                                reg_country.setImageResource(R.raw.ug);
                            else if(reg_country_code.equals("US"))
                                reg_country.setImageResource(R.raw.us);
                            else if(reg_country_code.equals("UY"))
                                reg_country.setImageResource(R.raw.uy);
                            else if(reg_country_code.equals("UZ"))
                                reg_country.setImageResource(R.raw.uz);
                            else if(reg_country_code.equals("VA"))
                                reg_country.setImageResource(R.raw.va);
                            else if(reg_country_code.equals("VC"))
                                reg_country.setImageResource(R.raw.vc);
                            else if(reg_country_code.equals("VE"))
                                reg_country.setImageResource(R.raw.ve);
                            else if(reg_country_code.equals("VN"))
                                reg_country.setImageResource(R.raw.vn);
                            else if(reg_country_code.equals("VU"))
                                reg_country.setImageResource(R.raw.vu);
                            else if(reg_country_code.equals("WS"))
                                reg_country.setImageResource(R.raw.ws);
                            else if(reg_country_code.equals("YE"))
                                reg_country.setImageResource(R.raw.ye);
                            else if(reg_country_code.equals("ZA"))
                                reg_country.setImageResource(R.raw.za);
                            else if(reg_country_code.equals("ZM"))
                                reg_country.setImageResource(R.raw.zm);
                            else if(reg_country_code.equals("ZW"))
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