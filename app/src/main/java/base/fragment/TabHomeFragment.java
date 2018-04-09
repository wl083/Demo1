package base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.l.example.adapters_activity.AdaptersActivity;
import com.l.example.demo1.CustomViewActivity;
import com.l.example.demo1.MainActivity;
import com.l.example.demo1.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ui.net_request.NetrequestActivity;

/**
 * Created by wl
 * On 2018/4/2
 * Describe:
 */

public class TabHomeFragment extends BaseFragment implements View.OnClickListener{
    private Context mContext;

    private String TAG = "123";
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(mContext).inflate(R.layout.activity_main,container,false);
//        return super.onCreateView(inflater, container, savedInstanceState);
        view.findViewById(R.id.btn_adapter).setOnClickListener(this);
        view.findViewById(R.id.tv1).setOnClickListener(this);
        view.findViewById(R.id.btn_customview).setOnClickListener(this);
        view.findViewById(R.id.btn_net_request_test).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_adapter:
                Log.i(TAG, "onclick: ");
                startActivity(mContext,AdaptersActivity.class);
                break;
            case R.id.tv1:
                Toast.makeText(mContext, "666", Toast.LENGTH_SHORT).show();
                break;
            /**
             * 包括自定义view
             */
            case R.id.btn_customview:
                startActivity(mContext,CustomViewActivity.class);
                break;
            case R.id.btn_net_request_test:         // 网络请求 demo
                startActivity(mContext,NetrequestActivity.class);
                break;
        }
    }
}
