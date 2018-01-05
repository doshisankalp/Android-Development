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
public class CountryWikipediaFragment extends Fragment {

    WebView myWebView;


    public CountryWikipediaFragment() {
        // Required empty public constructor
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
        myWebView.loadUrl("https://en.wikipedia.org/wiki/China");
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setHorizontalScrollBarEnabled(false);

//        myWebView.jav

        // Inflate the layout for this fragment
        return v;
    }


}
