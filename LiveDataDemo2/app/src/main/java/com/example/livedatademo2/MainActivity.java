package com.example.livedatademo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    ImageView left;

    ImageView right;

    LiveDataWithLifeCycle  liveDataWithLifeCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        left = findViewById(R.id.imageView);
        right = findViewById(R.id.imageView2);

        liveDataWithLifeCycle = ViewModelProviders.of(this).get(LiveDataWithLifeCycle.class);
        liveDataWithLifeCycle.getLiveDataNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(liveDataWithLifeCycle.getLiveDataNumber()));
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liveDataWithLifeCycle.addNumber(1);
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liveDataWithLifeCycle.addNumber(-2);
            }
        });
    }
}
