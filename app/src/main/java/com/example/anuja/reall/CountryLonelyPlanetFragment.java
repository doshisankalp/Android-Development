package com.example.anuja.reall;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountryLonelyPlanetFragment extends Fragment {

    WebView myWebView;
    static String country;
    public CountryLonelyPlanetFragment() {
        // Required empty public constructor
    }


    void setCountry(String country_name){

        country=country_name;
        System.out.print("");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.your_country_3_lonelyplanet_tab, container, false);
        myWebView = (WebView) v.findViewById(R.id.webview);
        myWebView.loadUrl("https://www.lonelyplanet.com/"+country.toLowerCase());
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.canScrollHorizontally(0);
//        myWebView.jav

        // Inflate the layout for this fragment
        return v;
    }

}
