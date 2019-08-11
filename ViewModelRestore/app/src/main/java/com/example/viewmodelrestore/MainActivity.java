package com.example.viewmodelrestore;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;
import com.example.viewmodelrestore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MyViewModel myViewModel;
    ActivityMainBinding dataBinding;
    public static final String KEY_NUMBER = "my_number";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //注意添加new SavedStateVMFactory
        myViewModel = ViewModelProviders.of(this,new SavedStateVMFactory(this)).get(MyViewModel.class);

        dataBinding.setData(myViewModel);
        dataBinding.setLifecycleOwner(this);
    }
}
