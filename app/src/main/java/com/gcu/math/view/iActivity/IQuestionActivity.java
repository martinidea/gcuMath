package com.gcu.math.view.iActivity;

import com.gcu.math.model.bean.Question;
import com.gcu.math.model.bean.User;
import com.gcu.math.view.IAdapterView;

/**
 * Created by Martin on 2016/10/10.
 */
public interface IQuestionActivity extends IAdapterView {
    Question getQuestion();
    User getUser();
}
