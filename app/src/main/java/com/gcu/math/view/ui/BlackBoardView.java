package com.gcu.math.view.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gcu.math.R;

/**
 * Created by Martin on 2016/9/6.
 */
public class BlackBoardView extends LinearLayout {

    private CharSequence mTitle;
    private String mText;
    private int mTitleColor;
    private TextView titleTextView;
    private TextView mTextView;
    private int mTextColor;

    public BlackBoardView(Context context) {
        this(context, null);
    }

    public BlackBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BlackBoardView);
        mTitle = ta.getText(R.styleable.BlackBoardView_title);
        mText = ta.getString(R.styleable.BlackBoardView_text);
        mTitleColor = ta.getColor(R.styleable.BlackBoardView_titleColor,
                ContextCompat.getColor(context, R.color.blackBoardTitleColor));
        mTextColor = ta.getColor(R.styleable.BlackBoardView_textColor,
                ContextCompat.getColor(context, R.color.blackBoardTextColor));
        ta.recycle();

        titleTextView = new TextView(context);
        titleTextView.setText(mTitle);
        titleTextView.setTextColor(mTitleColor);
        titleTextView.setTextSize(25);
        LayoutParams titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        titleParams.topMargin =
                getResources().getDimensionPixelOffset(R.dimen.blackBoard_title_marginTop);
        titleParams.gravity = Gravity.CENTER_HORIZONTAL;
        addView(titleTextView, titleParams);

        mTextView = new TextView(context);
        mTextView.setTextColor(mTextColor);
        mTextView.setTextSize(18);
        mTextView.setText(mText);
        LayoutParams textParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        textParams.leftMargin =
                getResources().getDimensionPixelOffset(R.dimen.blackBoard_text_marginLeft);
        textParams.rightMargin =   getResources().getDimensionPixelOffset(R.dimen.blackBoard_text_marginRight);
        mTextView.setMaxLines(4);
        mTextView.setEllipsize(TextUtils.TruncateAt.END);
        mTextView.setLineSpacing(3,1);
        mTextView.setSingleLine(false);
        addView(mTextView,textParams);

        setOrientation(VERTICAL);
        setBackgroundResource(R.mipmap.black_board);
    }

    public void setText(CharSequence text){
        mTextView.setText(text);
    }

    public void setTitle(CharSequence title){
        titleTextView.setText(title);
    }
}
