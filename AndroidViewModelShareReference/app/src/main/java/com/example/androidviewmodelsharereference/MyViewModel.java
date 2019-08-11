package com.example.androidviewmodelsharereference;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;


public class MyViewModel extends AndroidViewModel {

    //注意这里导入包:implementation "androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-alpha01"
    SavedStateHandle handle;

    String key = getApplication().getResources().getString(R.string.data_key);

    String shpName = getApplication().getResources().getString(R.string.data_mudule);

    public MyViewModel(@NonNull Application application,SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if(!handle.contains(key)){
            //数据不存在的时候,需要从shareReference里面加载
            this.load();
        }
    }

    public LiveData<Integer>getNumber(){

        return handle.getLiveData(key);
    }


    private void load() {
        SharedPreferences sph = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        int x = sph.getInt(key,0);
        handle.set(key,x);
    }

    public void save(){
        SharedPreferences sph = getApplication().getSharedPreferences(shpName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sph.edit();
        editor.putInt(key,getNumber().getValue());
        //需要应用
        editor.apply();
    }

    public void add(int x){
        handle.set(key,getNumber().getValue()+x);
    }
}
