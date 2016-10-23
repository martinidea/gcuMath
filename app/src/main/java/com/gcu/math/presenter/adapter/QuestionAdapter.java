package com.gcu.math.presenter.adapter;

import android.content.Context;
import android.text.Html;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gcu.math.R;
import com.gcu.math.base.CommonAdapter;
import com.gcu.math.base.ViewHolder;
import com.gcu.math.base.util.HeadImageUtils;
import com.gcu.math.base.util.TimeUtil;
import com.gcu.math.model.bean.ItemQuestion;

import java.util.List;

/**
 * Created by Martin on 2016/10/9.
 */
public class QuestionAdapter extends CommonAdapter<ItemQuestion> {
    public QuestionAdapter(Context context) {
        super(context, R.layout.item_question);
    }

    public QuestionAdapter(Context context, List<ItemQuestion> datas) {
        super(context, R.layout.item_question, datas);
    }

    @Override
    public void convert(ViewHolder holder, ItemQuestion data) {
        TextView author = holder.getView(R.id.text_author);
        TextView title = holder.getView(R.id.text_title);
        TextView summary = holder.getView(R.id.text_summary);
        TextView time = holder.getView(R.id.text_time);
        SimpleDraweeView head = holder.getView(R.id.image_head);
        author.setText(data.getUser().getReal_name());
        title.setText(data.getData().getTitle());
        summary.setText(Html.fromHtml(data.getData().getSummary()));
        time.setText(getContext().getString(R.string.ask_in) + TimeUtil.toDate(data.getData().getTime()));
        head.setImageURI(HeadImageUtils.getImageHead(data.getUser().getUser_id()));
    }
}
