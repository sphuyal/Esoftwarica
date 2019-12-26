package com.hello.esoftwarica.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.hello.esoftwarica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Addfragment extends Fragment implements View.OnClickListener {

    private EditText etName,etAddress,etAge;
    private RadioGroup rgGender;
    private Button btnSave;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onClick(View v) {

    }
}
