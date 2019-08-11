package com.example.viewmodelrestore;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.security.Key;

import static com.example.viewmodelrestore.MainActivity.KEY_NUMBER;

public class MyViewModel extends ViewModel {


    private SavedStateHandle handle;

    public MyViewModel(SavedStateHandle handle) {
        this.handle = handle;
    }

    public MutableLiveData<Integer> getNumber() {
        if(!handle.contains(KEY_NUMBER)){
            handle.set(KEY_NUMBER,0);
        }
        return handle.getLiveData(KEY_NUMBER);

//        if(number == null){
//            number  = new MutableLiveData<>();
//            number.setValue(0);
//        }
//        return number;
    }

    public void add(){
//        number.setValue(number.getValue()+1);
        getNumber().setValue(getNumber().getValue()+1);
    }
}
