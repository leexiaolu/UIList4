package com.example.leesnriud.uilist4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * android viewflipper
 * <p>
 * setInAnimation：设置View进入屏幕时使用的动画
 * setOutAnimation：设置View退出屏幕时使用的动画
 * showNext：调用该方法来显示ViewFlipper里的下一个View
 * showPrevious：调用该方法来显示ViewFlipper的上一个View
 * setFilpInterval：设置View之间切换的时间间隔
 * setFlipping：使用上面设置的时间间隔来开始切换所有的View，切换会循环进行
 * stopFlipping：停止View切换
 * <p>
 * 两种使用方式
 * 静态导入  通过xml 使用include
 * 动态导入  通过java 实例化一个viewflipper addview方法
 */
public class ViewFilpperActivity extends AppCompatActivity {

    @BindView(R.id.vf_viewfilpper)
    ViewFlipper vfViewfilpper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_filpper);
        ButterKnife.bind(this);
        vfViewfilpper.startFlipping();
    }
}
