package com.juntai.look.homePage.mydevice.allGroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDevAdapter;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.wisdom.basecomponent.base.BaseMvpActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * @aouther tobato
 * @description 描述  全部分组
 * @date 2020/8/30 16:34
 */
public class AllGroupsActivity extends BaseMvpActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {

    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.dev_content;
    }

    @Override
    public void initView() {
        setTitleName("全部分组");
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        AllGroupAdapter adapter = new AllGroupAdapter(R.layout.my_group_item);
        GridLayoutManager manager = new GridLayoutManager(mContext,3);
        mRecyclerview.setAdapter(adapter);
        mRecyclerview.setLayoutManager(manager);
        adapter.setNewData(getTestData());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext,GroupSetActivity.class));
            }
        });
    }

    @Override
    public void initData() {

    }


    @Override
    public void onSuccess(String tag, Object o) {

    }
}
