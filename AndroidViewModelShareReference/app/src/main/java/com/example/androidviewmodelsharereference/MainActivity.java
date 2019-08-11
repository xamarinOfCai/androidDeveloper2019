package com.example.androidviewmodelsharereference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import com.example.androidviewmodelsharereference.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        myViewModel = ViewModelProviders.of(this,new SavedStateVMFactory(this)).get(MyViewModel.class);
        binding.setDataBinding(myViewModel);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        myViewModel.save();
    }
}
