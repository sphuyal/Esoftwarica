package com.hello.esoftwarica.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Aboutmodel extends ViewModel {

    private MutableLiveData<String> mText;

    public Aboutmodel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is AboutUs fragment");
    }
    public LiveData<String> getText() {
        return mText;
    }
}
