package com.example.livedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> number;
    private int changeNumber = 0;

    public MutableLiveData<String> getNumber(){
        if(number == null){
            number = new MutableLiveData<>();
        }
        return number;
    }

    public void plusOne(){
        number.setValue(String.valueOf(++changeNumber));
    }

    public void minusOne(){
        number.setValue(String.valueOf(--changeNumber));
    }


}
