package com.example.leesnriud.uilist4;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * android viewpager 实现tabhost 效果
 *
 * flipInterval 指定view动画间的时间间隔
 * persistentDrawingCache 设置控件的缓存策略
 *  none 不在内存中保存绘图缓存
 *  animation 只保存动画绘图缓存
 *  scrolling 只保存滚动效果绘图缓存
 *  all 所有绘图都缓存
 *  可以同时选择两个 用 | 分开
 *
 */
public class TabhostActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ArrayList<View> listViews;
    private int offset = 0;//移动条图片的偏移量
    private int currIndex = 0;//当前页面的编号
    private int bmpWidth;// 移动条图片的长度
    private int one = 0; //移动条滑动一页的距离
    private int two = 0; //滑动条移动两页的距离

    @BindView(R.id.img_cursor)
    ImageView imgCursor;
    @BindView(R.id.vpager_tabhost)
    ViewPager vpagerTabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);
        ButterKnife.bind(this);

        //下划线动画的相关设置：
        bmpWidth = BitmapFactory.decodeResource(getResources(), R.mipmap.line).getWidth();// 获取图片宽度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        offset = (screenW / 3 - bmpWidth) / 2;// 计算偏移量
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        imgCursor.setImageMatrix(matrix);// 设置动画初始位置
        //移动的距离
        one = offset * 2 + bmpWidth;// 移动一页的偏移量,比如1->2,或者2->3
        two = one * 2;// 移动两页的偏移量,比如1直接跳3


        //往ViewPager填充View，同时设置点击事件与页面切换事件
        listViews = new ArrayList<View>();
        LayoutInflater mInflater = getLayoutInflater();
        listViews.add(mInflater.inflate(R.layout.layout_pager_one, null, false));
        listViews.add(mInflater.inflate(R.layout.layout_pager_two, null, false));
        listViews.add(mInflater.inflate(R.layout.layout_pager_three, null, false));

        vpagerTabhost.setAdapter(new MyPagerAdapter(listViews));
        vpagerTabhost.setCurrentItem(0);          //设置ViewPager当前页，从0开始算

        vpagerTabhost.addOnPageChangeListener(this);

    }

    @OnClick({R.id.tv_one, R.id.tv_two, R.id.tv_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_one:
                vpagerTabhost.setCurrentItem(0);
                break;
            case R.id.tv_two:
                vpagerTabhost.setCurrentItem(1);
                break;
            case R.id.tv_three:
                vpagerTabhost.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int index) {
        Animation animation = null;
        switch (index) {
            case 0:
                if (currIndex == 1) {
                    animation = new TranslateAnimation(one, 0, 0, 0);
                } else if (currIndex == 2) {
                    animation = new TranslateAnimation(two, 0, 0, 0);
                }
                break;
            case 1:
                if (currIndex == 0) {
                    animation = new TranslateAnimation(offset, one, 0, 0);
                } else if (currIndex == 2) {
                    animation = new TranslateAnimation(two, one, 0, 0);
                }
                break;
            case 2:
                if (currIndex == 0) {
                    animation = new TranslateAnimation(offset, two, 0, 0);
                } else if (currIndex == 1) {
                    animation = new TranslateAnimation(one, two, 0, 0);
                }
                break;
        }
        currIndex = index;
        animation.setFillAfter(true);// true表示图片停在动画结束位置
        animation.setDuration(300); //设置动画时间为300毫秒
        imgCursor.startAnimation(animation);//开始动画
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
