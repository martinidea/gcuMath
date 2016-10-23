package com.gcu.math.presenter.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gcu.math.Constants;
import com.gcu.math.R;
import com.gcu.math.base.HeadViewAdapter;
import com.gcu.math.base.ViewHolder;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.base.util.HeadImageUtils;
import com.gcu.math.base.util.LogUtil;
import com.gcu.math.base.util.TimeUtil;
import com.gcu.math.model.bean.Question;
import com.gcu.math.model.bean.User;
import com.gcu.math.model.impl.QuestionBiz;
import com.gcu.math.view.iActivity.IQuestionActivity;

import org.json.JSONObject;
import org.sufficientlysecure.htmltextview.HtmlTextView;

/**
 * Created by Martin on 2016/10/10.
 */
public class QuestionPresenter {
    private IQuestionActivity iView;
    private HeadViewAdapter adapter;
    private QuestionBiz biz;
    private Question question;
    private User user;

    private SimpleDraweeView image;
    private TextView author;
    private TextView time;
    private TextView title;
    private WebView htmlView;
    private TextView section;

    public QuestionPresenter(final IQuestionActivity iView) {
        this.iView = iView;
        question = iView.getQuestion();
        user = iView.getUser();
        biz = new QuestionBiz();
        LogUtil.e(question.get_id().get$oid());
        biz.setQuestion_id(question.get_id().get$oid());
        biz.getReplyList(new NetCallBackJson() {
            @Override
            public void onMySuccess(int statusCode, JSONObject response) {
                iView.setRefreshFinish();
            }

            @Override
            public void onMyFailure(String errorResponse) {

            }
        });
        adapter = new HeadViewAdapter(iView.getContext(), R.layout.item_reply, R.layout.head_view_question) {
            @Override
            public void convertHead(ViewHolder holder) {
                image = holder.getView(R.id.image_head);
                author = holder.getView(R.id.text_author);
                time = holder.getView(R.id.text_time);
                title = holder.getView(R.id.text_title);
                htmlView = holder.getView(R.id.html_text_view);
                section = holder.getView(R.id.text_section);
                image.setImageURI(HeadImageUtils.getImageHead(user.getUser_id()));
                author.setText(question.getTitle());
                time.setText(getContext().getString(R.string.ask_in)
                        + TimeUtil.toDate(question.getTime()));
                title.setText(question.getTitle());
                htmlView.getSettings().setJavaScriptEnabled(true);
                htmlView.setWebViewClient(new WebViewClient());
                htmlView.setWebChromeClient(new WebChromeClient());
//                htmlView.loadUrl("http://www.baidu.com");
                htmlView.loadUrl(Constants.HttpPath.QUESTION+"/"+question.get_id().get$oid()+".html");
//                htmlView.setHtml(question.getSummary(), new HtmlHttpImageGetter(htmlView));
                section.setText(question.getSection_name());
            }

            @Override
            public void convert(ViewHolder holder, Object data) {
                SimpleDraweeView image = holder.getView(R.id.image_head);
                TextView author = holder.getView(R.id.text_author);
                TextView time = holder.getView(R.id.text_time);
                HtmlTextView htmlView = holder.getView(R.id.html_text_view);
            }
        };
        iView.setRefreshStart();
        iView.setLayoutManager(new LinearLayoutManager(iView.getContext()));
        iView.setAdapter(adapter);
    }

    public void refresh() {

    }

    public void load() {
    }
}
