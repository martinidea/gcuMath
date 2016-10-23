package com.gcu.math.view.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.presenter.activity.MainPresenter;
import com.gcu.math.view.fragment.HomeFragment;
import com.gcu.math.view.fragment.MyselfFragment;
import com.gcu.math.view.fragment.TalkFragment;
import com.gcu.math.view.iActivity.IMainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements IMainActivity {


    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.radio_home)
    RadioButton radioHome;
    @BindView(R.id.radio_talk)
    RadioButton radioTalk;
    @BindView(R.id.radio_myself)
    RadioButton radioMyself;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    private long exitTime = 0;
    private MainPresenter presenter;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private void init() {
        presenter = new MainPresenter(this);
        presenter.add(new HomeFragment());
        presenter.add(new TalkFragment());
        presenter.add(new MyselfFragment());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(presenter);
        radioGroup.setOnCheckedChangeListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        viewPager.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void pagerChange(int position) {
        switch (position) {
            case 0:
                radioHome.setChecked(true);
                break;
            case 1:
                radioTalk.setChecked(true);
                break;
            case 2:
                radioMyself.setChecked(true);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void showStatusBar(boolean show) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (show) {
                getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
//            getWindow().setFlags(0, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            } else {
                getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.statusColor));
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            // System.currentTimeMillis()无论何时调用，肯定大于2000
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                showToast(getString(R.string.click_again_exit));
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public FragmentManager getManager() {
        return getSupportFragmentManager();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        presenter.radioChange(checkedId);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        presenter.pagerChange(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
