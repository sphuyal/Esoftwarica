package com.hello.esoftwarica.Model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Addmodel extends ViewModel {

    private MutableLiveData<String> mText;

    public Addmodel()
    {
        mText = new MutableLiveData<>();
        mText.setValue("Add Student");
    }

    public LiveData<String> getText()
    {
        return mText;
    }


}
