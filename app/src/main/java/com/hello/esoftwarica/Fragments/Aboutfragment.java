package com.hello.esoftwarica.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hello.esoftwarica.Model.Aboutmodel;
import com.hello.esoftwarica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Aboutfragment extends Fragment {

    private WebView webView;
    private Aboutmodel aboutModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        aboutModel= ViewModelProviders.of(this).get(Aboutmodel.class);
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        webView=view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://softwarica.edu.np/");
        return view;

    }

}
