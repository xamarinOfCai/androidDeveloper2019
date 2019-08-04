package com.example.spinnertest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner printTemplateSpinner = findViewById(R.id.printTemplateSpinner);

        String[] plants = new String[]{
                "请选择具体模板",
                "销售订单模板01",
                "销售订单模板02",
                "销售订单模板03",
                "销售订单模板04",
                "云打印模板01"
        };

        List<String> plantsList = new ArrayList<>(Arrays.asList(plants));

        final ArrayAdapter<String>spinnerArrayAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item,plantsList){
            @Override
            public boolean isEnabled(int position) {
                if(position == 0){
                    //第一行不启用,只是用来显示提示语的
                    return false;

                }else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
                View view = super.getDropDownView(position,convertView,parent);
                TextView textView = (TextView)view;

                if(position == 0){
                    textView.setTextColor(Color.GRAY);

                }else{
                    textView.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        printTemplateSpinner.setAdapter(spinnerArrayAdapter);

        printTemplateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectItemText = (String)adapterView.getItemAtPosition(position);

                if(position > 0){

                    Toast.makeText(getApplicationContext(),"选择了"+selectItemText,Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
