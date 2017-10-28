package customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.l.example.demo1.R;

import base.BaseActivity;
import customview.utils.EmptyView;

/**
 * Created by stone
 * On 2017/10/28
 * Describe:
 */

public class EmptyActivity extends BaseActivity {


    private EmptyView emptyView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        emptyView = (EmptyView) findViewById(R.id.view_empty);
        emptyView.show();
        findViewById(R.id.btn_default).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyView.hide();
            }
        });

        findViewById(R.id.btn_empty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyView.setType(EmptyView.Type.EMPTY);
            }
        });

        findViewById(R.id.btn_error_common).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyView.setType(EmptyView.Type.ERROR);
            }
        });

        findViewById(R.id.btn_error_net_work).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyView.setType(EmptyView.Type.NO_NETWORK);
            }
        });

    }

}
