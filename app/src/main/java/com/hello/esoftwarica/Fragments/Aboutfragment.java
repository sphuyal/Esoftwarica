package com.hello.esoftwarica.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.hello.esoftwarica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Aboutfragment extends Fragment {

    private WebView webView;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about,container,false);

        webView = view.findViewById(R.id.webview);
        webView = getSett
    }

}
