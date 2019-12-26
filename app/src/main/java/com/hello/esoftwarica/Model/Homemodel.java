package com.hello.esoftwarica.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Homemodel extends ViewModel {

    private MutableLiveData<String> mText;

    public Homemodel(){
        mText = new MutableLiveData<>();
        mText.setValue("Home Fragment");
    }
    public LiveData<String> getText(){
        return mText;
    }
}
