package ui.net_request;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.toolbox.Volley;
import com.l.example.demo1.R;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wl
 * On 2018/4/4
 * Describe:
 */

public class NetrequestActivity extends BaseActivity {

//    @BindView(R.id.rcy_net_request)
    RecyclerView rcyNetrequest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_request);
//        ButterKnife.bind(this);
    }

//    @OnClick(R.id.btn_volley)
    public void stone(View view){
//        startActivity();
        showToast("dkf");
        startActivity(VolleyActivity.class);
    }
}
