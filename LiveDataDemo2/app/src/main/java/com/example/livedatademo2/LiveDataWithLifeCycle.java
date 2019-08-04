package com.example.livedatademo2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataWithLifeCycle extends ViewModel {

    private MutableLiveData<Integer>liveDataNumber;

    public MutableLiveData<Integer> getLiveDataNumber() {
        if(liveDataNumber == null){
            liveDataNumber = new MutableLiveData<Integer>();
            liveDataNumber.setValue(0);
        }
        return liveDataNumber;
    }


    public void addNumber(int number){
        liveDataNumber.setValue(liveDataNumber.getValue()+number);
    }
}
