package com.example.leesnriud.uilist4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Android 部分UI
 * Android viewFlipper
 * Android viewPager
 */
public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_viewflipper,R.id.bt_viewflipperforgesture, R.id.bt_viewpager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_viewflipper:
                intent = new Intent(MainActivity.this,ViewFilpperActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_viewflipperforgesture:
                intent = new Intent(MainActivity.this,ViewFlipperForGestureActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_viewpager:
                intent = new Intent(MainActivity.this,ViewPagerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
