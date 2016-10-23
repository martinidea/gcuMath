package com.gcu.math.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gcu.math.R;
import com.gcu.math.base.BaseFragment;
import com.gcu.math.presenter.fragment.TalkPresenter;
import com.gcu.math.view.iFragment.ITalkFragment;

import butterknife.BindView;

/**
 * Created by Martin on 2016/8/31.
 */
public class TalkFragment extends BaseFragment implements ITalkFragment {


    @BindView(R.id.radio_hot)
    RadioButton radioHot;
    @BindView(R.id.radio_classify)
    RadioButton radioClassify;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.fragment_frame)
    FrameLayout fragmentFrame;

    private TalkPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        presenter = new TalkPresenter(this);
        radioGroup.setOnCheckedChangeListener(this);
        return view;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_talk;
    }

    @Override
    public FragmentManager getManager() {
        return getChildFragmentManager();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        presenter.radioChange(checkedId);
    }
}
