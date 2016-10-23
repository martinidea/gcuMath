package com.gcu.math.view.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gcu.math.R;

/**
 * Created by Martin on 2016/9/4.
 */
public class SoftView extends RelativeLayout {

    private String mText;
    private TextView mTextView;
    private ImageView mImageView;
    private int mTextColor;
    private boolean hasRightButton;
    private boolean hasLine;
    private View line;

    public SoftView(Context context) {
        this(context, null);
    }

    public SoftView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SoftView);
        mText = typedArray.getString(R.styleable.SoftView_text);
        mTextColor = typedArray.getColor(R.styleable.SoftView_textColor,
                ContextCompat.getColor(context, R.color.textColor));
        hasRightButton = typedArray.getBoolean(R.styleable.SoftView_hasRightButton, true);
        hasLine = typedArray.getBoolean(R.styleable.SoftView_hasLine, true);
        typedArray.recycle();

        setBackgroundResource(R.drawable.simple_background);

        if (mText != null) createTextView(context);
        if (hasRightButton) createRightButton(context);
        if (hasLine) createLine(context);
    }

    private void createLine(Context context) {
        line = new View(context);
        line.setBackgroundColor(ContextCompat.getColor(context, R.color.line_color));
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                getResources().getDimensionPixelSize(R.dimen.line_height));
        params.addRule(ALIGN_PARENT_BOTTOM);
        params.leftMargin = getResources().getDimensionPixelOffset(R.dimen.soft_text_marginLeft);
        params.rightMargin =  getResources().getDimensionPixelOffset(R.dimen.soft_next_marginRight);
        addView(line, params);
    }

    private void createTextView(Context context) {
        mTextView = new TextView(context);
        mTextView.setText(mText);
        mTextView.setTextColor(mTextColor);
        LayoutParams textParams =
                new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textParams.addRule(ALIGN_PARENT_LEFT);
        textParams.addRule(CENTER_VERTICAL);
        textParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.soft_text_marginLeft);
        addView(mTextView, textParams);
    }

    private void createRightButton(Context context) {
        mImageView = new ImageView(context);
        mImageView.setImageResource(R.mipmap.next);
        int imageWidth = getResources().getDimensionPixelOffset(R.dimen.soft_next_width);
        int imageHeight = getResources().getDimensionPixelOffset(R.dimen.soft_next_height);
        LayoutParams imageParams = new LayoutParams(imageWidth, imageHeight);
        imageParams.addRule(ALIGN_PARENT_RIGHT);
        imageParams.addRule(CENTER_VERTICAL);
        imageParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.soft_next_marginRight);
        addView(mImageView, imageParams);
    }
}
