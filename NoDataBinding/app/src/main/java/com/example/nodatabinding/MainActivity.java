package com.example.nodatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nodatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    MyViewModel myViewModel;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //进行数据绑定
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        //xml里面的变量名为data
        binding.setData(myViewModel);

        binding.setLifecycleOwner(this);

    }
}
