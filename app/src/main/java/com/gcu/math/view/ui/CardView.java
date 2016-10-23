package com.gcu.math.view.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gcu.math.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Martin on 2016/9/4.
 */
public class CardView extends LinearLayout {

    private Drawable image;
    private String text;

    private CircleImageView mImageView;
    private TextView mTextView;
    private int mTextColor;

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CardView);
        image = ta.getDrawable(R.styleable.CardView_image);
        text = ta.getString(R.styleable.CardView_text);
        mTextColor = ta.getColor(R.styleable.CardView_textColor, ContextCompat.getColor(context, R.color.textColor));
        ta.recycle();
        setPadding(0, 10, 0, 0);
        setOrientation(VERTICAL);
        mImageView = new CircleImageView(context);
        mImageView.setImageDrawable(image);
        LayoutParams imageParams = new LayoutParams(getResources().getDimensionPixelOffset(R.dimen.cardView_image_width), getResources().getDimensionPixelOffset(R.dimen.cardView_image_height));
        imageParams.gravity = Gravity.CENTER;

        mTextView = new TextView(context);
        mTextView.setText(text);
        mTextView.setTextColor(mTextColor);
        LayoutParams textParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textParams.gravity = Gravity.CENTER;
        mTextView.setPadding(0, 10, 0, 0);
        addView(mImageView, imageParams);
        addView(mTextView, textParams);
        setBackgroundResource(R.drawable.simple_background);
    }
}
