package com.example.score;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//注意这里的databinding的依赖库
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.example.score.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //build.gradle里面添加上implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0'
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        activityMainBinding.setData(myViewModel);
        activityMainBinding.setLifecycleOwner(this);
    }
}
