package com.hello.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private EditText etEdname,etEdage,etEdaddress;
    private RadioGroup rgEdgender;
    private RadioButton rgEdmale,rgEdfemale,rgEdothers;
    private String name,address,gender;
    private int age;
    private Button btnEdsave,btnEdcancel;
    public static int index;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .8));

        etEdname = findViewById(R.id.etEdname);
        etEdage = findViewById(R.id.etEdage);
        etEdaddress = findViewById(R.id.etEdaddress);
        rgEdgender = findViewById(R.id.rgEdGender);
        rgEdmale = findViewById(R.id.rgEdMale);
        rgEdfemale = findViewById(R.id.rgEdFemale);
        rgEdothers = findViewById(R.id.rgEdOthers);
        btnEdsave = findViewById(R.id.btnEdSave);
        btnEdcancel = findViewById(R.id.btnEdCancel);

        etEdname.setText(MainActivity.softwaricans.get(index).getName());
        etEdaddress.setText(MainActivity.softwaricans.get(index).getAddress());
        etEdage.setText(MainActivity.softwaricans.get(index).getAge());


        gender = MainActivity.softwaricans.get(index).getGender();
        if (gender == "male"){
            rgEdmale.setChecked(true);
            rgEdfemale.setChecked(false);
            rgEdothers.setChecked(false);
        } else if (gender == "female"){
            rgEdmale.setChecked(false);
            rgEdfemale.setChecked(true);
            rgEdothers.setChecked(false);
        } if (gender == "other"){
            rgEdmale.setChecked(false);
            rgEdfemale.setChecked(false);
            rgEdothers.setChecked(true);
        }
        rgEdgender.setOnCheckedChangeListener(this);
        btnEdsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    name = etEdname.getText().toString();
                    address = etEdaddress.getText().toString();
                    age = Integer.parseInt(etEdage.getText().toString());
                    try {
                        MainActivity.softwaricans.get(index).setName(name);
                        MainActivity.softwaricans.get(index).setAddress(address);
                        MainActivity.softwaricans.get(index).setAge(age);
                        MainActivity.softwaricans.get(index).setGender(gender);
                        Toast.makeText(UpdateActivity.this, "Student Updated", Toast.LENGTH_SHORT).show();
                        finish();
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(UpdateActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnEdcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean validate(){
        if (TextUtils.isEmpty(etEdname.getText())){
            etEdname.setError("Enter Full Name");
            etEdname.requestFocus();
            return false;
        } else if (TextUtils.isEmpty((etEdage.getText()))){
            etEdname.setError("Enter Age");
            etEdname.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etEdage.getText())){
            etEdage.setError("Enter the Address");
            return false;
        } else if (TextUtils.isEmpty(gender)){
            Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rgEdMale){
            gender = "male";
        }
        if (checkedId == R.id.rgEdFemale){
            gender = "female";
        }
        if (checkedId == R.id.rgEdOthers){
            gender = "others";
        }
    }
}
