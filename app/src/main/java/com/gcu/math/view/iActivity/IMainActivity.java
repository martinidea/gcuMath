package com.gcu.math.view.iActivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.gcu.math.base.IView;

/**
 * Created by Martin on 2016/9/4.
 */
public interface IMainActivity extends IView ,RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{
    FragmentManager getManager();
    void setCurrentItem(int item, boolean smoothScroll);
    void pagerChange(int position);
    void showStatusBar(boolean show);
}
