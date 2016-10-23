package com.gcu.math.presenter.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.gcu.math.R;
import com.gcu.math.view.iActivity.IMainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 2016/8/31.
 */
public class MainPresenter extends FragmentPagerAdapter {
    private IMainActivity iView;
    private List<Fragment> fragments;

    public MainPresenter(IMainActivity iView) {
        super(iView.getManager());
        this.iView = iView;
        this.fragments = new ArrayList<>();
    }

    public void add(Fragment fragment) {
        fragments.add(fragment);
    }

    public void pagerChange(int position) {
        iView.pagerChange(position);
    }

    public void radioChange(int checkedId) {
        switch (checkedId) {
            case R.id.radio_home:
                iView.setCurrentItem(0, false);
                iView.showStatusBar(true);
                break;
            case R.id.radio_talk:
                iView.setCurrentItem(1, false);
                iView.showStatusBar(true);
                break;
            case R.id.radio_myself:
                iView.setCurrentItem(2, false);
                iView.showStatusBar(false);
                break;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
