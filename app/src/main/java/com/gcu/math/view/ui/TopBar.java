package com.gcu.math.view.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.base.util.LogUtil;

/**
 * Created by Martin on 2016/8/3.
 */
public class TopBar extends RelativeLayout {

    private ImageButton mLeftButton;
    private ImageButton mRightButton;
    private TextView mTitleTextView;
    private TextView mRightTextView;

    private boolean hasLeftButton;
    private boolean hasRightButton;
    private boolean hasTitle;
    private CharSequence mTitleText;
    private int mTitleTextSize;
    private int mTitleTextColor;
    private View mLine;
    private String mRightText;

    private Context mContext;
    private OnClickListener rightTextListener;

    public TopBar(Context context) {
        this(context, null);
    }

    public TopBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        this.mContext = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        hasLeftButton = ta.getBoolean(R.styleable.TopBar_hasLeftButton, true);
        hasRightButton = ta.getBoolean(R.styleable.TopBar_hasRightButton, false);
        hasTitle = ta.getBoolean(R.styleable.TopBar_hasTitle, true);
        mTitleText = ta.getText(R.styleable.TopBar_title);
        mTitleTextSize = ta.getDimensionPixelSize(R.styleable.TopBar_titleSize, 24);
        mTitleTextColor = ta.getColor(R.styleable.TopBar_titleColor,
                ContextCompat.getColor(context, R.color.topBarTitleColor));
        mRightText = ta.getString(R.styleable.TopBar_rightText);
        ta.recycle();

        if (mRightText != null) createRightText(context);
        if (hasLeftButton) createLeftButton(context);
        if (hasTitle) createTextView(context);
        if (hasRightButton) createRightButton(context);

        setBackgroundResource(R.color.TopBarBackground);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, R.attr.actionBarSize);
        mLine = new View(getContext());
        mLine.setBackgroundResource(R.color.line_color);
        LayoutParams lineParams = new LayoutParams(LayoutParams.MATCH_PARENT, getResources().getDimensionPixelSize(R.dimen.line_height));
        lineParams.addRule(ALIGN_PARENT_BOTTOM);
        addView(mLine, lineParams);
        setLayoutParams(params);
    }

    public void setRightButttonImageResource(@DrawableRes int resId) {
        if (mRightButton == null) createRightButton(getContext());
        mRightButton.setImageResource(resId);
    }

    public void setOnRightButtonClickListener(OnClickListener listener) {
        if (mRightButton == null) createRightButton(getContext());
        mRightButton.setOnClickListener(listener);
    }

    public void setTitle(CharSequence title){
        mTitleTextView.setText(title);
    }

    private void createRightText(Context context) {
        mRightTextView = new TextView(context);
        mRightTextView.setText(mRightText);
        mRightTextView.setTextColor(mTitleTextColor);
        mRightTextView.setTextSize(mTitleTextSize);
        mRightTextView.setSingleLine(true);
        mRightTextView.setBackgroundResource(R.drawable.simple_background);
        mRightTextView.setGravity(Gravity.CENTER_VERTICAL);
        mRightTextView.setPadding(30, 0, 10, 0);
        LayoutParams params = generateDefaultLayoutParams();
        params.addRule(ALIGN_PARENT_RIGHT);
        addView(mRightTextView, params);
    }

    public void setOnRightTextClickListener(OnClickListener listener) {
        LogUtil.e((listener==null)+"dsasdsadsas");
        this.rightTextListener = listener;
        if (mRightTextView == null) createRightText(mContext);
        mRightTextView.setOnClickListener(rightTextListener);
    }

    private void createTextView(Context context) {
        mTitleTextView = new TextView(context);
        mTitleTextView.setText(mTitleText);
        mTitleTextView.setTextSize(mTitleTextSize);
        mTitleTextView.setTextColor(mTitleTextColor);
        mTitleTextView.setSingleLine();
        mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        mTitleTextView.setMaxEms(10);
        mTitleTextView.setGravity(Gravity.CENTER);
        final LayoutParams lp = generateDefaultLayoutParams();
        lp.addRule(CENTER_IN_PARENT);
        addView(mTitleTextView, lp);
    }

    private void createRightButton(Context context) {
        mRightButton = new ImageButton(context);
        mRightButton.setBackgroundResource(R.drawable.simple_background);
        mRightButton.setImageResource(R.mipmap.add_btn);
        mRightButton.setPadding(30, 0, 10, 0);
        final LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        lp.addRule(ALIGN_PARENT_RIGHT);
        addView(mRightButton, lp);
    }


    private void createLeftButton(final Context context) {
        mLeftButton = new ImageButton(context);
        mLeftButton.setBackgroundResource(R.drawable.simple_background);
        mLeftButton.setImageResource(R.mipmap.back_btn);
        mLeftButton.setPadding(10, 0, 30, 0);
        final LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        addView(mLeftButton, lp);
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) context).finish();
            }
        });
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
    }


}
