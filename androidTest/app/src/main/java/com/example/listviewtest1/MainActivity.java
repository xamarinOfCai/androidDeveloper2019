package com.example.listviewtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView =findViewById(R.id.list_view);
        List<String> datas =new ArrayList<String>();

        for(int i =0; i < 20; i++){
           datas.add(String.valueOf(i));
        }

        ArrayAdapter<String>listAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,datas);
        listView.setAdapter(listAdapter);
    }
}
