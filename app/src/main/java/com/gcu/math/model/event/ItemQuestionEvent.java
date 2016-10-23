package com.gcu.math.model.event;

import com.gcu.math.model.bean.ItemQuestion;

/**
 * Created by Martin on 2016/10/17.
 */
public class ItemQuestionEvent {
    ItemQuestion itemQuestion;

    public ItemQuestionEvent(ItemQuestion itemQuestion) {
        this.itemQuestion = itemQuestion;
    }

    public ItemQuestion getItemQuestion() {
        return itemQuestion;
    }

    public void setItemQuestion(ItemQuestion itemQuestion) {
        this.itemQuestion = itemQuestion;
    }
}
