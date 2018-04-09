package base.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by wl
 * On 2018/4/3
 * Describe:
 */

public class BaseFragment extends Fragment {



    protected <T> void startActivity(Context content,Class<T> cls){
        Intent intent = new Intent();
        intent.setClass(content,cls);
        startActivity(intent);
    }
}
