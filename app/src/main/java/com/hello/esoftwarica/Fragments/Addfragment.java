package com.hello.esoftwarica.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.hello.esoftwarica.MainActivity;
import com.hello.esoftwarica.Model.Addmodel;
import com.hello.esoftwarica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Addfragment extends Fragment implements View.OnClickListener {

    private EditText etName,etAddress,etAge;
    private RadioGroup rgGender;
    private Button btnSave;
    private Addmodel addmodel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        addmodel = ViewModelProviders.of(this).get(Addmodel.class);

        View view = inflater.inflate(R.layout.fragment_add,container,false);

        etName = view.findViewById(R.id.etName);
        etAge = view.findViewById(R.id.etAge);
        etAddress = view.findViewById(R.id.etAddress);
        btnSave = view.findViewById(R.id.btnSave);
        rgGender = view.findViewById(R.id.rgGender);
        rgGender.setOnCheckedChangeListener(this);
        btnSave.setOnClickListener(this);

        final TextView textView = view.findViewById(R.id.tvAdd);
        addmodel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        return view;

    }

    String name,gender,address;
    int age;

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnSave){

            name = etName.getText().toString();
            age = Integer.parseInt(etAge.getText().toString());
            address = etAddress.getText().toString();

            if (validate()){
                MainActivity

            }

        }

    }
}
