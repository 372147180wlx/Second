package com.itcast.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itcast.listheader.R;

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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_list, null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        //给textView设置参数
        holder.tv.setText(list.get(position));
        holder.tv.setGravity(Gravity.CENTER_VERTICAL);
        holder.tv.setPadding(20, 20, 20, 20);
        Random random = new Random();
        int red = random.nextInt(180);
        int green = random.nextInt(180);
        int blue = random.nextInt(180);
        holder.tv.setTextColor(Color.rgb(red, green, blue));

        //平移动画
        TranslateAnimation ta = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, //起始x类型
                0,                             //起始x值
                Animation.RELATIVE_TO_SELF,    //结束x类型
                0,                            //结束x值
                Animation.RELATIVE_TO_SELF,    //起始y类型
                1f,                            //起始y值
                Animation.RELATIVE_TO_SELF,    //结束y类型
                0);                        //结束y值
        //动画播放的时间长度
        ta.setDuration(600);
        //让iv播放aa动画
        convertView.startAnimation(ta);
        return convertView;
    }

    class ViewHolder {
        TextView tv;
    }
}
