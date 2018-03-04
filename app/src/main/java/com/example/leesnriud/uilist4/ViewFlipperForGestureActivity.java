package com.example.leesnriud.uilist4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewFlipperForGestureActivity extends AppCompatActivity {

    private int[] resId = {R.mipmap.page_hello_one,R.mipmap.page_hello_two,
            R.mipmap.page_hello_three};

    private final static int MIN_MOVE = 200;   //最小距离
    private MyGestureListener mgListener;
    private GestureDetector mDetector;

    @BindView(R.id.vf_viewflipperforgesture)
    ViewFlipper vfViewflipperforgesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper_for_gesture);
        ButterKnife.bind(this);
        //实例化SimpleOnGestureListener与GestureDetector对象
        mgListener = new MyGestureListener();
        mDetector = new GestureDetector(this, mgListener);
        //动态导入添加子View
        for(int i = 0;i < resId.length;i++){
            vfViewflipperforgesture.addView(getImageView(resId[i]));
        }

    }

    //重写onTouchEvent触发MyGestureListener里的方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }


    //自定义一个GestureListener
    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
            if(e1.getX() - e2.getX() > MIN_MOVE){
                vfViewflipperforgesture.setInAnimation(ViewFlipperForGestureActivity.this,R.anim.right_in);
                vfViewflipperforgesture.setOutAnimation(ViewFlipperForGestureActivity.this, R.anim.right_out);
                vfViewflipperforgesture.showNext();
            }else if(e2.getX() - e1.getX() > MIN_MOVE){
                vfViewflipperforgesture.setInAnimation(ViewFlipperForGestureActivity.this,R.anim.left_in);
                vfViewflipperforgesture.setOutAnimation(ViewFlipperForGestureActivity.this, R.anim.left_out);
                vfViewflipperforgesture.showPrevious();
            }
            return true;
        }
    }

    private ImageView getImageView(int resId){
        ImageView img = new ImageView(this);
        img.setBackgroundResource(resId);
        return img;
    }

}
