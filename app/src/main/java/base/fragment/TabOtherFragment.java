package base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.l.example.demo1.R;

/**
 * Created by wl
 * On 2018/4/2
 * Describe:
 */

public class TabOtherFragment extends Fragment{
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(mContext).inflate(R.layout.activity_main,null);
//        return super.onCreateView(inflater, container, savedInstanceState);
        TextView textView = new TextView(mContext);
        textView.setText("ksldjflas");
        return textView;
    }
}
