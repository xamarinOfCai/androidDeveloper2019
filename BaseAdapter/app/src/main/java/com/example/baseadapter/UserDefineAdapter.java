package com.example.baseadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import com.example.baseadapter.UserInfo;

public class UserDefineAdapter extends BaseAdapter {

    List<UserInfo> dataList;

    public UserDefineAdapter(List<UserInfo> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //获取每一项的View
        View itemRootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_userinfo,null);

        TextView tvName = itemRootView.findViewById(R.id.tv_name);
        tvName.setText(dataList.get(i).name);

        TextView tvSex = itemRootView.findViewById(R.id.tv_sex);
        tvSex.setText(dataList.get(i).sex);

        TextView tvAge = itemRootView.findViewById(R.id.tv_age);
        tvAge.setText(dataList.get(i).age+"");

        ImageView image = itemRootView.findViewById(R.id.tv_imageId);
        if(dataList.get(i).sex.equals("man")) {
            image.setBackgroundResource(R.drawable.male);
        }else{
            image.setBackgroundResource(R.drawable.female);
        }
        return itemRootView;
    }
}
