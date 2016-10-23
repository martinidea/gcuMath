package com.gcu.math.presenter.adapter;

import android.content.Context;
import android.text.Html;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gcu.math.Constants;
import com.gcu.math.R;
import com.gcu.math.base.HeadViewAdapter;
import com.gcu.math.base.ViewHolder;
import com.gcu.math.base.util.TimeUtil;
import com.gcu.math.model.bean.ItemQuestion;

/**
 * Created by Martin on 2016/10/17.
 */
public abstract class HomeAdapter extends HeadViewAdapter<ItemQuestion> {

    public HomeAdapter(Context context) {
        super(context, R.layout.item_question, R.layout.head_view_home);
    }


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
        head.setImageURI(Constants.HttpPath.HEAD_IMAGE_FIRST + data.getUser().getUser_id()
                + Constants.HttpPath.HEAD_IMAGE_SECOND + data.getUser().getUser_id() + ".png");
    }
}
