package com.juntai.look.mine.devManager.shareToAccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;

/**
 * @aouther tobato
 * @description 描述  添加账号分享
 * @date 2020/9/14 17:49
 */
public class AddAccountToShareActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView, View.OnClickListener {

    /**
     * 29374237492374973449
     */
    private TextView mSharedAccountValueTv;
    /**
     * 全时段
     */
    private TextView mSharedTimeValueTv;
    /**
     * 肯德基法兰
     */
    private TextView mSharedPermissionTv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_add_account;
    }

    @Override
    public void initView() {
        setTitleName("分享账号添加");
        mSharedAccountValueTv = (TextView) findViewById(R.id.shared_account_value_tv);
        mSharedTimeValueTv = (TextView) findViewById(R.id.shared_time_value_tv);
        mSharedPermissionTv = (TextView) findViewById(R.id.shared_permission_tv);
        mSharedPermissionTv.setOnClickListener(this);
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
            case R.id.shared_permission_tv:
                //分享权限
                startActivity(new Intent(mContext,SharePermissionActivity.class));
                break;
        }
    }
}
