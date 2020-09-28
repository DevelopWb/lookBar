package com.juntai.look.mine.devManager.shareToAccount;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.selectGroup.SelectGroupAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * @aouther tobato
 * @description 描述  分享的权限
 * @date 2020/9/14 17:52
 */
public class SharePermissionActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView, View.OnClickListener {
    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    /**
     * 保存
     */
    private TextView mSaveTv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_share_permission;
    }

    @Override
    public void initView() {
        setTitleName("分享权限设置");
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        SelectGroupAdapter adapter = new SelectGroupAdapter(R.layout.select_group_item);
        initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        mSaveTv = (TextView) findViewById(R.id.save_tv);
        mSaveTv.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }


    @Override
    public void onSuccess(String tag, Object o) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.save_tv:
                break;
        }
    }
}
