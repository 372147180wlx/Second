package com.itcast.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import java.util.Random;

/**
 * Created by lingxin on 2016/8/13.
 */
public class LVAdapter extends BaseAdapter {
    private List<String> list;
    private Context context;

    public LVAdapter(List contentlist, Context content) {
        list = contentlist;
        this.context = content;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        //给textView设置参数
        tv.setText(list.get(position));
        tv.setPadding(20, 20, 20, 20);
        tv.setTextSize(18f);
        Random random = new Random();
        int red = random.nextInt(180);
        int green = random.nextInt(180);
        int blue = random.nextInt(180);
        tv.setTextColor(Color.rgb(red, green, blue));
        return tv;
    }
}
