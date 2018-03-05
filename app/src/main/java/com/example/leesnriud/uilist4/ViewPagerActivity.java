package com.example.leesnriud.uilist4;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * android viewpager
 *
 */
public class ViewPagerActivity extends AppCompatActivity {


    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;

    @BindView(R.id.vp_viewpager_one)
    ViewPager vpViewpagerOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);

        aList = new ArrayList<View>();
        LayoutInflater layoutInflater = getLayoutInflater();
        aList.add(layoutInflater.inflate(R.layout.layout_pager_one,null,false));
        aList.add(layoutInflater.inflate(R.layout.layout_pager_two,null,false));
        aList.add(layoutInflater.inflate(R.layout.layout_pager_three,null,false));

        mAdapter = new MyPagerAdapter(aList);
        vpViewpagerOne.setAdapter(mAdapter);
    }
}
