package com.gcu.math.view.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gcu.math.R;

/**
 * Created by Martin on 2016/9/4.
 */
public class SoftTextView extends RelativeLayout {

    private String mKeyText;
    private TextView mKeyTextView;
    private int mKeyTextColor;

    private TextView mValueTextView;
    private String mValueText;
    private int mValueTextColor;
    private boolean hasLine;
    private View line;

    public SoftTextView(Context context) {
        this(context, null);
    }

    public SoftTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SoftTextView);
        mKeyText = typedArray.getString(R.styleable.SoftTextView_keyText);
        mKeyTextColor = typedArray.getColor(R.styleable.SoftTextView_keyTextColor,
                ContextCompat.getColor(context, R.color.keyTextColor));

        mValueText = typedArray.getString(R.styleable.SoftTextView_valueText);
        mValueTextColor = typedArray.getColor(R.styleable.SoftTextView_valueTextColor,
                ContextCompat.getColor(context, R.color.valueTextColor));
        hasLine = typedArray.getBoolean(R.styleable.SoftTextView_hasLine, true);
        typedArray.recycle();

        setBackgroundResource(R.drawable.simple_background);

        if (mKeyText != null) createKeyTextView(context);
        if (mValueText != null) createValueTextView(context);
        if (hasLine) createLine(context);
    }

    private void createLine(Context context) {
        line = new View(context);
        line.setBackgroundColor(ContextCompat.getColor(context, R.color.line_color));
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                getResources().getDimensionPixelSize(R.dimen.line_height));
        params.addRule(ALIGN_PARENT_BOTTOM);
        params.leftMargin = getResources().getDimensionPixelOffset(R.dimen.softText_marginLeft);
        params.rightMargin = getResources().getDimensionPixelOffset(R.dimen.softText_marginRight);
        addView(line, params);
    }

    private void createKeyTextView(Context context) {
        mKeyTextView = new TextView(context);
        mKeyTextView.setText(mKeyText);
        mKeyTextView.setTextColor(mKeyTextColor);
        LayoutParams keyParams =
                new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        keyParams.addRule(ALIGN_PARENT_LEFT);
        keyParams.addRule(CENTER_VERTICAL);
        keyParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.softText_marginLeft);
        addView(mKeyTextView, keyParams);
    }


    private void createValueTextView(Context context) {
        mValueTextView = new TextView(context);
        mValueTextView.setText(mValueText);
        mValueTextView.setTextColor(mValueTextColor);
        LayoutParams valueParams =
                new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        valueParams.addRule(ALIGN_PARENT_RIGHT);
        valueParams.addRule(CENTER_VERTICAL);
        valueParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.softText_marginRight);
        addView(mValueTextView, valueParams);
    }

    public void setValue(CharSequence text) {
        if (mValueTextView != null)
            mValueTextView.setText(text);
    }

}
