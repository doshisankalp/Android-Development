package com.example.anuja.reall;




import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
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
            String wiki_link=country.getString("capitalWikiLink");
            String lonelyPlanetLink=country.getString("lonelyPlanetCode");


            countryWikipediaFragment.setCountry(wiki_link);
            System.out.print("");
            countryLonelyPlanetFragment.setCountry(lonelyPlanetLink);
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
        ImageView country=(ImageView)view.findViewById(R.id.countryFlag);
        ImageView reg_country=(ImageView)view.findViewById(R.id.registerCountryFlag);
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
                String reg_country_code=selfCountry.getString("code").toUpperCase();
                Log.e("code",reg_country_code);
                if(reg_country_code.equals("AD"))
                    reg_country.setImageResource(R.drawable.ad);

                else if(reg_country_code.equals("AE"))
                    reg_country.setImageResource(R.drawable.ae);
                else if(reg_country_code.equals("AF"))
                    reg_country.setImageResource(R.drawable.af);

                else if(reg_country_code.equals("AG"))
                    reg_country.setImageResource(R.drawable.ag);
                else if(reg_country_code.equals("AL"))
                    reg_country.setImageResource(R.drawable.al);
                else if(reg_country_code.equals("AM"))
                    reg_country.setImageResource(R.drawable.am);
                else if(reg_country_code.equals("AO"))
                    reg_country.setImageResource(R.drawable.ao);
                else if(reg_country_code.equals("AR"))
                    reg_country.setImageResource(R.drawable.ar);
                else if(reg_country_code.equals("AT"))
                    reg_country.setImageResource(R.drawable.at);
                else if(reg_country_code.equals("AU"))
                    reg_country.setImageResource(R.drawable.au);
                else if(reg_country_code.equals("AZ"))
                    reg_country.setImageResource(R.drawable.az);
                else if(reg_country_code.equals("BA"))
                    reg_country.setImageResource(R.drawable.ba);
                else if(reg_country_code.equals("BB"))
                    reg_country.setImageResource(R.drawable.bb);
                else if(reg_country_code.equals("BD"))
                    reg_country.setImageResource(R.drawable.bd);
                else if(reg_country_code.equals("BE"))
                    reg_country.setImageResource(R.drawable.be);
                else if(reg_country_code.equals("BF"))
                    reg_country.setImageResource(R.drawable.bf);
                else if(reg_country_code.equals("BG"))
                    reg_country.setImageResource(R.drawable.bg);
                else if(reg_country_code.equals("BH"))
                    reg_country.setImageResource(R.drawable.bh);
                else if(reg_country_code.equals("BI"))
                    reg_country.setImageResource(R.drawable.bi);
                else if(reg_country_code.equals("BJ"))
                    reg_country.setImageResource(R.drawable.bj);
                else if(reg_country_code.equals("BN"))
                    reg_country.setImageResource(R.drawable.bn);
                else if(reg_country_code.equals("BO"))
                    reg_country.setImageResource(R.drawable.bo);
                else if(reg_country_code.equals("BR"))
                    reg_country.setImageResource(R.drawable.br);
                else if(reg_country_code.equals("BS"))
                    reg_country.setImageResource(R.drawable.bs);
                else if(reg_country_code.equals("BT"))
                    reg_country.setImageResource(R.drawable.bt);
                else if(reg_country_code.equals("BW"))
                    reg_country.setImageResource(R.drawable.bw);
                else if(reg_country_code.equals("BY"))
                    reg_country.setImageResource(R.drawable.by);
                else if(reg_country_code.equals("BZ"))
                    reg_country.setImageResource(R.drawable.bz);
                else if(reg_country_code.equals("CA"))
                    reg_country.setImageResource(R.drawable.ca);
                else if(reg_country_code.equals("CD"))
                    reg_country.setImageResource(R.drawable.cd);
                else if(reg_country_code.equals("CF"))
                    reg_country.setImageResource(R.drawable.cf);
                else if(reg_country_code.equals("CG"))
                    reg_country.setImageResource(R.drawable.cg);
                else if(reg_country_code.equals("CH"))
                    reg_country.setImageResource(R.drawable.ch);
                else if(reg_country_code.equals("CI"))
                    reg_country.setImageResource(R.drawable.ci);
                else if(reg_country_code.equals("CL"))
                    reg_country.setImageResource(R.drawable.cl);
                else if(reg_country_code.equals("CM"))
                    reg_country.setImageResource(R.drawable.cm);
                else if(reg_country_code.equals("CN"))
                    reg_country.setImageResource(R.drawable.cn);
                else if(reg_country_code.equals("CO"))
                    reg_country.setImageResource(R.drawable.co);
                else if(reg_country_code.equals("CR"))
                    reg_country.setImageResource(R.drawable.cr);
                else if(reg_country_code.equals("CU"))
                    reg_country.setImageResource(R.drawable.cu);
                else if(reg_country_code.equals("CV"))
                    reg_country.setImageResource(R.drawable.cv);
                else if(reg_country_code.equals("CY"))
                    reg_country.setImageResource(R.drawable.cy);
                else if(reg_country_code.equals("CZ"))
                    reg_country.setImageResource(R.drawable.cz);
                else if(reg_country_code.equals("DE"))
                    reg_country.setImageResource(R.drawable.de);
                else if(reg_country_code.equals("DJ"))
                    reg_country.setImageResource(R.drawable.dj);
                else if(reg_country_code.equals("DK"))
                    reg_country.setImageResource(R.drawable.dk);
                else if(reg_country_code.equals("DM"))
                    reg_country.setImageResource(R.drawable.dm);
                else if(reg_country_code.equals("DO"))
                    reg_country.setImageResource(R.drawable.do1);
                else if(reg_country_code.equals("DZ"))
                    reg_country.setImageResource(R.drawable.dz);
                else if(reg_country_code.equals("EC"))
                    reg_country.setImageResource(R.drawable.ec);
                else if(reg_country_code.equals("EE"))
                    reg_country.setImageResource(R.drawable.ee);
                else if(reg_country_code.equals("EG"))
                    reg_country.setImageResource(R.drawable.eg);
                else if(reg_country_code.equals("EH"))
                    reg_country.setImageResource(R.drawable.eh);
                else if(reg_country_code.equals("ER"))
                    reg_country.setImageResource(R.drawable.er);
                else if(reg_country_code.equals("ES"))
                    reg_country.setImageResource(R.drawable.es);
                else if(reg_country_code.equals("ET"))
                    reg_country.setImageResource(R.drawable.et);
                else if(reg_country_code.equals("FI"))
                    reg_country.setImageResource(R.drawable.fi);
                else if(reg_country_code.equals("FJ"))
                    reg_country.setImageResource(R.drawable.fj);
                else if(reg_country_code.equals("FM"))
                    reg_country.setImageResource(R.drawable.fm);
                else if(reg_country_code.equals("FR"))
                    reg_country.setImageResource(R.drawable.fr);
                else if(reg_country_code.equals("GA"))
                    reg_country.setImageResource(R.drawable.ga);
                else if(reg_country_code.equals("GB"))
                    reg_country.setImageResource(R.drawable.gb);
                else if(reg_country_code.equals("GD"))
                    reg_country.setImageResource(R.drawable.gd);
                else if(reg_country_code.equals("GE"))
                    reg_country.setImageResource(R.drawable.ge);
                else if(reg_country_code.equals("GF"))
                    reg_country.setImageResource(R.drawable.gf);
                else if(reg_country_code.equals("GH"))
                    reg_country.setImageResource(R.drawable.gh);
                else if(reg_country_code.equals("GM"))
                    reg_country.setImageResource(R.drawable.gm);
                else if(reg_country_code.equals("GN"))
                    reg_country.setImageResource(R.drawable.gn);
                else if(reg_country_code.equals("GP"))
                    reg_country.setImageResource(R.drawable.gp);
                else if(reg_country_code.equals("GQ"))
                    reg_country.setImageResource(R.drawable.gq);
                else if(reg_country_code.equals("GR"))
                    reg_country.setImageResource(R.drawable.gr);
                else if(reg_country_code.equals("GT"))
                    reg_country.setImageResource(R.drawable.gt);
                else if(reg_country_code.equals("GU"))
                    reg_country.setImageResource(R.drawable.gu);
                else if(reg_country_code.equals("GW"))
                    reg_country.setImageResource(R.drawable.gw);
                else if(reg_country_code.equals("GY"))
                    reg_country.setImageResource(R.drawable.gy);
                else if(reg_country_code.equals("HK"))
                    reg_country.setImageResource(R.drawable.hk);
                else if(reg_country_code.equals("HN"))
                    reg_country.setImageResource(R.drawable.hn);
                else if(reg_country_code.equals("HR"))
                    reg_country.setImageResource(R.drawable.hr);
                else if(reg_country_code.equals("HT"))
                    reg_country.setImageResource(R.drawable.ht);
                else if(reg_country_code.equals("HU"))
                    reg_country.setImageResource(R.drawable.hu);
                else if(reg_country_code.equals("ID"))
                    reg_country.setImageResource(R.drawable.id);
                else if(reg_country_code.equals("IE"))
                    reg_country.setImageResource(R.drawable.ie);
                else if(reg_country_code.equals("IL"))
                    reg_country.setImageResource(R.drawable.il);
                else if(reg_country_code.equals("IN"))
                    reg_country.setImageResource(R.drawable.in);
                else if(reg_country_code.equals("IQ"))
                    reg_country.setImageResource(R.drawable.iq);
                else if(reg_country_code.equals("IR"))
                    reg_country.setImageResource(R.drawable.ir);
                else if(reg_country_code.equals("IS"))
                    reg_country.setImageResource(R.drawable.is);
                else if(reg_country_code.equals("IT"))
                    reg_country.setImageResource(R.drawable.it);
                else if(reg_country_code.equals("JM"))
                    reg_country.setImageResource(R.drawable.jm);
                else if(reg_country_code.equals("JO"))
                    reg_country.setImageResource(R.drawable.jo);
                else if(reg_country_code.equals("JP"))
                    reg_country.setImageResource(R.drawable.jp);
                else if(reg_country_code.equals("KE"))
                    reg_country.setImageResource(R.drawable.ke);
                else if(reg_country_code.equals("KG"))
                    reg_country.setImageResource(R.drawable.kg);
                else if(reg_country_code.equals("KH"))
                    reg_country.setImageResource(R.drawable.kh);
                else if(reg_country_code.equals("KI"))
                    reg_country.setImageResource(R.drawable.ki);
                else if(reg_country_code.equals("KM"))
                    reg_country.setImageResource(R.drawable.km);
                else if(reg_country_code.equals("KN"))
                    reg_country.setImageResource(R.drawable.kn);
                else if(reg_country_code.equals("KP"))
                    reg_country.setImageResource(R.drawable.kp);
                else if(reg_country_code.equals("KR"))
                    reg_country.setImageResource(R.drawable.kr);
                else if(reg_country_code.equals("KS"))
                    reg_country.setImageResource(R.drawable.ks);
                else if(reg_country_code.equals("KW"))
                    reg_country.setImageResource(R.drawable.kw);
                else if(reg_country_code.equals("KZ"))
                    reg_country.setImageResource(R.drawable.kz);
                else if(reg_country_code.equals("LA"))
                    reg_country.setImageResource(R.drawable.la);
                else if(reg_country_code.equals("LB"))
                    reg_country.setImageResource(R.drawable.lb);
                else if(reg_country_code.equals("LC"))
                    reg_country.setImageResource(R.drawable.lc);
                else if(reg_country_code.equals("LI"))
                    reg_country.setImageResource(R.drawable.li);
                else if(reg_country_code.equals("LK"))
                    reg_country.setImageResource(R.drawable.lk);
                else if(reg_country_code.equals("LR"))
                    reg_country.setImageResource(R.drawable.lr);
                else if(reg_country_code.equals("LS"))
                    reg_country.setImageResource(R.drawable.ls);
                else if(reg_country_code.equals("LT"))
                    reg_country.setImageResource(R.drawable.lt);
                else if(reg_country_code.equals("LU"))
                    reg_country.setImageResource(R.drawable.lu);
                else if(reg_country_code.equals("LV"))
                    reg_country.setImageResource(R.drawable.lv);
                else if(reg_country_code.equals("LY"))
                    reg_country.setImageResource(R.drawable.ly);
                else if(reg_country_code.equals("MA"))
                    reg_country.setImageResource(R.drawable.ma);
                else if(reg_country_code.equals("MC"))
                    reg_country.setImageResource(R.drawable.mc);
                else if(reg_country_code.equals("MD"))
                    reg_country.setImageResource(R.drawable.md);
                else if(reg_country_code.equals("ME"))
                    reg_country.setImageResource(R.drawable.me);
                else if(reg_country_code.equals("MG"))
                    reg_country.setImageResource(R.drawable.mg);
                else if(reg_country_code.equals("MH"))
                    reg_country.setImageResource(R.drawable.mg);
                else if(reg_country_code.equals("MK"))
                    reg_country.setImageResource(R.drawable.mk);
                else if(reg_country_code.equals("ML"))
                    reg_country.setImageResource(R.drawable.ml);
                else if(reg_country_code.equals("MM"))
                    reg_country.setImageResource(R.drawable.mm);
                else if(reg_country_code.equals("MN"))
                    reg_country.setImageResource(R.drawable.mn);
                else if(reg_country_code.equals("MO"))
                    reg_country.setImageResource(R.drawable.mo);
                else if(reg_country_code.equals("MQ"))
                    reg_country.setImageResource(R.drawable.mq);
                else if(reg_country_code.equals("MR"))
                    reg_country.setImageResource(R.drawable.mr);
                else if(reg_country_code.equals("MT"))
                    reg_country.setImageResource(R.drawable.mt);
                else if(reg_country_code.equals("MU"))
                    reg_country.setImageResource(R.drawable.mu);
                else if(reg_country_code.equals("MV"))
                    reg_country.setImageResource(R.drawable.mv);
                else if(reg_country_code.equals("MW"))
                    reg_country.setImageResource(R.drawable.mw);
                else if(reg_country_code.equals("MX"))
                    reg_country.setImageResource(R.drawable.mx);
                else if(reg_country_code.equals("MY"))
                    reg_country.setImageResource(R.drawable.my);
                else if(reg_country_code.equals("MZ"))
                    reg_country.setImageResource(R.drawable.mz);
                else if(reg_country_code.equals("NA"))
                    reg_country.setImageResource(R.drawable.na);
                else if(reg_country_code.equals("NC"))
                    reg_country.setImageResource(R.drawable.nc);
                else if(reg_country_code.equals("NE"))
                    reg_country.setImageResource(R.drawable.ne);
                else if(reg_country_code.equals("NG"))
                    reg_country.setImageResource(R.drawable.ng);
                else if(reg_country_code.equals("NI"))
                    reg_country.setImageResource(R.drawable.ni);
                else if(reg_country_code.equals("NL"))
                    reg_country.setImageResource(R.drawable.nl);
                else if(reg_country_code.equals("NO"))
                    reg_country.setImageResource(R.drawable.no);
                else if(reg_country_code.equals("NP"))
                    reg_country.setImageResource(R.drawable.np);
                else if(reg_country_code.equals("NR"))
                    reg_country.setImageResource(R.drawable.nr);
                else if(reg_country_code.equals("NZ"))
                    reg_country.setImageResource(R.drawable.nz);
                else if(reg_country_code.equals("OM"))
                    reg_country.setImageResource(R.drawable.om);
                else if(reg_country_code.equals("PA"))
                    reg_country.setImageResource(R.drawable.pa);
                else if(reg_country_code.equals("PE"))
                    reg_country.setImageResource(R.drawable.pe);
                else if(reg_country_code.equals("PF"))
                    reg_country.setImageResource(R.drawable.pf);
                else if(reg_country_code.equals("PG"))
                    reg_country.setImageResource(R.drawable.pg);
                else if(reg_country_code.equals("PH"))
                    reg_country.setImageResource(R.drawable.ph);
                else if(reg_country_code.equals("PK"))
                    reg_country.setImageResource(R.drawable.pk);
                else if(reg_country_code.equals("PL"))
                    reg_country.setImageResource(R.drawable.pl);
                else if(reg_country_code.equals("PR"))
                    reg_country.setImageResource(R.drawable.pr);
                else if(reg_country_code.equals("PT"))
                    reg_country.setImageResource(R.drawable.pt);
                else if(reg_country_code.equals("PW"))
                    reg_country.setImageResource(R.drawable.pw);
                else if(reg_country_code.equals("PY"))
                    reg_country.setImageResource(R.drawable.py);
                else if(reg_country_code.equals("QA"))
                    reg_country.setImageResource(R.drawable.qa);
                else if(reg_country_code.equals("RE"))
                    reg_country.setImageResource(R.drawable.re);
                else if(reg_country_code.equals("RO"))
                    reg_country.setImageResource(R.drawable.ro);
                else if(reg_country_code.equals("RS"))
                    reg_country.setImageResource(R.drawable.rs);
                else if(reg_country_code.equals("RU"))
                    reg_country.setImageResource(R.drawable.ru);
                else if(reg_country_code.equals("RW"))
                    reg_country.setImageResource(R.drawable.rw);
                else if(reg_country_code.equals("SA"))
                    reg_country.setImageResource(R.drawable.sa);
                else if(reg_country_code.equals("SB"))
                    reg_country.setImageResource(R.drawable.sb);
                else if(reg_country_code.equals("SC"))
                    reg_country.setImageResource(R.drawable.sc);
                else if(reg_country_code.equals("SD"))
                    reg_country.setImageResource(R.drawable.sd);
                else if(reg_country_code.equals("SE"))
                    reg_country.setImageResource(R.drawable.se);
                else if(reg_country_code.equals("SG"))
                    reg_country.setImageResource(R.drawable.sg);
                else if(reg_country_code.equals("SI"))
                    reg_country.setImageResource(R.drawable.si);
                else if(reg_country_code.equals("SK"))
                    reg_country.setImageResource(R.drawable.sk);
                else if(reg_country_code.equals("SL"))
                    reg_country.setImageResource(R.drawable.sl);
                else if(reg_country_code.equals("SM"))
                    reg_country.setImageResource(R.drawable.sm);
                else if(reg_country_code.equals("SN"))
                    reg_country.setImageResource(R.drawable.sn);
                else if(reg_country_code.equals("SO"))
                    reg_country.setImageResource(R.drawable.so);
                else if(reg_country_code.equals("SR"))
                    reg_country.setImageResource(R.drawable.sr);
                else if(reg_country_code.equals("ST"))
                    reg_country.setImageResource(R.drawable.st);
                else if(reg_country_code.equals("SV"))
                    reg_country.setImageResource(R.drawable.sv);
                else if(reg_country_code.equals("SY"))
                    reg_country.setImageResource(R.drawable.sy);
                else if(reg_country_code.equals("SZ"))
                    reg_country.setImageResource(R.drawable.sz);
                else if(reg_country_code.equals("TD"))
                    reg_country.setImageResource(R.drawable.td);
                else if(reg_country_code.equals("TG"))
                    reg_country.setImageResource(R.drawable.tg);
                else if(reg_country_code.equals("TH"))
                    reg_country.setImageResource(R.drawable.th);
                else if(reg_country_code.equals("TJ"))
                    reg_country.setImageResource(R.drawable.tj);
                else if(reg_country_code.equals("TL"))
                    reg_country.setImageResource(R.drawable.tl);
                else if(reg_country_code.equals("TM"))
                    reg_country.setImageResource(R.drawable.tm);
                else if(reg_country_code.equals("TN"))
                    reg_country.setImageResource(R.drawable.tn);
                else if(reg_country_code.equals("TO"))
                    reg_country.setImageResource(R.drawable.to);
                else if(reg_country_code.equals("TR"))
                    reg_country.setImageResource(R.drawable.tr);
                else if(reg_country_code.equals("TT"))
                    reg_country.setImageResource(R.drawable.tt);
                else if(reg_country_code.equals("TV"))
                    reg_country.setImageResource(R.drawable.tv);
                else if(reg_country_code.equals("TW"))
                    reg_country.setImageResource(R.drawable.tw);
                else if(reg_country_code.equals("TZ"))
                    reg_country.setImageResource(R.drawable.tz);
                else if(reg_country_code.equals("UA"))
                    reg_country.setImageResource(R.drawable.ua);
                else if(reg_country_code.equals("UG"))
                    reg_country.setImageResource(R.drawable.ug);
                else if(reg_country_code.equals("US"))
                    reg_country.setImageResource(R.drawable.us);
                else if(reg_country_code.equals("UY"))
                    reg_country.setImageResource(R.drawable.uy);
                else if(reg_country_code.equals("UZ"))
                    reg_country.setImageResource(R.drawable.uz);
                else if(reg_country_code.equals("VA"))
                    reg_country.setImageResource(R.drawable.va);
                else if(reg_country_code.equals("VC"))
                    reg_country.setImageResource(R.drawable.vc);
                else if(reg_country_code.equals("VE"))
                    reg_country.setImageResource(R.drawable.ve);
                else if(reg_country_code.equals("VN"))
                    reg_country.setImageResource(R.drawable.vn);
                else if(reg_country_code.equals("VU"))
                    reg_country.setImageResource(R.drawable.vu);
                else if(reg_country_code.equals("WS"))
                    reg_country.setImageResource(R.drawable.ws);
                else if(reg_country_code.equals("YE"))
                    reg_country.setImageResource(R.drawable.ye);
                else if(reg_country_code.equals("ZA"))
                    reg_country.setImageResource(R.drawable.za);
                else if(reg_country_code.equals("ZM"))
                    reg_country.setImageResource(R.drawable.zm);
                else if(reg_country_code.equals("ZW"))
                    reg_country.setImageResource(R.drawable.zw);



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

                String country_code=registerCountry.getString("code").toUpperCase();

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