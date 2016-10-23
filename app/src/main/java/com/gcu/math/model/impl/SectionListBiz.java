package com.gcu.math.model.impl;

import com.gcu.math.Constants;
import com.gcu.math.base.net.HttpClientUtils;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.model.biz.ISectionListBiz;

/**
 * Created by Martin on 2016/10/17.
 */
public class SectionListBiz implements ISectionListBiz {
    @Override
    public void getList(final NetCallBackJson listener) {
        HttpClientUtils.Get(Constants.HttpPath.SECTION_LIST, listener);
    }
}
