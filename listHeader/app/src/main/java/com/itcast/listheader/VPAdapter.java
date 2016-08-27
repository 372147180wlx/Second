package com.itcast.listheader;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by lingxin on 2016/8/13.
 */
public class VPAdapter extends PagerAdapter {
    private List<ImageView> list;
    private Context context;

    public VPAdapter(List imagelist, Context context) {
        list = imagelist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE * list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = (ImageView) list.get(position % list.size());
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
