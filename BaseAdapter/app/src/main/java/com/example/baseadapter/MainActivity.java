package com.example.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<UserInfo>users = new ArrayList<>();
        for(int i=0; i < 50; i++){
            UserInfo userInfo = new UserInfo();
            userInfo.sex = (i % 2 == 0 ? "man":"female");
            userInfo.name = "caijj"+i;
            userInfo.age = 10+i;
            users.add(userInfo);
        }

        UserDefineAdapter userDefineAdapter = new UserDefineAdapter(users);
        ListView list =findViewById(R.id.list_item);
        list.setAdapter(userDefineAdapter);

    }
}
