package com.gcu.math.presenter.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.gcu.math.R;
import com.gcu.math.view.fragment.HotFragment;
import com.gcu.math.view.fragment.SectionFragment;
import com.gcu.math.view.iFragment.ITalkFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 2016/9/4.
 */
public class TalkPresenter {
    private static TalkPresenter instance = null;
    private FragmentManager manager;
    private List<Fragment> fragments = new ArrayList<>();
    private ITalkFragment iView;

    public TalkPresenter(ITalkFragment iView) {
        this.iView = iView;
        manager = iView.getManager();
        init();
    }

    private void init() {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragments.add(new HotFragment());
        fragments.add(new SectionFragment());
        for (Fragment f : fragments) {
            fragmentTransaction.add(R.id.fragment_frame,f);
        }
        fragmentTransaction.commit();
        show(1);
    }

    private void show(int index) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        hideAll();
        fragmentTransaction.show(fragments.get(index));
        fragmentTransaction.commit();
    }

    public void radioChange(int checkedId) {
        switch (checkedId) {
            case R.id.radio_hot:
                show(0);
                break;
            case R.id.radio_classify:
                show(1);
                break;
        }
    }

    private void hideAll() {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        for (Fragment f : fragments) {
            fragmentTransaction.hide(f);
        }
        fragmentTransaction.commit();
    }

}
