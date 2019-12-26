package com.hello.esoftwarica.Model;

import androidx.lifecycle.MutableLiveData;

public class Homemodel {

    private MutableLiveData<String> mText;

    public Homemodel(){
        mText = new MutableLiveData<>();
        mText.setValue("Home Fragment");
    }
}
