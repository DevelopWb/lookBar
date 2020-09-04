package com.juntai.look.homePage.mydevice.allGroup.selectGroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.CreateGroupActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * @aouther tobato
 * @description 描述  选择分组
 * @date 2020/9/3 11:33
 */
public class SelectGroupActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {

    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;

    @Override
    protected MyDevicePresent createPresenter() {
        return null;
    }

    @Override
    public int getLayoutView() {
        return R.layout.recycleview_layout;
    }

    @Override
    public void initView() {
        setTitleName("设备分组");
        getTitleRightTv().setText("新建");
        getTitleRightTv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, CreateGroupActivity.class));
            }
        });
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        SelectGroupAdapter adapter = new SelectGroupAdapter(R.layout.select_group_item);
        initRecyclerview(mRecyclerview,adapter, LinearLayoutManager.VERTICAL);
        adapter.setNewData(getTestData());
    }

    @Override
    public void initData() {

    }


    @Override
    public void onSuccess(String tag, Object o) {

    }

}
