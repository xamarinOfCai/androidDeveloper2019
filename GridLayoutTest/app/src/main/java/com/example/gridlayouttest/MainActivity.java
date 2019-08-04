package com.example.gridlayouttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

import static android.widget.GridLayout.*;

public class MainActivity extends AppCompatActivity {
    GridLayout gridLayout;

    //定义16个按钮
    String[]chars = new String[]{
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            ".","0","=","+"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout = findViewById(R.id.root);
        for(int i= 0; i < chars.length; i++){
            Button bu = new Button(this);
            bu.setText(chars[i]);
            bu.setTextSize(40);
            Spec rowSepc = GridLayout.spec(i/4+2);
            Spec columnSepc = GridLayout.spec(i%4);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSepc,columnSepc);
            params.setGravity(Gravity.FILL);
            gridLayout.addView(bu,params);

        }
    }
}
