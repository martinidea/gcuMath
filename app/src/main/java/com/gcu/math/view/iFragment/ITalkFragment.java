package com.gcu.math.view.iFragment;

import android.support.v4.app.FragmentManager;
import android.widget.RadioGroup;

import com.gcu.math.base.IView;

/**
 * Created by Martin on 2016/9/4.
 */
public interface ITalkFragment extends IView,RadioGroup.OnCheckedChangeListener{
    FragmentManager getManager();
}
