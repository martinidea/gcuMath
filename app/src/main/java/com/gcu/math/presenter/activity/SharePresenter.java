package com.gcu.math.presenter.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.gcu.math.R;
import com.gcu.math.base.CommonAdapter;
import com.gcu.math.base.ViewHolder;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.base.util.DataUtils;
import com.gcu.math.base.util.LogUtil;
import com.gcu.math.model.bean.File;
import com.gcu.math.model.biz.IFileBiz;
import com.gcu.math.model.impl.FileBiz;
import com.gcu.math.view.iActivity.IShareActivity;
import com.gcu.math.view.ui.FileView;

import org.json.JSONObject;

/**
 * Created by Martin on 2016/10/18.
 */
public class SharePresenter {
    private IShareActivity iView;
    private IFileBiz biz;
    private CommonAdapter<File> adapter;

    public SharePresenter(final IShareActivity iView) {
        this.iView = iView;
        biz = new FileBiz();
        adapter = new CommonAdapter<File>(iView.getContext(), R.layout.item_file) {
            @Override
            public void convert(ViewHolder holder, File data) {
                FileView fileView = holder.getView(R.id.file_view);
                fileView.setFileName(data.getFile_name());
                fileView.setUpdateTime(data.getTime());
            }
        };
        biz.getFileSuccess(new NetCallBackJson() {
            @Override
            public void onMySuccess(int statusCode, JSONObject response) {
                adapter.addAll(DataUtils.response2ListT(response, File.class));
                iView.setRefreshFinish();
            }

            @Override
            public void onMyFailure(String errorResponse) {
                iView.setRefreshFinish();
                iView.showToast(errorResponse);
            }
        });
        iView.setRefreshStart();
        iView.setAdapter(adapter);
        iView.setLayoutManager(new LinearLayoutManager(iView.getContext()));
    }

    public void refresh() {
        LogUtil.e("refresh");
        iView.setRefreshFinish();
    }

    public void load() {
        LogUtil.e("load");
        iView.setLoadFinish();
    }
}
