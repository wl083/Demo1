package com.l.example.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.l.example.demo1.img.ImgActivity;

import base.BaseActivity;
import customview.EmptyActivity;
import customview.GuaGuaKaActivity;

/**
 * Created by l on 2017/2/13.
 *
 * 功能：刮刮卡、圆形图片；
 */
public class CustomViewActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);

    }

    public void onClick(View view) {
        switch (view.getId()){
            /**
             * 呱呱卡效果
             */
            case R.id.btn_adapter:
                startActivity(GuaGuaKaActivity.class);
                break;
            /**
             * 圆形图片效果
             */
            case R.id.btn_customview:
                startActivity(ImgActivity.class);
                break;

            case R.id.btn_empty_view:
//                startActivity(new Intent(CustomViewActivity.this, EmptyActivity.class));
//                startActivity(EmptyActivity.class);
                startActivity(EmptyActivity.class);
                break;
        }
    }
}
