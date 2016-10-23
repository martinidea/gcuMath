package com.gcu.math.view.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gcu.math.R;
import com.gcu.math.base.util.StringUtils;

/**
 * Created by Martin on 2016/9/8.
 */
public class FileView extends RelativeLayout {

    private String fileSize;
    private String fileName;
    private String uploader;
    private String updateTime;

    private ImageView mFileImageView;
    private TextView mFileNameTextView;
    private TextView mFileSizeTextView;
    private TextView mUploaderTextView;
    private TextView mUpdateTimeTextView;
    private View mLine;
    private int marginLeft;
    private boolean hasLine;
    private FileEnum mFileEnum;
    private String from;
    private String buttonText;
    private Button mButton;

    public FileView(Context context) {
        this(context, null);
    }

    public FileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FileView);
        fileName = ta.getString(R.styleable.FileView_fileName);
        fileSize = ta.getString(R.styleable.FileView_fileSize);
        uploader = ta.getString(R.styleable.FileView_uploader);
        updateTime = ta.getString(R.styleable.FileView_updateTime);
        hasLine = ta.getBoolean(R.styleable.FileView_hasLine, true);
        buttonText = ta.getString(R.styleable.FileView_buttonText);
        ta.recycle();

        marginLeft = getResources().getDimensionPixelOffset(R.dimen.fileView_marginLeft);
        from = " " + getResources().getString(R.string.from);
        setBackgroundResource(R.drawable.simple_background);

        if (hasLine) createLine(context);
        ensureFileImage(context);
        ensureFileName(context);
        ensureFileSize(context);
        ensureFileUploader(context);
        ensureFileUpdateTime(context);
        ensureButton(context);
    }

    private void ensureButton(Context context) {
        mButton = new Button(context);
        mButton.setBackgroundResource(R.drawable.button_bg);
        mButton.setText(buttonText);
        mButton.setTextColor(ContextCompat.getColor(context, R.color.button_text_color));
        int width = getResources().getDimensionPixelOffset(R.dimen.fileView_button_width);
        int height = getResources().getDimensionPixelOffset(R.dimen.fileView_button_height);
        LayoutParams params = new LayoutParams(width, height);
        params.addRule(ALIGN_PARENT_RIGHT);
        params.addRule(ALIGN_PARENT_BOTTOM);
        params.bottomMargin = 10;
        params.rightMargin = getResources().getDimensionPixelOffset(R.dimen.fileView_button_marginRight);
        addView(mButton, params);
    }

    private void createLine(Context context) {
        mLine = new View(context);
        mLine.setBackgroundColor(ContextCompat.getColor(context, R.color.line_color));
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                getResources().getDimensionPixelSize(R.dimen.line_height));
        params.addRule(ALIGN_PARENT_BOTTOM);
        addView(mLine, params);
    }

    private void setFileImage() {
        if (mFileImageView == null)
            ensureFileUploader(getContext());
        switch (mFileEnum) {
            case WORD:
                mFileImageView.setImageResource(R.mipmap.word);
                break;
            case EXCEL:
                mFileImageView.setImageResource(R.mipmap.excel);
                break;
            case PPT:
                mFileImageView.setImageResource(R.mipmap.ppt);
                break;
            case PDF:
                mFileImageView.setImageResource(R.mipmap.pdf);
                break;
            case OTHER:
                mFileImageView.setImageResource(R.mipmap.other);
                break;
        }
    }

    private void ensureFileImage(Context context) {
        mFileImageView = new ImageView(context);
        mFileImageView.setId(R.id.file_image);
        int width = getResources().getDimensionPixelOffset(R.dimen.fileImage_width);
        int height = getResources().getDimensionPixelOffset(R.dimen.fileImage_height);
        LayoutParams params = new LayoutParams(width, height);
        params.addRule(ALIGN_PARENT_LEFT);
        params.addRule(CENTER_VERTICAL);
        params.leftMargin = marginLeft;
        params.rightMargin = getResources().getDimensionPixelOffset(R.dimen.fileImage_marginRight);
        addView(mFileImageView, params);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        if (mFileNameTextView == null) {
            final Context context = getContext();
            ensureFileName(context);
            return;
        }
        mFileNameTextView.setText(fileName);
        resetFileImage();
    }

    private void ensureFileName(Context context) {
        mFileNameTextView = new TextView(context);
        mFileNameTextView.setText(fileName);
        mFileNameTextView.setId(R.id.file_name);
        mFileNameTextView.setTextSize(16);
        mFileNameTextView.setPadding(0, 4, 0, 0);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RIGHT_OF, mFileImageView.getId());
        params.addRule(ALIGN_TOP, mFileImageView.getId());
        addView(mFileNameTextView, params);
        resetFileImage();
    }

    private void resetFileImage() {
        String endPointName = StringUtils.endPoint(fileName);
        if (endPointName.equalsIgnoreCase(".doc") || endPointName.equalsIgnoreCase(".docx")) {
            mFileEnum = FileEnum.WORD;
        } else if (endPointName.equalsIgnoreCase(".xls") || endPointName.equalsIgnoreCase(".xlsx")) {
            mFileEnum = FileEnum.EXCEL;
        } else if (endPointName.equalsIgnoreCase(".ppt") || endPointName.equalsIgnoreCase(".pptx")) {
            mFileEnum = FileEnum.PPT;
        } else if (endPointName.equalsIgnoreCase(".pdf")) {
            mFileEnum = FileEnum.PDF;
        } else {
            mFileEnum = FileEnum.OTHER;
        }
        setFileImage();
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
        if (mFileSizeTextView == null) {
            final Context context = getContext();
            ensureFileSize(context);
            return;
        }
        mFileSizeTextView.setText(fileSize + from);
    }

    private void ensureFileSize(Context context) {
        mFileSizeTextView = new TextView(context);
        mFileSizeTextView.setTextColor(ContextCompat.getColor(context, R.color.fileView_text_info));
        if (fileSize != null) {
            mFileSizeTextView.setText(fileSize + from);
        }
        mFileSizeTextView.setId(R.id.file_size);
        mFileSizeTextView.setPadding(0, 4, 0, 0);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RIGHT_OF, mFileImageView.getId());
        params.addRule(BELOW, mFileNameTextView.getId());
        addView(mFileSizeTextView, params);
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
        if (mFileSizeTextView == null) {
            final Context context = getContext();
            ensureFileUploader(context);
            return;
        }
        mUpdateTimeTextView.setText(uploader);
    }

    private void ensureFileUploader(Context context) {
        mUploaderTextView = new TextView(context);
        mUploaderTextView.setText(uploader);
        mUploaderTextView.setTextColor(ContextCompat.getColor(context, R.color.fileView_upLoader));
        mUploaderTextView.setPadding(2, 4, 0, 0);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RIGHT_OF, mFileSizeTextView.getId());
        params.addRule(BELOW, mFileNameTextView.getId());
        addView(mUploaderTextView, params);
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        if (mUpdateTimeTextView == null) {
            final Context context = getContext();
            ensureFileUpdateTime(context);
            return;
        }
        mUpdateTimeTextView.setText(updateTime);
    }

    private void ensureFileUpdateTime(Context context) {
        mUpdateTimeTextView = new TextView(context);
        mUpdateTimeTextView.setTextColor(ContextCompat.getColor(context, R.color.fileView_text_info));
        mUpdateTimeTextView.setText(updateTime);
        mUpdateTimeTextView.setPadding(0, 4, 0, 0);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RIGHT_OF, mFileImageView.getId());
        params.addRule(BELOW, mFileSizeTextView.getId());
        addView(mUpdateTimeTextView, params);
    }

    public enum FileEnum {
        WORD,
        EXCEL,
        PPT,
        PDF,
        OTHER
    }
}
