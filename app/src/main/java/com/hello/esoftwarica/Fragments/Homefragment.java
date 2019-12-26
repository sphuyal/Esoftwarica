package com.hello.esoftwarica.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hello.esoftwarica.MainActivity;
import com.hello.esoftwarica.Model.Homemodel;
import com.hello.esoftwarica.R;
import com.hello.esoftwarica.Recycleview.Softwarica;
import com.hello.esoftwarica.Recycleview.SoftwaricaAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Homefragment extends Fragment {

    private Homemodel homemodel;
    private RecyclerView recyclerView;







    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        homemodel = ViewModelProviders.of(this).get(Homemodel.class);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        final TextView textView = view.findViewById(R.id.tvHome);
        homemodel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        recyclerView = view.findViewById(R.id.Recycleview);
        List<Softwarica> softwaricaList = new ArrayList<>();

        if (MainActivity.softwaricans.isEmpty()){

            MainActivity.softwaricans.add(new Softwarica("Sandesh Phuyal","Male","Balaju",20));
            MainActivity.softwaricans.add(new Softwarica("Pukar","Male","Nepaltae",19));


            SoftwaricaAdapter softwaricaAdapter=new SoftwaricaAdapter(getContext(),MainActivity.softwaricans);
            recyclerView.setAdapter(softwaricaAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        }

        else {
            SoftwaricaAdapter softwaricaAdapter = new SoftwaricaAdapter(getContext(),MainActivity.softwaricans);
            recyclerView.setAdapter(softwaricaAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }



        return view;
    }

}
