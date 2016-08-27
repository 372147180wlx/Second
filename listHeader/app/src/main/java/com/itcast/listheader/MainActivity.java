package com.itcast.listheader;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.itcast.ui.LVAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private ViewPager vp;
    private int[] image = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};
    private List imagelist = new ArrayList();
    private List<String> contentlist = new ArrayList();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //切换下一页
            vp.setCurrentItem(vp.getCurrentItem() + 1);
            //继续发送空消息
            handler.sendEmptyMessageDelayed(0, 2000);
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        init();
        lv = (ListView) findViewById(R.id.lv);
        //添加头布局
        addHeader();
        //ListView填充数据
        lv.setAdapter(new LVAdapter(contentlist, this));
    }

    /**
     * 初始化数据
     */
    private void init() {
        for (int i = 0; i < image.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(image[i]);
            imagelist.add(iv);
        }
        for (int i = 10; i < 100; i++) {
            contentlist.add("条目 " + i);
        }
    }

    /**
     * 添加头部
     */
    protected void addHeader() {
        View headerView = View.inflate(this, R.layout.layout_home_header, null);
        vp = (ViewPager) headerView.findViewById(R.id.viewPager);
        //根据图片的宽高比，去动态设定viewPager的高度，让它的宽高比和图片能保持一致
        //1.获取屏幕的宽度
        int width = getWindowManager().getDefaultDisplay().getWidth();
        //2.根据图片的宽高比获取对应的高度,(宽高比是2.65)
        float height = width / 1.9f;
        //3.将高度设置给viewPager
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) vp.getLayoutParams();
        params.height = (int) height;
        vp.setLayoutParams(params);
        //viewPager填充数据
        vp.setAdapter(new VPAdapter(imagelist, this));
        //设置viewPager初始位置
        vp.setCurrentItem(Integer.MAX_VALUE * imagelist.size() / 2);
        //ListView添加头
        lv.addHeaderView(headerView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //ViewPager轮播启动
        handler.sendEmptyMessageDelayed(0, 2000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //移除消息
        handler.removeMessages(0);
    }
}
