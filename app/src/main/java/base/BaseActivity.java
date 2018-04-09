package base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/1/10.
 */
public class BaseActivity extends AppCompatActivity{

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bind = ButterKnife.bind(BaseActivity.this);
    }
    protected void showToast(String msg, Context mContext){
        if (msg == null)
            msg = "";
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }
    protected void showToast(String msg){
        if (msg == null)
            msg = "";
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    protected <T> void startActivity(Class<T> cls){
        Intent intent = new Intent();
        intent.setClass(this,cls);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        bind.unbind();
    }
}
