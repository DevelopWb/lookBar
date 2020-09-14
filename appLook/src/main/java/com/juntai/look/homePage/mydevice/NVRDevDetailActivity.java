package com.juntai.look.homePage.mydevice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * @aouther tobato
 * @description 描述  nvr详情
 * @date 2020/9/13 15:33
 */
public class NVRDevDetailActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {

    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_devs_of_nvr;
    }

    @Override
    public void initView() {

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        MyDevAdapter adapter = new MyDevAdapter(R.layout.my_dev_item);
        GridLayoutManager manager = new GridLayoutManager(mContext,2);
        mRecyclerview.setAdapter(adapter);
        mRecyclerview.setLayoutManager(manager);
        adapter.setNewData(getTestData());
    }


    @Override
    public void initData() {

    }


    @Override
    public void onSuccess(String tag, Object o) {

    }

}
