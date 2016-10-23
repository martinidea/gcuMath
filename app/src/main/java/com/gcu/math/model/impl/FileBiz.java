package com.gcu.math.model.impl;

import com.gcu.math.Constants;
import com.gcu.math.base.net.HttpClientUtils;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.model.biz.IFileBiz;

/**
 * Created by Martin on 2016/10/18.
 */
public class FileBiz implements IFileBiz {
    @Override
    public void getFileSuccess(NetCallBackJson netCallBackJson) {
        HttpClientUtils.Get(Constants.HttpPath.FILE_LIST_SUCCESS, netCallBackJson);
    }
}
