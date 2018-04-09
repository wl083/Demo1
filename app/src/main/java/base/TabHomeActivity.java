package base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.l.example.demo1.R;

import base.fragment.TabHomeFragment;
import base.fragment.TabOtherFragment;
import butterknife.BindView;

import static android.R.attr.fragment;

/**
 * Created by wl
 * On 2018/4/2
 * Describe:
 */

public class TabHomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

//    @BindView(R.id.frglayout_tab_home)
    FrameLayout mFrameLayout;

    private RadioGroup radioGroup;
    private RadioButton rbTabHome,rbTabOthers;
    private FragmentManager frgManager;

    private Fragment tabHomeFragment,tabOthersFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_home);

        initView();

        tabHomeFragment = new TabHomeFragment();

        frgManager = getSupportFragmentManager();
        FragmentTransaction transaction = frgManager.beginTransaction();
        transaction.replace(R.id.frglayout_tab_home,tabHomeFragment).commit();
        rbTabHome.setChecked(true);
    }

    private void initView() {
        radioGroup = ((RadioGroup) findViewById(R.id.rg_tab_homea));
        rbTabHome = (RadioButton) findViewById(R.id.rb1_tab_home);
        rbTabOthers = (RadioButton) findViewById(R.id.rb2_tab_home);

        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        FragmentTransaction transaction = frgManager.beginTransaction();
        switch (checkedId){
            case R.id.rb1_tab_home:
                rbTabHome.setChecked(true);
                rbTabOthers.setChecked(false);
                hideFragment(transaction,tabOthersFragment);
                if (tabHomeFragment == null){
                    tabHomeFragment = new TabHomeFragment();
                    transaction.add(R.id.frglayout_tab_home,tabHomeFragment);
                }else{
                    transaction.show(tabHomeFragment);
                }
                break;
            case R.id.rb2_tab_home:
                rbTabHome.setChecked(false);
                rbTabOthers.setChecked(true);
                hideFragment(transaction,tabHomeFragment);
                if (tabOthersFragment == null){
                    tabOthersFragment = new TabOtherFragment();
                    transaction.add(R.id.frglayout_tab_home,tabOthersFragment);
                }else{
                    transaction.show(tabOthersFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction,Fragment fragment) {
        if (fragment != null){
            transaction.hide(fragment);
        }
    }
}
