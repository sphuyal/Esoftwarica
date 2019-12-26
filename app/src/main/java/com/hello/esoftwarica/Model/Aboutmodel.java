package com.hello.esoftwarica.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Aboutmodel {

    private MutableLiveData<String> mText;

    public Aboutmodel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is Aboutus fragment");
    }

    public LiveData<String> getText(){
        return mText;
    }
}
