package com.example.anuja.reall;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountryWikipediaFragment extends Fragment {

    WebView myWebView;
    static String country;
    static JSONObject jsonObject=new JSONObject();


    public CountryWikipediaFragment() {
        // Required empty public constructor
    }

    void setCountry(String country_name){

        country=country_name;


//        this.jsonObject=jsonObject;
//
//        try {
//            JSONObject coun = jsonObject.getJSONObject("country");
//            System.out.print("");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.your_country_2_wikipedia_tab, container, false);
        myWebView = (WebView) v.findViewById(R.id.webview);
        myWebView.loadUrl(country);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setHorizontalScrollBarEnabled(false);

//        myWebView.jav

        // Inflate the layout for this fragment
        return v;
    }


}
