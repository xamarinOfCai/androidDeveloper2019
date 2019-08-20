package com.caijingjin.calculatetest;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import java.util.Random;

/**
 *
 */
public class MyViewModel extends AndroidViewModel {

    SavedStateHandle handle;

    private static String KEY_HIGH_SCORE ="key_high_score";
    private static String KEY_LEFT_NUMBER ="key_left_number";
    private static String KEY_RIGHT_NUMBER ="key_right_number";
    private static String KEY_OPERATOR ="key_operator";
    private static String KEY_ANSWER ="key_answer";
    private static String SAVE_SHP_DATA_NAME ="key_shp_data_name";
    private static String KEY_CURRENT_SCORE ="key_current_score";
    public boolean win_flag = false;
    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        if(!handle.contains(KEY_HIGH_SCORE)){
            SharedPreferences shp = getApplication().getSharedPreferences(SAVE_SHP_DATA_NAME, Context.MODE_PRIVATE);
            handle.set(KEY_HIGH_SCORE,shp.getInt(KEY_HIGH_SCORE,0));
            handle.set(KEY_LEFT_NUMBER,0);
            handle.set(KEY_RIGHT_NUMBER,0);
            handle.set(KEY_OPERATOR,"+");
            handle.set(KEY_CURRENT_SCORE,0);
            handle.set(KEY_ANSWER,0);
        }
        this.handle = handle;
    }


    /**
     * 获取左边的数字
     * @return
     */
    public MutableLiveData<Integer>getLeftNumber(){
        return handle.getLiveData(KEY_LEFT_NUMBER);
    }

    /**
     * 获取右边的数字
     * @return
     */
    public MutableLiveData<Integer>getRightNumber(){
        return handle.getLiveData(KEY_RIGHT_NUMBER);
    }


    /**
     * 获取操作符
     * @return
     */
    public MutableLiveData<String>getOperator(){
        return handle.getLiveData(KEY_OPERATOR);
    }

    /**
     * 获取最高记录
     * @return
     */
    public MutableLiveData<Integer>getHighScore(){
        return handle.getLiveData(KEY_HIGH_SCORE);
    }

    /**
     * 获取当前得分
     * @return
     */
    public MutableLiveData<Integer>getCurrentScore(){
        return handle.getLiveData(KEY_CURRENT_SCORE);
    }

    /**
     * 获取答案
     * @return
     */
    public MutableLiveData<Integer>getAnswer(){
        return handle.getLiveData(KEY_ANSWER);
    }


    /**
     * 随机产生算式
     */
    public void generator(){
        Random random = new Random();
        int x,y;
        int LEVEL = 20;
        x = random.nextInt(LEVEL)+1;
        y = random.nextInt(LEVEL)+1;

        if(x % 2 == 0 ){
            getOperator().setValue("+");
            if(x > y){
                getAnswer().setValue(x);
                getLeftNumber().setValue(y);
                getRightNumber().setValue(x-y);
            }else{
                getAnswer().setValue(y);
                getLeftNumber().setValue(x);
                getRightNumber().setValue(y-x);
            }
        }else{
            getOperator().setValue("-");
            if(x > y){
                getAnswer().setValue(x-y);
                getLeftNumber().setValue(x);
                getRightNumber().setValue(y);
            }else{
                getAnswer().setValue(y-x);
                getLeftNumber().setValue(y);
                getRightNumber().setValue(x);
            }
        }
    }

    /**
     * 保存
     */
    @SuppressWarnings("ConstantConditions")
    public void save(){
        SharedPreferences shp = getApplication().getSharedPreferences(SAVE_SHP_DATA_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(KEY_HIGH_SCORE,getHighScore().getValue());
        editor.apply();
    }

    public void answerCorrect(){
        getCurrentScore().setValue(getCurrentScore().getValue()+1);
        if(getCurrentScore().getValue() > getHighScore().getValue()){
            getHighScore().setValue(getCurrentScore().getValue());
            win_flag = true;
        }
        generator();
    }
}
