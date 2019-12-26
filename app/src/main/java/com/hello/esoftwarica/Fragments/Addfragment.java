package com.hello.esoftwarica.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hello.esoftwarica.MainActivity;
import com.hello.esoftwarica.Model.Addmodel;
import com.hello.esoftwarica.R;
import com.hello.esoftwarica.Recycleview.Softwarica;

/**
 * A simple {@link Fragment} subclass.
 */
public class Addfragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

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
                MainActivity.softwaricans.add(new Softwarica(name, gender,address, age));
                Toast.makeText(getContext(), "Student Added", Toast.LENGTH_SHORT).show();

            }

        }

    }

    private boolean validate(){
        if (TextUtils.isEmpty(etName.getText())){
            etName.setError("Enter your Full Name");
            etName.requestFocus();
            return false;
        }else if (TextUtils.isEmpty(etAge.getText())){
            etAge.setError("Enter your Age");
            etAge.requestFocus();
            return false;
        }else if (TextUtils.isEmpty(etAddress.getText())){
            etAddress.setError("Enter your Address");
            etAddress.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rbMale) {
            gender = "Male";
        }
        if (checkedId == R.id.rbFemale) {
            gender = "Female";
        }
        if (checkedId == R.id.rbOthers) {
            gender = "Others";
        }

    }

}
