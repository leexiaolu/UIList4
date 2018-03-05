package com.example.leesnriud.uilist4;

import android.os.Bundle;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * android pagertitlestrip 普通文字效果
 *
 */
public class PagerTitleStripActivity extends AppCompatActivity {

    private ArrayList<View> aLists;
    private ArrayList<String> sLists;
    private MyPagerTitleAdapter myPagerTitleAdapter;

    @BindView(R.id.vp_viewpager_title)
    ViewPager vpViewpagerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_title_strip);
        ButterKnife.bind(this);

        aLists = new ArrayList<View>();
        LayoutInflater layoutInflater = getLayoutInflater();
        aLists.add(layoutInflater.inflate(R.layout.layout_pager_one,null,false));
        aLists.add(layoutInflater.inflate(R.layout.layout_pager_two,null,false));
        aLists.add(layoutInflater.inflate(R.layout.layout_pager_three,null,false));

        sLists = new ArrayList<String>();
        sLists.add("111");
        sLists.add("222");
        sLists.add("333");

        myPagerTitleAdapter = new MyPagerTitleAdapter(aLists,sLists);
        vpViewpagerTitle.setAdapter(myPagerTitleAdapter);
    }
}
