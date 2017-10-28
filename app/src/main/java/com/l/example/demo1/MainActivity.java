package com.l.example.demo1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.l.example.adapters_activity.AdaptersActivity;

import base.BaseActivity;
import butterknife.OnClick;

/**
 * 圆形图片、广告
 */
public class MainActivity extends BaseActivity {

    private String TAG = "123";

    private boolean aBoolean = true;
//    @BindView(R.id.btn1)
//    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(MainActivity.this);

    }


    @OnClick({R.id.btn_adapter, R.id.tv1})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.btn_adapter:
                Log.i(TAG, "onclick: ");
                startActivity(AdaptersActivity.class);
                break;
            case R.id.tv1:
                Toast.makeText(MainActivity.this, "666", Toast.LENGTH_SHORT).show();
                break;
            /**
             * 包括自定义view
             */
            case R.id.btn_customview:
                startActivity(CustomViewActivity.class);
                break;
        }
    }

}
